package cn.rongcapital.mc2.me.commons.model;

/**
 * 主数据值对象
 * @author 英博
 *
 */
public class EwpMdata {

	private Integer mid;

	public EwpMdata() {}

	public EwpMdata(Integer mid) {
		this.mid = mid;
	}

	/**
	 * 查找主数据属性值
	 * @param propCode 属性编码
	 * @return
	 */
	public Object lookupProperty(String propCode) {
		// TODO
		return null;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

}
