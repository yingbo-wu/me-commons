package cn.rongcapital.mc2.me.commons.infrastructure.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;

import cn.rongcapital.mc2.me.commons.infrastructure.spring.BeanContext;

public class RedissonFactory {

	public static Redisson newInstance() {
		return (Redisson) BeanContext.build().getBean(RedissonClient.class);
	}

}
