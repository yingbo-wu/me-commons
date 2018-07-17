package cn.rongcapital.mc2.me.commons.infrastructure.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PropertyContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	public static Environment build() {
		return applicationContext.getBean(Environment.class);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		PropertyContext.applicationContext = applicationContext;
	}

}
