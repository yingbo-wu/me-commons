package cn.rongcapital.mc2.me.commons.infrastructure.djob;

import java.io.Serializable;

@FunctionalInterface
public interface DjobTaskRunner extends Serializable {

	void run();

}
