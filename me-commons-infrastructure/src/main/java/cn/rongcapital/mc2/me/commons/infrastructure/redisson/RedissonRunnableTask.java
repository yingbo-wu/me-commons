package cn.rongcapital.mc2.me.commons.infrastructure.redisson;

import org.redisson.api.RScheduledExecutorService;
import org.redisson.api.RScheduledFuture;

/**
 * 任务抽象
 * @author 英博
 *
 */
public class RedissonRunnableTask implements Runnable {

	private RedissonTaskCancelable cancelable;

	private RedissonTaskFunction function;

	public RedissonRunnableTask(RedissonTaskFunction function) {
		this.function = function;
	}

	@Override
	public void run() {
		function.execute(cancelable);
	}

	void then(RScheduledExecutorService executorService, RScheduledFuture<?> future) {
		cancelable = new RedissonTaskCancelable();
		cancelable.then(executorService, future);
	}

}
