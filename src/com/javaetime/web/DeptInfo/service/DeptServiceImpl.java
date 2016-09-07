package com.javaetime.web.DeptInfo.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.DeptEntity;
import com.javaetime.web.DeptInfo.dao.DeptDao;
import com.javaetime.web.DeptInfo.param.DeptParam;

@Component("deptService")
@Transactional
public class DeptServiceImpl implements DeptService {

	@Resource
	private DeptDao deptDao;
	
	@Override
	public List<DeptEntity> queryForPageList(DeptParam deptParam,PageBounds pageBounds) {
		System.out.println("进入DeptServiceImpl的queryForPageList()方法");
		return deptDao.queryForPageList(pageBounds,deptParam);
	}

	@Override
	public boolean addSave(DeptEntity deptEntity) {
		System.out.println("进入DeptServiceImpl的addSave()方法");
		return deptDao.addSave(deptEntity);
		
	}
/**
 * 根据ID对数据库进行删除
 */
	@Override
	public boolean delete(int deptId) {
		System.out.println("进入DeptServiceImpl的delete()方法");
		return deptDao.delete(deptId);
		
	}
	/**
	 * 查看数据详情
	 */
	@Override
	public DeptEntity queryById(int deptId) {
		System.out.println("进入DeptServiceImpl的queryById()方法");
		return deptDao.queryById(deptId);
		
	}

	@Override
	public boolean edit(DeptEntity deptEntity) {
		System.out.println("进入DeptServiceImpl的edit()方法");
		return deptDao.edit(deptEntity);
		
	}
	@Override
	public DeptEntity detail(long id) {
		// TODO Auto-generated method stub
		return deptDao.detail(id);
	}

	@Override
	public List<DeptEntity> queryAll(PageBounds pageBounds) {
		// TODO Auto-generated method stub
		return deptDao.queryAll(pageBounds);
	}

	@Override
	public List<Map<String, Object>> queryAllInfo() {
		return deptDao.queryAllInfo();
	}
}
