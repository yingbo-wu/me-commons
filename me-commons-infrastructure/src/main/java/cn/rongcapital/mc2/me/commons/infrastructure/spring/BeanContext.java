package cn.rongcapital.mc2.me.commons.infrastructure.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	public static ApplicationContext build() {
		return applicationContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		BeanContext.applicationContext = applicationContext;
	}

}
