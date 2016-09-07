package com.javaetime.entity;

public class BankCardEntity {
	/**
	 * 序号
	 */
	private int accId;
	/**
	 * 账户号
	 */
	private String accno;
	/**
	 * 账户密码
	 */
	private String accpwd;
	/**
	 * 银行代号
	 */
	private int bankType;
	/**
	 * 客户id
	 */
	private int id;
	/**
	 * 创建时间
	 */
	private String createtime;
	/**
	 * 账户余额
	 */
	private String blance;
	/**
	 * 账户状态
	 */
	private int accstate;
	/**
	 * 客户实体
	 */
	private ClientEntity client;
	
	
	public ClientEntity getClient() {
		return client;
	}
	public void setClient(ClientEntity client) {
		this.client = client;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public String getAccpwd() {
		return accpwd;
	}
	public void setAccpwd(String accpwd) {
		this.accpwd = accpwd;
	}
	
	public int getBankType() {
		return bankType;
	}
	public void setBankType(int bankType) {
		this.bankType = bankType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getBlance() {
		return blance;
	}
	public void setBlance(String blance) {
		this.blance = blance;
	}
	public int getAccstate() {
		return accstate;
	}
	public void setAccstate(int accstate) {
		this.accstate = accstate;
	}
	
	
}
