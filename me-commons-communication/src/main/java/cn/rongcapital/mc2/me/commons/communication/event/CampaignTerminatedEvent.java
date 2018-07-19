package cn.rongcapital.mc2.me.commons.communication.event;

import cn.rongcapital.mc2.me.commons.infrastructure.redisson.RedissonEventObject;

@SuppressWarnings("serial")
public class CampaignTerminatedEvent extends RedissonEventObject {

	public final static String EVENT_NAME = "CAMPAIGN_TERMINATED";

	public CampaignTerminatedEvent() {}

	public CampaignTerminatedEvent(Object source) {
		super(source);
	}

}
