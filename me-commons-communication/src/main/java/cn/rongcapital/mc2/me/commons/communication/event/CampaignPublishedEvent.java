package cn.rongcapital.mc2.me.commons.communication.event;

import cn.rongcapital.mc2.me.commons.infrastructure.redisson.RedissonEventObject;

@SuppressWarnings("serial")
public class CampaignPublishedEvent extends RedissonEventObject {

	public final static String EVENT_NAME = "CAMPAIGN_PUBLISHED";

	public CampaignPublishedEvent() {}

	public CampaignPublishedEvent(Object source) {
		super(source);
	}

}
