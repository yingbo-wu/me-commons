package cn.rongcapital.mc2.me.commons.communication.command;

import cn.rongcapital.mc2.me.commons.infrastructure.redisson.RedissonCommandObject;

@SuppressWarnings("serial")
public class CampaignFlowAwaitShutdownCommand extends RedissonCommandObject {

	public final static String COMMAND_NAME = "CAMPAIGN_FLOW_AWAIT_SHUTDOWN";

	public CampaignFlowAwaitShutdownCommand() {}

	public CampaignFlowAwaitShutdownCommand(Object source) {
		super(source);
	}

}
