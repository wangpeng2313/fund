package com.javaetime.web.fundHolding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.FundHoldingEntity;
import com.javaetime.web.fundHolding.dao.FundHoldingDao;
@Component("FundHoldingService")
@Transactional
public class FundHoldingServiceImpl implements FundHoldingService {
	@Autowired
	private  FundHoldingDao fundHoldingDao;
	@Override
	public List<FundHoldingEntity> queryAll(PageBounds pageBounds,FundHoldingEntity fundHoldingEntity) {
		return fundHoldingDao.queryAll(pageBounds,fundHoldingEntity);
	}
	@Override
	public FundHoldingEntity queryById(int id) {
		return fundHoldingDao.queryById(id);
	}
	@Override
	public boolean addSave(FundHoldingEntity fundHoldingEntity) {
		
		System.out.println("======"+fundHoldingEntity.gethId());
		int PhoneNum = fundHoldingDao.queryTelNum(fundHoldingEntity);
		System.out.println("-------"+PhoneNum);
		if(PhoneNum == 0){
			fundHoldingDao.addSave(fundHoldingEntity);
			return true;
		}else{
			return false;
		}
	}
	@Override
	public boolean delete(int id) {
		return fundHoldingDao.delete(id);
	}
	@Override
	public boolean editSave(FundHoldingEntity fundHoldingEntity) {
		System.out.println("======"+fundHoldingEntity.gethId());
		int PhoneNum = fundHoldingDao.queryTelNum(fundHoldingEntity);
		System.out.println("-------"+PhoneNum);
		if(PhoneNum == 0){
			fundHoldingDao.editSave(fundHoldingEntity);
			return true;
		}else{
			return false;
		}
	}
	
}
