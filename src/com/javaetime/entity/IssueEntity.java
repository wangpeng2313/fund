package com.javaetime.entity;

public class IssueEntity {
	
	/**
	 * 发行方id
	 */
	private Long issueId;
	
	/**
	 * 发行方姓名
	 */
	private String issueName;
	
	/**
	 * 发行方电话
	 */
	private String phone;
	
	/**
	 * 备注  
	 */
	private String remark;
	
	/**
	 * 创建时间
	 */
	private String createTime;


	public Long getIssueId() {
		return issueId;
	}

	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}

	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
