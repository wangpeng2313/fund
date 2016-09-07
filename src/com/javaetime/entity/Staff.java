package com.javaetime.entity;

//来自用户表
public class Staff extends User{
	/**
	 * 自定义研发信息
	 */

	/**
	 * 部门ID
	 */
	private int deptId;
	/**
	 * 职位ID
	 */
	private int positionId;
	/**
	 * 用户类型
	 */
	private int userType;
	/**
	 * 身份证号
	 */
	private String cardNo;
	/**
	 * 姓别
	 */
	private int sex;
	/**
	 * 联系电话
	 */
	private String tel;
	/**
	 * 电子信箱
	 */
	private String email;
	/**
	 * QQ
	 */
	private String qq;
	/**
	 * 银行卡类型
	 */
	private int bankType;
	/**
	 * 银行卡号
	 */
	private String bankNo;
	/**
	 * 学历
	 */
	private int education;
	/**
	 * 毕业学校
	 */
	private String school;
	/**
	 * 入职时间
	 */
	private int graduationDate;
	/**
	 * 附加薪资
	 */
	private int addWage;
	/**
	 * 员工状态
	 */
	private int status;
	/**
	 * 入职时间
	 */
	private int entryDate;
	/**
	 * 离职时间
	 */
	private int leaveDate;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 咨询师ID
	 */
	private int counselorId;
	
	public int getCounselorId() {
		return counselorId;
	}
	public void setCounselorId(int counselorId) {
		this.counselorId = counselorId;
	}
	public long getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public long getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public int getBankType() {
		return bankType;
	}
	public void setBankType(int bankType) {
		this.bankType = bankType;
	}
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	public int getEducation() {
		return education;
	}
	public void setEducation(int education) {
		this.education = education;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getGraduationDate() {
		return graduationDate;
	}
	public void setGraduationDate(int graduationDate) {
		this.graduationDate = graduationDate;
	}
	public int getAddWage() {
		return addWage;
	}
	public void setAddWage(int addWage) {
		this.addWage = addWage;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(int entryDate) {
		this.entryDate = entryDate;
	}
	public int getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(int leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
