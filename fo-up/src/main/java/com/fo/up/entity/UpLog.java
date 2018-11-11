package com.fo.up.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class UpLog {
	@Id
	@GeneratedValue
	private Integer logId;//编号
	@Column(nullable = false)
	private String description;//操作描述
	@Column(nullable = true)
	private String userName;//操作用户
	@Column(nullable = true)
	private Long startTime;//操作时间
	@Column(nullable = true)
	private Integer spendTime;//消耗时间
	@Column(nullable = true)
	private String basePath;//根路径
	@Column(nullable = true)
	private String uri;//URI
	@Column(nullable = true)
	private String url;//URL
	@Column(nullable = true)
	private String method;//请求类型
	@Column(nullable = true)
	private String parameter;//
	@Column(nullable = true)
	private String userAgent;//用户标识
	@Column(nullable = true)
	private String ip;//IP地址ַ
	@Column(nullable = true)
	private String result;//
	@Column(nullable = true)
	private String permissions;//权限值
	public Integer getLogId() {
		return logId;
	}
	public void setLogId(Integer logId) {
		this.logId = logId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Integer getSpendTime() {
		return spendTime;
	}
	public void setSpendTime(Integer spendTime) {
		this.spendTime = spendTime;
	}
	public String getBasePath() {
		return basePath;
	}
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	@Override
	public String toString() {
		return "UpLog [logId=" + logId + ", description=" + description + ", userName=" + userName + ", startTime="
				+ startTime + ", spendTime=" + spendTime + ", basePath=" + basePath + ", uri=" + uri + ", url=" + url
				+ ", method=" + method + ", parameter=" + parameter + ", userAgent=" + userAgent + ", ip=" + ip
				+ ", result=" + result + ", permissions=" + permissions + "]";
	}
	
	

}
