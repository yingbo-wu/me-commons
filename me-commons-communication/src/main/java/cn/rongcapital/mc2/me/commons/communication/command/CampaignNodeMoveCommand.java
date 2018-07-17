package cn.rongcapital.mc2.me.commons.communication.command;

import cn.rongcapital.mc2.me.commons.infrastructure.redisson.RedissonCommandObject;

@SuppressWarnings("serial")
public class CampaignNodeMoveCommand extends RedissonCommandObject {

	public final static String COMMAND_NAME = "CAMPAIGN_NODE_MOVE";

	public CampaignNodeMoveCommand() {}

	public CampaignNodeMoveCommand(Object source) {
		super(source);
	}

}
