package cn.rongcapital.mc2.me.commons.communication.command;

import cn.rongcapital.mc2.me.commons.infrastructure.redisson.RedissonCommandObject;

@SuppressWarnings("serial")
public class CampaignFlowShutdownCommand extends RedissonCommandObject {

	public final static String COMMAND_NAME = "CAMPAIGN_FLOW_SHUTDOWN";

	public CampaignFlowShutdownCommand() {}

	public CampaignFlowShutdownCommand(Object source) {
		super(source);
	}

}
