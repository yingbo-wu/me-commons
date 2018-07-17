package cn.rongcapital.mc2.me.commons.model;

/**
 * 执行结果值对象
 * @author 英博
 *
 */
public class EwpResult {

	private Integer code;

	private Object data;

	private String message;

	private Object transition;

	/**
	 * 判断返回结果是否成功
	 * @return
	 */
	public boolean isOk() {
		if (null != code && 0 == code) {
			return true;
		}
		return false;
	}

	/**
	 * 创建异常结果
	 * @param code
	 * @param message
	 * @param data
	 * @param transition
	 * @return
	 */
	public static EwpResult error(int code, String message, Object data, Object transition) {
		EwpResult result = new EwpResult();
		result.code = code;
		result.message = message;
		result.data = data;
		result.transition = transition;
		return result;
	}

	/**
	 * 创建异常结果
	 * @param throwable
	 * @return
	 */
	public static EwpResult error(Throwable throwable) {
		EwpResult result = new EwpResult();
		result.code = -1;
		result.message = throwable.getMessage();
		return result;
	}

	/**
	 * 创建成功结果
	 * @param message
	 * @param data
	 * @param transition
	 * @return
	 */
	public static EwpResult success(String message, Object data, Object transition) {
		EwpResult result = new EwpResult();
		result.code = 0;
		result.message = message;
		result.data = data;
		result.transition = transition;
		return result;
	}

	/**
	 * 创建成功结果
	 * @param message
	 * @param data
	 * @return
	 */
	public static EwpResult success(String message, Object data) {
		return success(message, data, null);
	}

	public Integer getCode() {
		return code;
	}

	public Object getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}

	public Object getTransition() {
		return transition;
	}

}
