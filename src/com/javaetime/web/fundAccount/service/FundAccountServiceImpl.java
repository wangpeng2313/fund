package com.javaetime.web.fundAccount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.FundAccountEntity;
import com.javaetime.framework.page.Pagination;
import com.javaetime.web.fundAccount.dao.FundAccountDao;
import com.javaetime.web.fundAccount.param.FundAccountParam;
@Component("FundAccountService")
@Transactional
public class FundAccountServiceImpl implements FundAccountService {

	@Autowired
	private  FundAccountDao fundAccountDao;
	@Override
	public List<FundAccountEntity> queryForList(PageBounds pageBounds, FundAccountParam param) {
		
		return fundAccountDao.queryForList(pageBounds, param);
	}

	@Override
	public boolean deleteSave(int id) {
		;
		return fundAccountDao.deleteSave(id);
		
	}

	@Override
	public void addSave(FundAccountEntity fundAccountEntity) {
		fundAccountDao.addSave(fundAccountEntity);
		
	}

	@Override
	public FundAccountEntity queryById(int id) {
		return fundAccountDao.queryById(id);
	}

	@Override
	public boolean editSave(FundAccountEntity fundAccountEntity) {
		return fundAccountDao.editSave(fundAccountEntity);
	}

	@Override
	public List<FundAccountEntity> queryAll(PageBounds pageBounds) {
		return fundAccountDao.queryAll(pageBounds);
	}

}
