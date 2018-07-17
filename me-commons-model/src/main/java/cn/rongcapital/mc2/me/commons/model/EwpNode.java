package cn.rongcapital.mc2.me.commons.model;

public class EwpNode {

	private String nodeId;

	private String nodeType;

	public EwpNode() {}

	public EwpNode(String nodeId, String nodeType) {
		this.nodeId = nodeId;
		this.nodeType = nodeType;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

}
