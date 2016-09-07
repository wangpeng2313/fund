package com.javaetime.web.transactionRecord.param;


public class TransactionRecordParam {

	/**
	 * 账户ID
	 */
	private int aId;
	/**
	 * 基金Id
	 */
	private int fId;
	/**
	 * 基金交易ID
	 */
	private int trId;
	
	public int getTrId() {
		return trId;
	}
	public void setTrId(int trId) {
		this.trId = trId;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	

	
}
