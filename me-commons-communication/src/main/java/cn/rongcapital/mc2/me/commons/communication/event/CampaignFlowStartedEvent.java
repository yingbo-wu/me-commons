package cn.rongcapital.mc2.me.commons.communication.event;

import cn.rongcapital.mc2.me.commons.infrastructure.redisson.RedissonEventObject;

@SuppressWarnings("serial")
public class CampaignFlowStartedEvent extends RedissonEventObject {

	public final static String EVENT_NAME = "CAMPAIGN_FLOW_STARTED";

	public CampaignFlowStartedEvent() {}

	public CampaignFlowStartedEvent(Object source) {
		super(source);
	}

}
