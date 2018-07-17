package cn.rongcapital.mc2.me.commons.infrastructure.redisson;

import org.redisson.Redisson;
import org.redisson.api.RQueue;
import org.redisson.api.RTopic;

/**
 * 事件发布器, 事件发布器所发布的事件只能被一个消费者消费, 一旦有消费者消费后将不能被其他消费者消费到
 * @author 英博
 *
 */
public class RedissonCommandInvoker {

	/**
	 * 发布事件
	 * @param commandName
	 * @param command
	 */
	public static <T extends RedissonCommandObject> void action(String commandName, T command) {
		Redisson redisson = RedissonFactory.newInstance();
		RTopic<String> rTopic = redisson.getTopic(commandName.toUpperCase() + "_COMMAND");
		RQueue<T> rQueue = redisson.getQueue(commandName.toUpperCase() + "_MQ");
		rQueue.offerAsync(command).thenAcceptAsync(ok -> {
			if (ok) {
				rTopic.publish("ok");
			}
		});
	}

}
