package cn.rongcapital.mc2.me.commons.api;

public class ApiResult<T> {

	private Integer code;

	private T data;

	private String message;

	public ApiResult() {}

	public boolean isOk() {
		return 0 == code;
	}

	public boolean isError() {
		return 0 != code;
	}

	public static <T> ApiResult<T> error(int code) {
		ApiResult<T> result = new ApiResult<T>();
		result.code = code;
		return result;
	}

	public static <T> ApiResult<T> error(int code, String message) {
		ApiResult<T> result = new ApiResult<T>();
		result.code = code;
		result.message = message;
		return result;
	}

	public static <T> ApiResult<T> success() {
		ApiResult<T> result = new ApiResult<T>();
		result.code = 0;
		return result;
	}

	public static <T> ApiResult<T> success(T data) {
		ApiResult<T> result = new ApiResult<T>();
		result.code = 0;
		result.data = data;
		return result;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
