package cn.rongcapital.mc2.me.commons.infrastructure.ignite;

import org.apache.ignite.IgniteSpringBean;
import org.apache.ignite.cluster.ClusterGroup;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

import cn.rongcapital.mc2.me.commons.infrastructure.spring.BeanContext;

@Component
public class IgniteServiceFactory implements SmartInitializingSingleton {

	private static IgniteSpringBean igniteSpringBean;

	public static <T> T newService(Class<T> serviceInterface) {
		ClusterGroup clusterGroup = igniteSpringBean.cluster().forAttribute(IgniteNodeType.SERVICE_NODE.name(), true);
		return igniteSpringBean.services(clusterGroup).serviceProxy(serviceInterface.getName(), serviceInterface, true);
	}

	@Override
	public void afterSingletonsInstantiated() {
		igniteSpringBean = BeanContext.build().getBean("igniteSpringBean", IgniteSpringBean.class);
	}

}
