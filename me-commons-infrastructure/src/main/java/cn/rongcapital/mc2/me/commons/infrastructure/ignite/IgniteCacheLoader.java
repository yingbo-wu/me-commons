package cn.rongcapital.mc2.me.commons.infrastructure.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.springframework.beans.factory.SmartInitializingSingleton;

import cn.rongcapital.mc2.me.commons.infrastructure.spring.BeanContext;

public class IgniteCacheLoader implements SmartInitializingSingleton {

	private static Ignite igniteInstance;

	public static void load(String cacheName) {
		IgniteCache<Object, ?> igniteCache = igniteInstance.cache(cacheName);
		igniteCache.loadCacheAsync(null, null);
	}

	@Override
	public void afterSingletonsInstantiated() {
		igniteInstance = BeanContext.build().getBean("igniteInstance", Ignite.class);
	}

}
