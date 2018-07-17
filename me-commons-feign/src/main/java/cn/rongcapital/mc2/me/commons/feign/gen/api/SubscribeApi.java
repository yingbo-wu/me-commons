package cn.rongcapital.mc2.me.commons.feign.gen.api;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cn.rongcapital.mc2.me.commons.feign.gen.GenResult;

public interface SubscribeApi {

	@POST
	@Path("")
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	GenResult<Object> subscribe(Map<String, Object> payload);

	@POST
	@Path("")
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	GenResult<Object> unsubscribe(String flowId);

}
