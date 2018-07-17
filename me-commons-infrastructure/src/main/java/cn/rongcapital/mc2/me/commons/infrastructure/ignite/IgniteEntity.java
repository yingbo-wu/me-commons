package cn.rongcapital.mc2.me.commons.infrastructure.ignite;

import java.util.Date;

import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.google.gson.annotations.Expose;

import cn.rongcapital.mc2.me.commons.util.UuidUtils;

public class IgniteEntity {

	public final static String FIELD_STATUS = "status";
	public final static String FIELD_CREATE_AT = "create_at";
	public final static String FIELD_CREATE_BY = "create_by";
	public final static String FIELD_UPDATE_AT = "update_at";
	public final static String FIELD_UPDATE_BY = "update_by";

	@Id
	@Expose
	@QuerySqlField(index = true)
	protected String id;

	@Expose
	@QuerySqlField
	@Field(FIELD_STATUS)
	protected Integer status;

	@Expose
	@Field(FIELD_CREATE_AT)
	protected Date createAt;

	@Expose
	@Field(FIELD_CREATE_BY)
	protected Long createBy;

	@Field(FIELD_UPDATE_AT)
	protected Date updateAt;

	@Field(FIELD_UPDATE_BY)
	protected Long updateBy;

	public IgniteEntity() {
		this.id = UuidUtils.base58Uuid();
		this.createAt = new Date();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

}
