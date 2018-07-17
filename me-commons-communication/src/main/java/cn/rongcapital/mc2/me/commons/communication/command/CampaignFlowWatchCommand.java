package cn.rongcapital.mc2.me.commons.communication.command;

import cn.rongcapital.mc2.me.commons.infrastructure.redisson.RedissonCommandObject;

@SuppressWarnings("serial")
public class CampaignFlowWatchCommand extends RedissonCommandObject {

	public final static String COMMAND_NAME = "CAMPAIGN_FLOW_WATCH";

	public CampaignFlowWatchCommand() {}

	public CampaignFlowWatchCommand(Object source) {
		super(source);
	}

}
