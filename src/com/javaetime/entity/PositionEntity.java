package com.javaetime.entity;
/**
 * 职位
 * @author 褚瑞峰
 *
 */
public class PositionEntity {
	private int positionId;
	private String positionName;
	private int wage;
	private int subsidyWage;
	private String remark;
	private String createTime;
	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public int getSubsidyWage() {
		return subsidyWage;
	}
	public void setSubsidyWage(int subsidyWage) {
		this.subsidyWage = subsidyWage;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
}
