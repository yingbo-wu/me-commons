package cn.rongcapital.mc2.me.commons.infrastructure.ignite;

import java.lang.reflect.Method;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import javax.validation.groups.Default;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import cn.rongcapital.mc2.me.commons.api.ApiResult;

public class IgniteServiceValidator implements ApplicationContextAware, SmartInitializingSingleton {

	private final static ValidatorFactory VALIDATOR_FACTORY = Validation.buildDefaultValidatorFactory();

	private final static Validator VALIDATOR = VALIDATOR_FACTORY.getValidator();

	private final static ExecutableValidator EXECUTABLE_VALIDATOR = VALIDATOR.forExecutables();

	private static IgniteMessageReader messageReader;

	private ApplicationContext applicationContext;

	public static ApiResult<?> valid(Object obj, Method method, Object[] args) {
		Class<?> clazz = obj.getClass();
		String className = clazz.getName();
		String methodName = method.getName();
		Set<ConstraintViolation<Object>> set = EXECUTABLE_VALIDATOR.validateParameters(obj, method, args, Default.class);
		if (CollectionUtils.isNotEmpty(set)) {
			for (ConstraintViolation<Object> violation : set) {
				String code = violation.getMessage();
				return messageReader.read(className, methodName, code);
			}
		}
		return null;
	}

	@Override
	public void afterSingletonsInstantiated() {
		messageReader = this.applicationContext.getBean(IgniteMessageReader.class);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
