package cn.rongcapital.mc2.me.commons.infrastructure.kafka;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.ProcessorSupplier;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.state.KeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * kafka streams 处理器实现
 * @author 英博
 *
 */
public abstract class KafkaStreamProcessor implements ProcessorSupplier<String, String>, Processor<String, String> {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected ProcessorContext context;

	protected KeyValueStore<String, String> kvStore;

	private String storeName;

	private long intervalMs = 1000;

	private PunctuationType punctuationType;

	@Override
	public Processor<String, String> get() {
		return this;
	}

	public KafkaStreamProcessor(String key) {
		this(key, 1000, PunctuationType.STREAM_TIME);
	}

	public KafkaStreamProcessor(String key, long intervalMs) {
		this(key, intervalMs, PunctuationType.STREAM_TIME);
	}

	public KafkaStreamProcessor(String key, long intervalMs, PunctuationType punctuationType) {
		this.storeName = KafkaStreamStoreBuilderFactory.generateStoreName(key);
		this.intervalMs = intervalMs;
		this.punctuationType = punctuationType;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void init(ProcessorContext context) {
		this.context = context;
		this.context.schedule(this.intervalMs, this.punctuationType, timestamp -> {
			punctuate(timestamp);
		});
		this.kvStore = (KeyValueStore<String, String>) context.getStateStore(storeName);
	}

	@Override
	public void punctuate(long timestamp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		this.kvStore.close();
	}

}
