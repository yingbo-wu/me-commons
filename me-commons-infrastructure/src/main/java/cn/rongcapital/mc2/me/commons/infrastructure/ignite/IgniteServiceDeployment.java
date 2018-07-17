package cn.rongcapital.mc2.me.commons.infrastructure.ignite;

import org.apache.ignite.IgniteServices;
import org.apache.ignite.IgniteSpringBean;
import org.apache.ignite.cluster.ClusterGroup;
import org.apache.ignite.services.Service;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

import cn.rongcapital.mc2.me.commons.infrastructure.spring.BeanContext;

@Component
public class IgniteServiceDeployment implements SmartInitializingSingleton {

	private static IgniteSpringBean igniteSpringBean;

	public static void deploy(Class<?> serviceInterface, Service service) {
		ClusterGroup clusterGroup = igniteSpringBean.cluster().forAttribute(IgniteNodeType.SERVICE_NODE.name(), true);
		IgniteServices services = igniteSpringBean.services(clusterGroup);
		// 部署服务
		services.deployNodeSingleton(serviceInterface.getName(), service);
	}

	public static void deploy(Class<?> serviceInterface) {
		Service service = (Service) BeanContext.build().getBean(serviceInterface);
		deploy(serviceInterface, service);
	}

	@Override
	public void afterSingletonsInstantiated() {
		igniteSpringBean = BeanContext.build().getBean("igniteSpringBean", IgniteSpringBean.class);
	}

}
