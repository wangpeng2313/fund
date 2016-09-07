package com.javaetime.entity;
/**
 * 
 * @author fxg
 * @time 2015.09.12 15:50
 * 实体类：staff
 */
public class StaffEntity {
	/**
	 * 员工ID
	 */
	private long staffId;
	/**
	 * 员工姓名
	 */
	private String staffName;
	/**
	 * 员工照片
	 */
	private String testFile;
	/**
	 * 部门ID
	 */
	private long deptId;
	/**
	 * 员工性别
	 */
	private int sex;
	/**
	 * 员工电话
	 */
	private String tel;
	/**
	 * 学历
	 */
	private int education;
	/**
	 * 毕业院校
	 */
	private String school;
	/**
	 * 毕业时间
	 */
	private String graduationDate;
	/**
	 * 身份证号
	 */
	private String cardNo;
	/**
	 * 电子邮件
	 */
	private String email;
	/**
	 * 银行卡类型
	 */
	private int bankType;
	/**
	 * 银行卡号
	 */
	private String bankNo;
	/**
	 * 所在省
	 */
	private int province;
	/**
	 * 所在城市
	 */
	private int city;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 部门实体
	 */
	private DeptEntity dept;
	
	public String getTestFile() {
		return testFile;
	}
	public void setTestFile(String testFile) {
		this.testFile = testFile;
	}
	public DeptEntity getDept() {
		return dept;
	}
	public void setDept(DeptEntity dept) {
		this.dept = dept;
	}
	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
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
	public String getGraduationDate() {
		return graduationDate;
	}
	public void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public int getProvince() {
		return province;
	}
	public void setProvince(int province) {
		this.province = province;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
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
	public long getDeptId() {
		return deptId;
	}
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}
	
}
