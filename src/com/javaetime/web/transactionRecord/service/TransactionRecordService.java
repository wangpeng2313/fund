package com.javaetime.web.transactionRecord.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.TransactionRecordEntity;
import com.javaetime.web.transactionRecord.param.TransactionRecordParam;
/**
 * TransactionRecordService
 * @author fxg
 * @time 2015-09-14
 */
public interface TransactionRecordService {
	
	/**
	 * 查询所有信息
	 * @param pageBounds
	 * @param param
	 * @return
	 */
	public List<TransactionRecordEntity> queryForPageList(PageBounds pageBounds,TransactionRecordParam param);
	/**
	 * 增加信息
	 * @param transactionRecordEntity
	 * @return
	 */
	public boolean addSave(TransactionRecordEntity transactionRecordEntity);
	/**
	 * 删除信息
	 * @param id
	 * @return
	 */
	public boolean delete(long trId);
	/**
	 * 根据id查询信息
	 * @param trId
	 * @return
	 */
	public TransactionRecordEntity queryById(int trId);
	/**
	 * 编辑信息
	 * @param transactionRecordEntity
	 * @return
	 */
	public boolean editSave(TransactionRecordEntity transactionRecordEntity);
	/**
	 * 查看
	 * 
	 * @param id
	 * @return
	 */
	public TransactionRecordEntity detail(long trId);
}
