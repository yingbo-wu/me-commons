package cn.rongcapital.mc2.me.commons.communication.event;

import cn.rongcapital.mc2.me.commons.infrastructure.redisson.RedissonEventObject;

@SuppressWarnings("serial")
public class CampaignFlowStopedEvent extends RedissonEventObject {

	public final static String EVENT_NAME = "CAMPAIGN_FLOW_STOPED";

	public CampaignFlowStopedEvent() {}

	public CampaignFlowStopedEvent(Object source) {
		super(source);
	}

}
