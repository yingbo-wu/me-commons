package cn.rongcapital.mc2.me.commons.infrastructure.ignite;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import cn.rongcapital.mc2.me.commons.api.ApiResult;

public class IgniteValidationInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object obj = invocation.getThis();
		Method method = invocation.getMethod();
		Object[] args = invocation.getArguments();
		ApiResult<?> result = IgniteServiceValidator.valid(obj, method, args);
		if (null != result) {
			return result;
		}
		return invocation.proceed();
	}

}
