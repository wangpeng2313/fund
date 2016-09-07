package com.javaetime.entity;
/**
 *  @time 20150914
 * @author petter
 *  QQ :872024775
 */
public class FundAccountEntity {
	/**
	 * 账户id
	 */
	private int aId;
	/**
	 * 客户id
	 */
	private int id;
	/**
	 * 账户号码
	 */
	
	private String aCard;
	/**
	 * 账户密码
	 */
	private String aPwd;
	/**
	 * 账户金额
	 */
	private int aMargin;
	/**
	 * 账户状态
	 * 
	 */
	private int aState;
	/**
	 * 备注
	 */
	private String remark;
   /**
          创建时间
    
   */
	private String createTime;
	/**
	 * 客户实体
	 */
	private ClientEntity clientEntity;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaCard() {
		return aCard;
	}

	public void setaCard(String aCard) {
		this.aCard = aCard;
	}

	public String getaPwd() {
		return aPwd;
	}

	public void setaPwd(String aPwd) {
		this.aPwd = aPwd;
	}

	public int getaMargin() {
		return aMargin;
	}

	public void setaMargin(int aMargin) {
		this.aMargin = aMargin;
	}

	public int getaState() {
		return aState;
	}

	public void setaState(int aState) {
		this.aState = aState;
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

	public ClientEntity getClientEntity() {
		return clientEntity;
	}

	public void setClientEntity(ClientEntity clientEntity) {
		this.clientEntity = clientEntity;
	}

}
