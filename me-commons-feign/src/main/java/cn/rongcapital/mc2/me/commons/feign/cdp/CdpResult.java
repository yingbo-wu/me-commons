package cn.rongcapital.mc2.me.commons.feign.cdp;

public class CdpResult<T> {

	protected Integer code;

	protected String message;

	protected T data;

	public boolean isOk() {
		return 0 == code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
