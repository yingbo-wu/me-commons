package cn.rongcapital.mc2.me.commons.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

import cn.rongcapital.djob.client.JobClient;
import cn.rongcapital.djob.client.function.JobTracer;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySource({ "classpath:djob-config.properties" })
public class Config {

	@Bean("djob.client.jobClient")
	public JobClient jobClient() {
		return new JobClient();
	}

	@Bean("djob.client.jobTracer")
	public JobTracer jobTracer() {
		return new JobTracer();
	}

}
