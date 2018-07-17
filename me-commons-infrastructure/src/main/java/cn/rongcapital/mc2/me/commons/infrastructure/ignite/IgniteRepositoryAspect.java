package cn.rongcapital.mc2.me.commons.infrastructure.ignite;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class IgniteRepositoryAspect {

	@SuppressWarnings("unchecked")
	@Around("execution(public * org.apache.ignite.springdata.repository.IgniteRepository.save(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		Object that = joinPoint.getThis();
		Object[] args = joinPoint.getArgs();
		if (2 == args.length) {
			String key = (String) args[0];
			IgniteEntity entity = (IgniteEntity) args[1];
			if (null == entity.getId()) {
				entity.setId(key);
			}
			return joinPoint.proceed(args);
		} else {
			if (args[0] instanceof Map) {
				Map<?, ?> map = (Map<?, ?>) args[0];
				map.entrySet().stream().forEach(entry -> {
					String key = (String) entry.getKey();
					IgniteEntity entity = (IgniteEntity) entry.getValue();
					if (null == entity.getId()) {
						entity.setId(key);
					}
				});
				return joinPoint.proceed(args);
			} else if (args[0] instanceof Collection) {
				Collection<IgniteEntity> entities = (Collection<IgniteEntity>) args[0];
				Map<String, IgniteEntity> map = entities.stream().collect(Collectors.toMap(IgniteEntity::getId, entity -> entity));
				IgniteRepository<IgniteEntity, String> repository = (IgniteRepository<IgniteEntity, String>) that;
				return repository.save(map);
			} else if (args[0] instanceof IgniteEntity) {
				IgniteEntity entity = (IgniteEntity) args[0];
				IgniteRepository<IgniteEntity, String> repository = (IgniteRepository<IgniteEntity, String>) that;
				return repository.save(entity.getId(), entity);
			} else {
				throw new RuntimeException("未知的参数类型, 请传递正确的参数");
			}
		}
	}

}
