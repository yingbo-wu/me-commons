package cn.rongcapital.mc2.me.commons.model;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import cn.rongcapital.mc2.me.commons.util.GsonUtils;

/**
 * 上下文值对象
 * @author 英博
 *
 */
public class EwpContext {

	private String campaignId;

	private String flowId;

	private EwpNode node;

	private EwpMdata mdata;

	private Map<String, Object> ndata;

	private Map<String, EwpResult> results;

	public EwpContext() {}

	/**
	 * 构造器
	 * @param mid 主数据id
	 * @param ndataJson 组件数据
	 */
	@SuppressWarnings("unchecked")
	public EwpContext(int mid, String campaignId, String flowId, String nodeId, String nodeType, String ndataJson) {
		this.flowId = flowId;
		this.node = new EwpNode(nodeId, nodeType);
		this.mdata = new EwpMdata(mid);
		this.ndata = GsonUtils.create().fromJson(ndataJson, Map.class);;
		this.results = new ConcurrentHashMap<String, EwpResult>();
	}

	/**
	 * 追加执行结果
	 * @param result
	 */
	public void appendResult(String nodeId, EwpResult result) {
		this.results.put(nodeId, result);
	}

	/**
	 * 查找mid
	 * @return
	 */
	public int lookupMid() {
		return this.mdata.getMid();
	}

	/**
	 * 查找nodeId
	 * @return
	 */
	public String lookupNodeId() {
		return this.node.getNodeId();
	}

	/**
	 * 查找nodeType
	 * @return
	 */
	public String lookupNodeType() {
		return this.node.getNodeType();
	}

	/**
	 * 查找历史执行结果值对象
	 * @param nodeId 节点id
	 * @return
	 */
	public EwpResult lookupResult(String nodeId) {
		Optional<EwpResult> optional = this.results.entrySet().stream().filter(entry -> entry.getKey().equals(nodeId)).map(entry -> entry.getValue()).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	/**
	 * 查找运行结果状态码
	 * @param nodeId
	 * @return
	 */
	public int lookupResultCode(String nodeId) {
		return lookupResult(nodeId).getCode();
	}

	/**
	 * 查找运行消息
	 * @param nodeId
	 * @return
	 */
	public String lookupResultMessage(String nodeId) {
		return lookupResult(nodeId).getMessage();
	}

	/**
	 * 查找当前运行结果
	 * @return
	 */
	public EwpResult lookupResult() {
		return lookupResult(this.node.getNodeId());
	}

	/**
	 * 查找当前运行结果状态码
	 * @return
	 */
	public int lookupResultCode() {
		return lookupResultCode(this.node.getNodeId());
	}

	/**
	 * 查找当前运行消息
	 * @return
	 */
	public String lookupResultMessage() {
		return lookupResultMessage(this.node.getNodeId());
	}

	/**
	 * 查找主数据属性值
	 * @param propCode
	 * @return
	 */
	public Object lookupMdataProperty(String propCode) {
		return this.mdata.lookupProperty(propCode);
	}

	public String getCampaignId() {
		return campaignId;
	}

	public String getFlowId() {
		return flowId;
	}

	public Map<String, Object> getNdata() {
		return ndata;
	}

}
