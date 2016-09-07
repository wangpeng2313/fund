package com.javaetime.web.transactionInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.TransactionInfoEntity;
import com.javaetime.web.transactionInfo.dao.TransactionInfoDao;
import com.javaetime.web.transactionInfo.param.TransactionInfoParam;
@Component("transactionInfo")
@Transactional
public class TransactionInfoSeviceImpl implements TransactionInfoService{
	@Autowired
    private TransactionInfoDao transactionInfoDao;
	@Override
	public List<TransactionInfoEntity> queryForPageList(PageBounds pageBounds,TransactionInfoParam transactionInfoParam) {
		return transactionInfoDao.queryForPageList(pageBounds,transactionInfoParam);
	}
	@Override
	public void addSave(TransactionInfoEntity transactionInfoEntity) {
		transactionInfoDao.addSave(transactionInfoEntity);
	}
	@Override
	public void deleteSave(int rid) {
		transactionInfoDao.deleteSave(rid);
	}
	@Override
	public TransactionInfoEntity detail(int rid) {
		return transactionInfoDao.detail(rid);
	}

}
