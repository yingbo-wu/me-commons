package cn.rongcapital.mc2.me.commons.infrastructure.djob;

import java.io.IOException;

import cn.rongcapital.djob.client.function.CallBack;
import cn.rongcapital.djob.client.function.JobExecutor;
import cn.rongcapital.djob.dto.JobContext;

public class DjobTaskExecutor implements JobExecutor {

	@Override
	public void execute(JobContext context, CallBack callBack) {
		String data = context.getData();
		DjobTask task = null;
		try {
			task = DjobTaskSerializer.toTask(data);
			task.run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
