package cn.rongcapital.mc2.me.commons.infrastructure.redisson;

import org.redisson.api.RScheduledExecutorService;
import org.redisson.api.RScheduledFuture;

import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;
import reactor.core.scheduler.Schedulers;

public class RedissonTaskCancelable {

	private MonoSink<?> sink;

	public void done() {
		sink.success();
	}

	void then(RScheduledExecutorService executorService, RScheduledFuture<?> future) {
		Mono.create(callback -> {
			sink = callback;
		}).publishOn(Schedulers.parallel()).subscribe(none -> {
			String taskId = future.getTaskId();
			executorService.cancelTask(taskId);
		});
	}

}
