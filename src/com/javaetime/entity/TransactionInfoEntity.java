package com.javaetime.entity;

public class TransactionInfoEntity {
	private int rid;
	private int aId;
	//账户交易时间
	private String rdate;
	//账户类型
	private int rtype;
	//账户订单ID
	private int roid;
	private String remark;
	private String createTime;
	
	private FundAccountEntity fundAccount;
	
	public FundAccountEntity getFundAccount() {
		return fundAccount;
	}
	public void setFundAccount(FundAccountEntity fundAccount) {
		this.fundAccount = fundAccount;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public int getRtype() {
		return rtype;
	}
	public void setRtype(int rtype) {
		this.rtype = rtype;
	}
	public int getRoid() {
		return roid;
	}
	public void setRoid(int roid) {
		this.roid = roid;
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
