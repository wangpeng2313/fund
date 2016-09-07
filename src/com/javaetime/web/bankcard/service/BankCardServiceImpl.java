package com.javaetime.web.bankcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.BankCardEntity;
import com.javaetime.web.bankcard.dao.BankCardDao;
import com.javaetime.web.bankcard.param.BankCardParam;

@Component("bankCardService")
@Transactional
public class BankCardServiceImpl implements BankCardService {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	
	public static final int HASH_INTERATIONS = 1024;
	
	@Autowired
	private BankCardDao bankCardDao;
	
	@Override
	public void addSave(BankCardEntity bankCardEntity) {
		System.out.println("进入BankCardServiceImpl的addSave()方法");
		bankCardDao.addSave(bankCardEntity);
		
	}

	@Override
	public boolean editSave(BankCardEntity bankCardEntity) {
		System.out.println("进入BankCardServiceImpl的editSave()方法");
		return bankCardDao.editSave(bankCardEntity);
	}

	@Override
	public boolean deleteSave(BankCardEntity bankCardEntity) {
		System.out.println("进入BankCardServiceImpl的deleteSave()方法");
		return bankCardDao.deleteSave(bankCardEntity);
	}

	@Override
	public List<BankCardEntity> queryForPageList(BankCardParam param,
			PageBounds pageBounds) {
		System.out.println("进入BankCardServiceImpl的queryForPageList()方法");
		return bankCardDao.queryForPageList(param, pageBounds);
	}

	@Override
	public boolean deleteById(long id) {
		System.out.println("进入BankCardServiceImpl的deleteById()方法");
		return bankCardDao.deleteById(id);
	}

	@Override
	public boolean queryById(BankCardEntity bankCardEntity) {
		System.out.println("进入BankCardServiceImpl的queryById()方法");
		int ss=bankCardDao.queryById(bankCardEntity);
		if(ss==0){
			return false;
		}else{
			bankCardDao.queryByIdList(bankCardEntity);
			return true;
		}
	}

}
