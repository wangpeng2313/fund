package com.javaetime.web.transactionRecord.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.TransactionRecordEntity;
import com.javaetime.web.fundAccount.dao.FundAccountDao;
import com.javaetime.web.transactionRecord.dao.TransactionRecordDao;
import com.javaetime.web.transactionRecord.param.TransactionRecordParam;
/**
 * TransactionRecordServiceImpl
 * @author fxg
 * @time 2015-09-14
 */
@Component("TransactionRecordService")
@Transactional
public class TransactionRecordServiceImpl implements TransactionRecordService {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	
	public static final int HASH_INTERATIONS = 1024;
	
	@Autowired
	private TransactionRecordDao transactionRecordDao;
	@SuppressWarnings("unused")
	@Autowired
	private FundAccountDao fundAccountDao;
	@Override
	public boolean addSave(TransactionRecordEntity transactionRecordEntity) {
		System.out.println("进入TransactionRecordServiceImpl的addSave()方法");
		return transactionRecordDao.addSave(transactionRecordEntity);
	}

	@Override
	public boolean delete(long trId) {
		System.out.println("进入TransactionRecordServiceImpl的delete()方法");
		return transactionRecordDao.delete(trId);
	}

	@Override
	public TransactionRecordEntity detail(long trId) {
		System.out.println("进入TransactionRecordServiceImpl的detail()方法");
		return transactionRecordDao.detail(trId);
	}

	@Override
	public boolean editSave(TransactionRecordEntity transactionRecordEntity) {
		System.out.println("进入TransactionRecordServiceImpl的editSave()方法");
		return transactionRecordDao.editSave(transactionRecordEntity);
	}

	@Override
	public TransactionRecordEntity queryById(int trId) {
		System.out.println("进入TransactionRecordServiceImpl的queryById()方法");
		return transactionRecordDao.queryById(trId);
	}

	@Override
	public List<TransactionRecordEntity> queryForPageList(
			PageBounds pageBounds, TransactionRecordParam param) {
		System.out.println("进入TransactionRecordServiceImpl的queryForPageList()方法");
		return transactionRecordDao.queryForPageList(pageBounds, param);
	}

	

}
