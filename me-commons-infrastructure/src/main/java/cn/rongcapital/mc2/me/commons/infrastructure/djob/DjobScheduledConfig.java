package cn.rongcapital.mc2.me.commons.infrastructure.djob;

import java.io.IOException;

import cn.rongcapital.djob.dto.Key;

public class DjobScheduledConfig {

	private Key key;

	private String cron;

	private String executor;

	private String data;

	public DjobScheduledConfig(DjobTask task, String cron) {
		try {
			String serialization = DjobTaskSerializer.toString(task);
			this.key = new Key(task.getTaskId(), DjobTask.TASK_GROUP_NAME);
			this.cron = cron;
			this.executor = DjobTaskExecutor.class.getName();
			this.data = serialization;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Key getKey() {
		return key;
	}

	public String getCron() {
		return cron;
	}

	public String getExecutor() {
		return executor;
	}

	public String getData() {
		return data;
	}

}
