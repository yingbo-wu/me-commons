package cn.rongcapital.mc2.me.commons.infrastructure.redisson;

import javax.annotation.PostConstruct;

import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 话题监听器抽象
 * @author 英博
 *
 * @param <T> 话题源类型
 */
public abstract class RedissonEventListener<T extends RedissonEventObject> {

	@Autowired
	private RedissonClient redisson;

	@PostConstruct
	void listen() {
		RTopic<T> rTopic = redisson.getTopic(getEventName().toUpperCase() + "_TOPIC");
		rTopic.addListener(new MessageListener<T>() {
			@Override
			public void onMessage(String channel, T msg) {
				listen(msg);
			}
		});
	}

	public abstract void listen(T event);

	public abstract String getEventName();

}
