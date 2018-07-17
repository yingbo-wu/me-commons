package cn.rongcapital.mc2.me.commons.api;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = -4893602489154790109L;

	@SuppressWarnings("rawtypes")
	private ApiResult result;

	public ApiException(int code, String message) {
		result = ApiResult.error(code, message);
	}

	@SuppressWarnings("rawtypes")
	public ApiResult result() {
		return result;
	}

}
