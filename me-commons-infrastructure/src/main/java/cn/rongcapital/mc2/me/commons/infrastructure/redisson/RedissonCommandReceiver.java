package cn.rongcapital.mc2.me.commons.infrastructure.redisson;

import javax.annotation.PostConstruct;

import org.redisson.api.RQueue;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 事件监听器抽象
 * @author 英博
 *
 * @param <T> 事件源类型
 */
public abstract class RedissonCommandReceiver<T extends RedissonCommandObject> {

	@Autowired
	private RedissonClient redisson;

	@PostConstruct
	void listen() {
		RTopic<String> rTopic = redisson.getTopic(getCommandName().toUpperCase() + "_COMMAND");
		RQueue<T> rQueue = redisson.getQueue(getCommandName().toUpperCase() + "_MQ");
		rTopic.addListener(new MessageListener<String>() {
			@Override
			public void onMessage(String channel, String msg) {
				rQueue.pollAsync().thenAcceptAsync(command -> {
					listen(command);
					rQueue.sizeAsync().thenAcceptAsync(size -> {
						if (0 < size) {
							// 第二次poll目的是尝试补偿之前由于系统故障产生的不一致性
							rQueue.pollAsync().thenAcceptAsync(anotherCommand -> {
								listen(anotherCommand);
							});
						}
					});
				});
			}
		});
	}

	public abstract void listen(T command);

	public abstract String getCommandName();

}
