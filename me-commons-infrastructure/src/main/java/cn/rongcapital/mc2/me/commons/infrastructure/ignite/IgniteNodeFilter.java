package cn.rongcapital.mc2.me.commons.infrastructure.ignite;

import org.apache.ignite.cluster.ClusterNode;
import org.apache.ignite.lang.IgnitePredicate;

public class IgniteNodeFilter implements IgnitePredicate<ClusterNode> {

	private static final long serialVersionUID = -6021248834475386532L;

	private IgniteNodeType nodeType;

	public IgniteNodeFilter(IgniteNodeType nodeType) {
		this.nodeType = nodeType;
	}

	@Override
	public boolean apply(ClusterNode node) {
		Boolean value = node.attribute(this.nodeType.name());
		if (null != value) {
			return value.booleanValue();
		}
		return false;
	}

}
