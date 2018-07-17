package cn.rongcapital.mc2.me.commons.communication.command;

import cn.rongcapital.mc2.me.commons.infrastructure.redisson.RedissonCommandObject;

@SuppressWarnings("serial")
public class CampaignNodeStayCommand extends RedissonCommandObject {

	public final static String COMMAND_NAME = "CAMPAIGN_NODE_STAY";

	public CampaignNodeStayCommand() {}

	public CampaignNodeStayCommand(Object source) {
		super(source);
	}

}
