package cn.rongcapital.mc2.me.commons.infrastructure.djob;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

import cn.rongcapital.mc2.me.commons.infrastructure.spring.PropertyContext;
import cn.rongcapital.mc2.me.commons.util.GsonUtils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.ipc.netty.http.client.HttpClient;

@Component
public class DjobScheduledExecutor implements SmartInitializingSingleton {

	private final static HttpClient REACTOR_NETTY_CLIENT = HttpClient.create();

	private static String url;

	private static Logger logger = LoggerFactory.getLogger(DjobScheduledExecutor.class);

	public static void schedule(DjobTask task, String cron) {
		try {
			REACTOR_NETTY_CLIENT.post(url, (request) -> {
				request.addHeader("Content-Type", "application/json");
				String config = GsonUtils.create().toJson(new DjobScheduledConfig(task, cron));
				return request.sendString(Mono.just(config));
			}).doOnError(error -> {
				logger.error("注册djob失败, message is '{}'", error.getMessage());
			}).publishOn(Schedulers.parallel()).subscribe(response -> {
				response.receiveObject().ofType(Map.class).doOnError(error -> {
					logger.error("注册djob失败, message is '{}'", error.getMessage());
				}).subscribe(result -> {
					logger.info("注册djob成功, result is '{}'", result);
				});
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void cancel(String taskId) {
		try {
			String cancelUrl = String.format("%s/%s/%s", url, DjobTask.TASK_GROUP_NAME, taskId);
			REACTOR_NETTY_CLIENT.delete(cancelUrl).doOnError(error -> {
				logger.error("删除djob失败, message is '{}'", error.getMessage());
			}).publishOn(Schedulers.parallel()).subscribe(response -> {
				response.receiveObject().ofType(Map.class).doOnError(error -> {
					logger.error("删除djob失败, message is '{}'", error.getMessage());
				}).subscribe(result -> {
					logger.info("删除djob成功, result is '{}'", result);
				});
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void afterSingletonsInstantiated() {
		url = PropertyContext.build().getProperty("djob.url");
	}

}
