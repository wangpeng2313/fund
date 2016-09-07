package com.javaetime.entity;

/**
 * 字典
 * 
 * @author 褚瑞峰
 * 
 */
public class DictionaryEntity {
	/**
	 * 字典ID
	 */
	private int dictionaryId;
	/**
	 * 字典类型编码
	 */
	private String typeCode;
	/**
	 * 字典的Key
	 */
	private String key;
	/**
	 * 字典的VALUE
	 */
	private String value;
	/**
	 * 父ID
	 */
	private int parentId; // ctrl+shift+X 变大写，ctrl+shift+y变小写
	/**
	 * 排序
	 */
	private int sort;
	/**
	 * 备注
	 */
	private String remark;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getDictionaryId() {
		return dictionaryId;
	}

	public void setDictionaryId(int dictionaryId) {
		this.dictionaryId = dictionaryId;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
