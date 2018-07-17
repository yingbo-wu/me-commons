package cn.rongcapital.mc2.me.commons.infrastructure.kafka;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.kstream.TransformerSupplier;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.state.KeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * kafka streams传输器实现
 * @author 英博
 *
 */
public abstract class KafkaStreamTransformer implements TransformerSupplier<String, String, KeyValue<String, String>>, Transformer<String, String, KeyValue<String, String>> {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected ProcessorContext context;

	protected KeyValueStore<String, String> kvStore;

	private String storeName;

	private long intervalMs = 1000;

	private PunctuationType punctuationType;

	public KafkaStreamTransformer(String key) {
		this(key, 1000, PunctuationType.STREAM_TIME);
	}

	public KafkaStreamTransformer(String key, long intervalMs) {
		this(key, intervalMs, PunctuationType.STREAM_TIME);
	}

	public KafkaStreamTransformer(String key, long intervalMs, PunctuationType punctuationType) {
		this.storeName = KafkaStreamStoreBuilderFactory.generateStoreName(key);
		this.intervalMs = intervalMs;
		this.punctuationType = punctuationType;
	}

	@Override
	public Transformer<String, String, KeyValue<String, String>> get() {
		return this;
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
	public KeyValue<String, String> punctuate(long timestamp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		this.kvStore.close();
	}

}
