package cn.rongcapital.mc2.me.commons.feign.tag.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cn.rongcapital.mc2.me.commons.feign.tag.TagResult;
import cn.rongcapital.mc2.me.commons.feign.tag.dto.TagInfo;

public interface TagInfoApi {

	@GET
	@Path("/v2/{tagId}")
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	TagResult<TagInfo> get(@PathParam("tagId") long id, @HeaderParam("Tenant-Id") long tenantId);

}
