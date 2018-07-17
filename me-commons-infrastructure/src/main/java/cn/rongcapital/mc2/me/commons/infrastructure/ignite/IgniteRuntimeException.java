package cn.rongcapital.mc2.me.commons.infrastructure.ignite;

import cn.rongcapital.mc2.me.commons.api.ApiException;

public class IgniteRuntimeException extends ApiException {

	private static final long serialVersionUID = -4893602489154790109L;

	public IgniteRuntimeException(int code, String message) {
		super(code, message);
	}

}
