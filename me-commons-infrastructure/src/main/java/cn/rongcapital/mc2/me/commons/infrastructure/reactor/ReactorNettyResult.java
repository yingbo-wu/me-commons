package cn.rongcapital.mc2.me.commons.infrastructure.reactor;

public class ReactorNettyResult {

	private int statusCode;

	private String errorMessage;

	private Object successPayload;

	public boolean isOk() {
		return 200 == statusCode;
	}

	public static ReactorNettyResult error(String message) {
		ReactorNettyResult result = new ReactorNettyResult();
		result.statusCode = 500;
		result.errorMessage = message;
		return result;
	}

	public static ReactorNettyResult success(Object successPayload) {
		ReactorNettyResult result = new ReactorNettyResult();
		result.statusCode = 200;
		result.successPayload = successPayload;
		return result;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getSuccessPayload() {
		return successPayload;
	}

	public void setSuccessPayload(Object successPayload) {
		this.successPayload = successPayload;
	}

}
