package cn.rongcapital.mc2.me.commons.infrastructure.redisson;

@FunctionalInterface
public interface RedissonTaskFunction {

	void execute(RedissonTaskCancelable cancelable);

}
