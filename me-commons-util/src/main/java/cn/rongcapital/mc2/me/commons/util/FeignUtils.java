package cn.rongcapital.mc2.me.commons.util;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.jaxrs.JAXRSContract;
import reactor.core.publisher.Mono;

public class FeignUtils {

	public static <T> T proxyRestful(Class<T> clazz, String url) {
		return (T) Feign.builder()
						.contract(new JAXRSContract())
						.encoder(new GsonEncoder(GsonUtils.create()))
						.decoder(new GsonDecoder(GsonUtils.create()))
						.target(clazz, url);
	}

	public static <T> T proxy(Class<T> clazz, String url) {
		return (T) Feign.builder()
						.contract(new JAXRSContract())
						.target(clazz, url);
	}

	public static <T> Mono<T> reactiveRestful(Class<T> clazz, String url) {
		Mono<T> mono = Mono.create(callback -> {
			T t = Feign.builder()
					   .contract(new JAXRSContract())
					   .encoder(new GsonEncoder(GsonUtils.create()))
					   .decoder(new GsonDecoder(GsonUtils.create()))
					   .target(clazz, url);
			callback.success(t);
		});
		return mono;
	}

	public static <T> Mono<T> reactive(Class<T> clazz, String url) {
		Mono<T> mono = Mono.create(callback -> {
			T t = Feign.builder()
					   .contract(new JAXRSContract())
					   .target(clazz, url);
			callback.success(t);
		});
		return mono;
	}

}
