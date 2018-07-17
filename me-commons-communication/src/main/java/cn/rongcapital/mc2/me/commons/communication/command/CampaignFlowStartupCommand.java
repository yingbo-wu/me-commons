package cn.rongcapital.mc2.me.commons.communication.command;

import cn.rongcapital.mc2.me.commons.infrastructure.redisson.RedissonCommandObject;

@SuppressWarnings("serial")
public class CampaignFlowStartupCommand extends RedissonCommandObject {

	public final static String COMMAND_NAME = "CAMPAIGN_FLOW_STARTUP";

	public CampaignFlowStartupCommand() {}

	public CampaignFlowStartupCommand(Object source) {
		super(source);
	}

}
