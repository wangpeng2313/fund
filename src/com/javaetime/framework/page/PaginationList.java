package com.javaetime.framework.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 系统分页
 * 
 * @author 赵俊鹏
 * 
 */
public class PaginationList<T> implements Serializable {

	private static final long serialVersionUID = 5123557012709363594L;

	/** 分页信息 */
	private Pagination pagination;

	/** 记录 */
	private List<T> records = new ArrayList<T>();

	/**
	 * 构造函数
	 */
	public PaginationList() {

	}

	/**
	 * 构造函数
	 * 
	 * @param pagination
	 *            分页信息
	 * @param records
	 *            记录
	 */
	public PaginationList(Pagination pagination, List<T> records) {
		this.pagination = pagination;
		this.records = records;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public List<?> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}
}
