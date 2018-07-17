package cn.rongcapital.mc2.me.commons.infrastructure.redisson;

import org.redisson.Redisson;
import org.redisson.api.CronSchedule;
import org.redisson.api.RScheduledExecutorService;
import org.redisson.api.RScheduledFuture;

/**
 * 调度器工具
 * @author 英博
 *
 */
public class RedissonScheduledExecutor {

	/**
	 * 注册定时任务
	 * @param function 任务函数, 函数返回值Boolean, true: 终止cron调度, false继续执行cron调度
	 * @param cron
	 */
	public static void schedule(RedissonRunnableTask task, String cron) {
		Redisson redisson = RedissonFactory.newInstance();
		RScheduledExecutorService executorService = redisson.getExecutorService("ME_EWP_EXECUTOR");
		// 注册终止任务
		RScheduledFuture<?> future = executorService.scheduleAsync(task, CronSchedule.of(cron));
		task.then(executorService, future);
	}

}
