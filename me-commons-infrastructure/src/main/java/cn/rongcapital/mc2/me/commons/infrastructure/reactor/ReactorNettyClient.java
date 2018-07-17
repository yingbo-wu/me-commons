package cn.rongcapital.mc2.me.commons.infrastructure.reactor;

import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpHeaders;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.ipc.netty.http.client.HttpClient;

public class ReactorNettyClient {

	public final static HttpClient REACTOR_NETTY_CLIENT = HttpClient.create();

	public static Mono<ReactorNettyResult> post(String url, Object requestBody, Class<?> responsePayloadClass) {
		HttpHeaders headers = new DefaultHttpHeaders();
		headers.add("Content-Type", "application/json");
		Mono<ReactorNettyResult> mono = Mono.create(callback -> {
			try {
				REACTOR_NETTY_CLIENT.post(url, (request) -> {
					request.headers(headers);
					return request.sendObject(requestBody);
				}).doOnError(error -> {
					callback.success(ReactorNettyResult.error(error.getMessage()));
				}).publishOn(Schedulers.parallel()).subscribe(response -> {
					response.receiveObject().ofType(responsePayloadClass).doOnError(error -> {
						callback.success(ReactorNettyResult.error(error.getMessage()));
					}).subscribe(result -> {
						try {
							callback.success(ReactorNettyResult.success(result));
						} catch (Exception e) {
							callback.success(ReactorNettyResult.error(e.getMessage()));
						}
					});
				});
			} catch (Exception e) {
				callback.success(ReactorNettyResult.error(e.getMessage()));
			}
		});
		return mono;
	}

}
