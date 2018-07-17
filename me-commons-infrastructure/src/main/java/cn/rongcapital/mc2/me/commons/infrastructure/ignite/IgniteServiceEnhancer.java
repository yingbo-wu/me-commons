package cn.rongcapital.mc2.me.commons.infrastructure.ignite;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class IgniteServiceEnhancer {

	private final static Map<String, Object> CACHE = new ConcurrentHashMap<String, Object>();

	private static IgniteValidationInterceptor validationInterceptor = new IgniteValidationInterceptor();

	private static IgniteValidationPointcut validationPointcut = new IgniteValidationPointcut();

	@SuppressWarnings("unchecked")
	public static <T> T enhance(T obj) {
		Class<?> clazz = obj.getClass();
		String className = clazz.getName();
		if (CACHE.containsKey(className)) {
			return (T) CACHE.get(className);
		}
		ProxyFactory factory = new ProxyFactory(obj);
		factory.addAdvice(validationInterceptor);
		factory.addAdvisor(new DefaultPointcutAdvisor(validationPointcut, validationInterceptor));
		return (T) CACHE.putIfAbsent(className, factory.getProxy());
	}

}
