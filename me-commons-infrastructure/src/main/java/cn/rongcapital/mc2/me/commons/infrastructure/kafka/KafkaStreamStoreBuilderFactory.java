package cn.rongcapital.mc2.me.commons.infrastructure.kafka;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.state.KeyValueBytesStoreSupplier;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.StoreBuilder;
import org.apache.kafka.streams.state.Stores;

/**
 * kafka streams存储器工厂
 * @author 英博
 *
 */
public class KafkaStreamStoreBuilderFactory {

	private String storeName;

	private StoreBuilder<KeyValueStore<String, String>> storeBuilder;

	KafkaStreamStoreBuilderFactory(String storeName, StoreBuilder<KeyValueStore<String, String>> storeBuilder) {
		this.storeName = storeName;
		this.storeBuilder = storeBuilder;
	}

	public static KafkaStreamStoreBuilderFactory build(String key) {
		String storeName = generateStoreName(key);
		KeyValueBytesStoreSupplier bytesStoreSupplier = Stores.persistentKeyValueStore(storeName);
		StoreBuilder<KeyValueStore<String, String>> storeBuilder = Stores.keyValueStoreBuilder(bytesStoreSupplier, Serdes.String(), Serdes.String());
		return new KafkaStreamStoreBuilderFactory(storeName, storeBuilder);
	}

	public static String generateStoreName(String key) {
		return "ME-EWP-STORE-" + key;
	}

	public String getStoreName() {
		return storeName;
	}

	public StoreBuilder<KeyValueStore<String, String>> getStoreBuilder() {
		return storeBuilder;
	}

}
