package com.fo.up.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class UpLog1 {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer logId;//编号
	@Column(nullable = true)
	private String sqlDate;//操作描述
	@Column(nullable = true)
	private String hTime;//操作用户
	@Column(nullable = true)
	private Long period;//操作时间
	@Column(nullable = true)
	private Integer mTime;//消耗时间
	@Column(nullable = true)
	private String execStart;//根路径
	@Column(nullable = true)
	private String execEnd;//URI
	@Column(nullable = true)
	private String useTime;//URL
	@Column(nullable = true)
	private String flag;//请求类型
	@Column(nullable = true)
	private String remark1;//
	
	public Integer getLogId() {
		return logId;
	}
	public void setLogId(Integer logId) {
		this.logId = logId;
	}
	public String getSqlDate() {
		return sqlDate;
	}
	public void setSqlDate(String sqlDate) {
		this.sqlDate = sqlDate;
	}
	public String gethTime() {
		return hTime;
	}
	public void sethTime(String hTime) {
		this.hTime = hTime;
	}
	public Long getPeriod() {
		return period;
	}
	public void setPeriod(Long period) {
		this.period = period;
	}
	public Integer getmTime() {
		return mTime;
	}
	public void setmTime(Integer mTime) {
		this.mTime = mTime;
	}
	public String getExecStart() {
		return execStart;
	}
	public void setExecStart(String execStart) {
		this.execStart = execStart;
	}
	public String getExecEnd() {
		return execEnd;
	}
	public void setExecEnd(String execEnd) {
		this.execEnd = execEnd;
	}
	public String getUseTime() {
		return useTime;
	}
	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	
	
	

}
