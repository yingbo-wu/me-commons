package cn.rongcapital.mc2.me.commons.infrastructure.kafka;

import org.apache.kafka.streams.kstream.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * kafka streams过滤器实现
 * @author Administrator
 *
 */
public abstract class KafkaStreamFilter implements Predicate<String, String> {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	private String filterName;

	private String filterValue;

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public String getFilterValue() {
		return filterValue;
	}

	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}

}
