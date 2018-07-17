package cn.rongcapital.mc2.me.commons.api;

import java.util.Map;

public class ApiMessage {

	private String key;

	private Map<String, String> message;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Map<String, String> getMessage() {
		return message;
	}

	public void setMessage(Map<String, String> message) {
		this.message = message;
	}

}
