package com.javaetime.entity;

public class FundInfoEntity {
	
	private int issueId;
	private int infoId;
	private String name;
	private String price;
	private String description;
	private String status;
	private String remark;
	private String createTime;
	private IssueEntity issue;
	private FundInfoEntity fundinfo;
	
	public FundInfoEntity getFundinfo() {
		return fundinfo;
	}
	public void setFundinfo(FundInfoEntity fundinfo) {
		this.fundinfo = fundinfo;
	}
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	public IssueEntity getIssue() {
		return issue;
	}
	public void setIssue(IssueEntity issue) {
		this.issue = issue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
