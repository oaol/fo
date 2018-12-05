package com.fo.up.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UpTask implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;// 编号
    @Column(nullable = false)
    private String flag;// 
    @Column(nullable = false)
    private String sqlDate;//
    @Column(nullable = true)
    private String startTime;//
    @Column(nullable = true)
    private String endTime;// 
    @Column(nullable = true)
    private String unit;// 
    @Column(nullable = true)
    private String period;// 
    
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getSqlDate() {
		return sqlDate;
	}
	public void setSqlDate(String sqlDate) {
		this.sqlDate = sqlDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

}
