package cn.rongcapital.mc2.me.commons.api;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import com.google.gson.reflect.TypeToken;

import cn.rongcapital.mc2.me.commons.api.ApiResult;
import cn.rongcapital.mc2.me.commons.util.GsonUtils;

public class ApiMessageReader implements InitializingBean {

	@Value("classpath:api-message.json")
	private Resource resource;

	private static List<ApiMessage> apiMessages;

	public ApiResult<?> read(String className, String messageCode) {
		for (ApiMessage messageApi : apiMessages) {
			String key = messageApi.getKey();
			Map<String, String> message = messageApi.getMessage();
			if (key.equals(className)) {
				String errorMessage = message.get(messageCode);
				return ApiResult.error(Integer.parseInt(messageCode), errorMessage);
			}
		}
		return ApiResult.error(-1, "参数错误消息未指定, 请在api-message.json中指定!");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Reader reader = new InputStreamReader(resource.getInputStream());
		try {
			apiMessages = GsonUtils.create().fromJson(reader, new TypeToken<List<ApiMessage>>() {}.getType());
		} finally {
			reader.close();
		}
	}

}
