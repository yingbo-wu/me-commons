package cn.rongcapital.mc2.me.commons.communication.command;

import cn.rongcapital.mc2.me.commons.infrastructure.redisson.RedissonCommandObject;

@SuppressWarnings("serial")
public class CampaignNodeFailCommand extends RedissonCommandObject {

	public final static String COMMAND_NAME = "CAMPAIGN_NODE_FAIL";

	public CampaignNodeFailCommand() {}

	public CampaignNodeFailCommand(Object source) {
		super(source);
	}

}
