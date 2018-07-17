package cn.rongcapital.mc2.me.commons.infrastructure.ignite;

import org.apache.ignite.IgniteException;
import org.apache.ignite.lifecycle.LifecycleBean;
import org.apache.ignite.lifecycle.LifecycleEventType;
import org.apache.ignite.services.Service;
import org.apache.ignite.services.ServiceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class IgniteService implements Service, LifecycleBean {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void cancel(ServiceContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(ServiceContext ctx) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void execute(ServiceContext ctx) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void onLifecycleEvent(LifecycleEventType evt) throws IgniteException {
		// TODO Auto-generated method stub
	}

}
