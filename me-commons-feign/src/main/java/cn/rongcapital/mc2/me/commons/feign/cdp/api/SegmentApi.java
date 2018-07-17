package cn.rongcapital.mc2.me.commons.feign.cdp.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cn.rongcapital.mc2.me.commons.feign.cdp.CdpResult;
import cn.rongcapital.mc2.me.commons.feign.cdp.dto.Segment;

public interface SegmentApi {

	@GET
	@Path("/segment/info")
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	CdpResult<Segment> get(@QueryParam("id") String id, @HeaderParam("Tenant-Id") String tenantId, @HeaderParam("User-Id") String userId);

}
