package cn.rongcapital.mc2.me.commons.feign.azeroth;

public class AzResult<T> {

	protected Integer code;

	protected String codePhrase;

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

	public String getCodePhrase() {
		return codePhrase;
	}

	public void setCodePhrase(String codePhrase) {
		this.codePhrase = codePhrase;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
