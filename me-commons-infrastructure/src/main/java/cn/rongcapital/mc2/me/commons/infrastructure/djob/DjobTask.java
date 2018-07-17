package cn.rongcapital.mc2.me.commons.infrastructure.djob;

import java.io.Serializable;

public class DjobTask implements Runnable, Serializable {

	private static final long serialVersionUID = 4669957128769272544L;

	static final String TASK_GROUP_NAME = "ME_EWP_JOBS";

	private String taskId;

	private DjobTaskRunner runner;

	public DjobTask() {}

	public DjobTask(String taskId, DjobTaskRunner runner) {
		this.taskId = taskId;
		this.runner = (DjobTaskRunner & Serializable) runner;
	}

	@Override
	public void run() {
		this.runner.run();
	}

	public String getTaskId() {
		return taskId;
	}

}
