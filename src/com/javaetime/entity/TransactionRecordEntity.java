package com.javaetime.entity;

public class TransactionRecordEntity {
	/**
	 * 基金交易序号
	 */
	private int trId;
	/**
	 * 账户ID
	 */
	private int aId;
	/**
	 * 基金Id
	 */
	private int infoId;
	/**
	 * 基金交易类型
	 */
	private String trType;
	/**
	 * 基金交易份数
	 */
	private int trAmount;
	/**
	 * 基金交易单价
	 */
	private int trPrice;
	/**
	 * 交易时间
	 */
	private String trTime;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 基金信息实体
	 */
	private FundInfoEntity fundInfoEntity;
	/**
	 * 基金交易实体
	 */
	private TransactionRecordEntity transactionRecordEntity;
	/**
	 * 账户实体
	 */
	private FundAccountEntity fundAccountEntity;
	
	public FundAccountEntity getFundAccountEntity() {
		return fundAccountEntity;
	}
	public void setFundAccountEntity(FundAccountEntity fundAccountEntity) {
		this.fundAccountEntity = fundAccountEntity;
	}
	public FundInfoEntity getFundInfoEntity() {
		return fundInfoEntity;
	}
	public void setFundInfoEntity(FundInfoEntity fundInfoEntity) {
		this.fundInfoEntity = fundInfoEntity;
	}
	public TransactionRecordEntity getTransactionRecordEntity() {
		return transactionRecordEntity;
	}
	public void setTransactionRecordEntity(
			TransactionRecordEntity transactionRecordEntity) {
		this.transactionRecordEntity = transactionRecordEntity;
	}
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
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	public String getTrType() {
		return trType;
	}
	public void setTrType(String trType) {
		this.trType = trType;
	}
	public int getTrAmount() {
		return trAmount;
	}
	public void setTrAmount(int trAmount) {
		this.trAmount = trAmount;
	}
	public int getTrPrice() {
		return trPrice;
	}
	public void setTrPrice(int trPrice) {
		this.trPrice = trPrice;
	}
	public String getTrTime() {
		return trTime;
	}
	public void setTrTime(String trTime) {
		this.trTime = trTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
