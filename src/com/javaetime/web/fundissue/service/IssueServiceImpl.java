package com.javaetime.web.fundissue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.IssueEntity;
import com.javaetime.framework.page.Pagination;
import com.javaetime.web.fundInfo.dao.FundInfoDao;
import com.javaetime.web.fundissue.dao.IssueDao;
import com.javaetime.web.fundissue.param.IssueParam;
/**
 * IssueServiceImpl
 * @author zym
 * @time 2015-09-13
 */
@Component("issueService")
@Transactional
public class IssueServiceImpl implements IssueService{

public static final String HASH_ALGORITHM = "SHA-1";
	
	public static final int HASH_INTERATIONS = 1024;
	
	
	@Autowired
	private IssueDao issueDao;
	
	@Autowired
	private FundInfoDao fundInfoDao;
	
	@Override
	public boolean deleteSave(long id) {
		fundInfoDao.delete(id);
		return issueDao.deleteSave(id);
	}

	@Override
	public boolean addSave(IssueEntity issueEntity) {
		System.out.println("进入IssueServiceImpl的addSave()方法");
		int PhoneNum = issueDao.queryTelNum(issueEntity);
		System.out.println(PhoneNum);
		if(PhoneNum == 0){
			issueDao.addSave(issueEntity);
			return true;
		}else{
			return false;
		}
		
		
	}

	/**
	 * @param issueEntity
	 */

	@Override
	public List<IssueEntity> queryForPageList(IssueParam param,PageBounds pageBounds){
		System.out.println("进入IssueServiceImpl的queryForPageList()方法");

		return issueDao.queryForPageList(param, pageBounds);
	}

	@Override
	public IssueEntity queryById(long id) {
		System.out.println("进入IssueServiceImpl的queryById()方法");
		return issueDao.queryById(id);
	}

	@Override
	public boolean editSave(IssueEntity issueEntity) {
		System.out.println("进入IssueServiceImpl的editSave()方法");

		issueDao.editSave(issueEntity);
		return true;
	}

	@Override
	public List<IssueEntity> queryAll(PageBounds pageBounds) {
		System.out.println("进入IssueServiceImpl的queryAll()方法");
		return issueDao.queryAll(pageBounds);
	}

}
