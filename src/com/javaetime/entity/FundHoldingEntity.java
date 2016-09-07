package com.javaetime.entity;
/**
 * 持仓类
 * @author 褚瑞峰
 * @QQ 1031795650/927390670
 */
public class FundHoldingEntity {
	private FundHoldingEntity fundHoldingEntity;
	
	/**
	 * id
	 */
	private int hId;
	/**
	 * 基金信息Id和实体
	 */
	private int infoId;
	private FundInfoEntity fundInfoEntity;
	/**
	 * 账户ID和实体
	 */
	private int aId;
	
	private FundAccountEntity fundAccountEntity;
	/**
	 * 交易金份数
	 */
	private String amount;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private String createTime;
	
	
	
	public int gethId() {
		return hId;
	}
	public void sethId(int hId) {
		this.hId = hId;
	}
	public FundInfoEntity getFundInfoEntity() {
		return fundInfoEntity;
	}
	public void setFundInfoEntity(FundInfoEntity fundInfoEntity) {
		this.fundInfoEntity = fundInfoEntity;
	}
	public FundAccountEntity getFundAccountEntity() {
		return fundAccountEntity;
	}
	public void setFundAccountEntity(FundAccountEntity fundAccountEntity) {
		this.fundAccountEntity = fundAccountEntity;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
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
	public FundHoldingEntity getFundHoldingEntity() {
		return fundHoldingEntity;
	}
	public void setFundHoldingEntity(FundHoldingEntity fundHoldingEntity) {
		this.fundHoldingEntity = fundHoldingEntity;
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
}
