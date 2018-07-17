package cn.rongcapital.mc2.me.commons.infrastructure.ignite;

import java.lang.reflect.Method;

import javax.validation.executable.ValidateOnExecution;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

public class IgniteValidationPointcut implements Pointcut {

	static final ClassFilter filter = new ClassFilter() {
		@Override
		public boolean matches(Class<?> clazz) {
			return true;
		}
	};

	static final MethodMatcher matcher = new MethodMatcher() {
		@Override
		public boolean matches(Method method, Class<?> targetClass) {
			return targetClass.isAnnotationPresent(ValidateOnExecution.class) || method.isAnnotationPresent(ValidateOnExecution.class);
		}

		@Override
		public boolean isRuntime() {
			return false;
		}

		@Override
		public boolean matches(Method method, Class<?> targetClass, Object... args) {
			return false;
		}
	};

	@Override
	public ClassFilter getClassFilter() {
		return filter;
	}

	@Override
	public MethodMatcher getMethodMatcher() {
		return matcher;
	}

}
