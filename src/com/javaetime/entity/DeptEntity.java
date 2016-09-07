package com.javaetime.entity;

import java.util.List;

public class DeptEntity {
	
	private int deptId;
	private String deptName;
	private String remark;
	private String createTime;
	
	private List<StaffEntity> staff;
	
	
	public List<StaffEntity> getStaff() {
		return staff;
	}
	public void setStaff(List<StaffEntity> staff) {
		this.staff = staff;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
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
