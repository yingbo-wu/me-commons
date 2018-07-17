package cn.rongcapital.mc2.me.commons.infrastructure.redisson;

import org.redisson.Redisson;
import org.redisson.api.RTopic;

/**
 * 话题发布器
 * @author 英博
 *
 */
public class RedissonEventPublisher {

	/**
	 * 发布话题
	 * @param eventName
	 * @param event
	 */
	public static <T extends RedissonEventObject> void publish(String eventName, T event) {
		Redisson redisson = RedissonFactory.newInstance();
		RTopic<T> rTopic = redisson.getTopic(eventName.toUpperCase() + "_TOPIC");
		rTopic.publish(event);
	}

}
