package com.javaetime.web.transactionInfo.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.TransactionInfoEntity;
import com.javaetime.web.transactionInfo.param.TransactionInfoParam;

public interface TransactionInfoService {
	public List<TransactionInfoEntity> queryForPageList(PageBounds pageBounds,TransactionInfoParam transactionInfoParam);
	public void addSave(TransactionInfoEntity transactionInfoEntity);
	public void deleteSave(int rid);
	public TransactionInfoEntity detail(int rid);
}
