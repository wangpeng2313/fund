package com.javaetime.web.fundissue.param;

public class IssueParam {
	
	/**
	 * 发行方id
	 */
	private int issueId;
	
	/**
	 * 发行方姓名
	 */
	private String issueName;
	
	/**
	 * 发行方电话
	 */
	private String phone;
	

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
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

}
