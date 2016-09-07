package com.javaetime.web.fundInfo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.FundInfoEntity;
import com.javaetime.web.fundInfo.dao.FundInfoDao;
import com.javaetime.web.fundInfo.param.FundInfoParam;
/**
 * FundInfoServiceImpl
 * @author zym
 * @time 2015-09-14
 */
@Component("FundInfoService")
public class FundInfoServiceImpl implements FundInfoService {

	@Resource
	private FundInfoDao fundInfoDao;
	
	@Override
	public boolean addSave(FundInfoEntity fundInfoEntity) {

		System.out.println("进入FundInfoServiceImpl的addSave()方法");
		return fundInfoDao.addSave(fundInfoEntity);
		
	}

	@Override
	public boolean delete(long id) {

		System.out.println("进入FundInfoServiceImpl的delete()方法");
		return fundInfoDao.delete(id);
	}

	@Override
	public FundInfoEntity detail(long id) {
		System.out.println("进入FundInfoServiceImpl的detail()方法");
		return fundInfoDao.detail(id);
	}

	@Override
	public boolean editSave(FundInfoEntity fundInfoEntity) {

		System.out.println("进入FundInfoServiceImpl的edit()方法");
		return fundInfoDao.editSave(fundInfoEntity);
	}

	@Override
	public List<FundInfoEntity> findByName(String name) {
		System.out.println("进入FundInfoServiceImpl的findByName()方法");
		return fundInfoDao.findByName(name);
	}

	@Override
	public FundInfoEntity queryById(int infoId) {
		System.out.println("进入FundInfoServiceImpl的queryById()方法");
		return fundInfoDao.queryById(infoId);
	}

	@Override
	public List<FundInfoEntity> queryForPageList(PageBounds pageBounds,
			FundInfoParam param) {
		System.out.println("进入FundInfoServiceImpl的queryForPageList()方法");
		return fundInfoDao.queryForPageList(pageBounds, param);
	}

	@Override
	public List<FundInfoEntity> queryAll(PageBounds pageBounds) {
		System.out.println("进入FundInfoServiceImpl的queryAll()方法");
		return fundInfoDao.queryAll(pageBounds);
	}

}
