package com.javaetime.framework.page;

import java.io.Serializable;

/**
 * 系统分页
 * 
 * @author 赵俊鹏
 * 
 */
public class Pagination implements Serializable {

	private static final long serialVersionUID = 8448493431974549591L;
	/**
	 * 当前页号
	 */
	private int pageIndex = 1;

	/**
	 * 总记录数
	 */
	private int recordCount;

	/**
	 * 每页记录数
	 */
	private int pageSize = 3;

	/**
	 * 构造函数
	 */
	public Pagination() {
	}

	/**
	 * 构造函数
	 * 
	 * @param pageIndex
	 *            当前页序
	 * @param pageSize
	 *            每页记录数
	 */
	public Pagination(int pageIndex, int pageSize) {
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}

	/**
	 * 构造函数
	 * 
	 * @param pageIndex
	 *            当前页序
	 * @param pageSize
	 *            每页记录数
	 * @param recordCount
	 *            总记录数
	 */
	public Pagination(int pageIndex, int pageSize, int recordCount) {
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {

		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageCount() {
		int pageCount = recordCount / pageSize;
		int modValue = recordCount % pageSize;
		if (modValue > 0) {
			pageCount++;
		}
		return pageCount;
	}
}
