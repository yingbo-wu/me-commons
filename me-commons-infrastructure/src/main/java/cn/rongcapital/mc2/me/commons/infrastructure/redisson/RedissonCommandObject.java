package cn.rongcapital.mc2.me.commons.infrastructure.redisson;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RedissonCommandObject implements Serializable {

	private static final long serialVersionUID = -603917594810114670L;

	protected Object source;

	public RedissonCommandObject() {}

	public RedissonCommandObject(Object source) {
		if (null == source) {
			throw new IllegalArgumentException("null source");
		}
		this.source = source;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void put(String key, Object value) {
		if (null == source) {
			source = new HashMap<>();
		}
		if (source instanceof Map) {
			((Map) source).put(key, value);
		} else {
			throw new RuntimeException("The source type is not instanceof Map");
		}
	}

	@SuppressWarnings("rawtypes")
	public Object get(String key) {
		if (source instanceof Map) {
			return ((Map) source).get(key);
		} else {
			throw new RuntimeException("The source type is not instanceof Map");
		}
	}

	public Object getSource() {
		return source;
	}

	public String toString() {
		return getClass().getName() + "[source=" + source + "]";
	}

}
