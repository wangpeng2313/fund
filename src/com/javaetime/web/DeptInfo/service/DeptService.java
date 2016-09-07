package com.javaetime.web.DeptInfo.service;

import java.util.List;
import java.util.Map;


import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.DeptEntity;
import com.javaetime.web.DeptInfo.param.DeptParam;

public interface DeptService {
	
	
	public List<DeptEntity> queryForPageList(DeptParam deptParam,PageBounds pageBounds);
	public boolean addSave(DeptEntity deptEntity);
	public boolean delete(int deptId);
	public DeptEntity queryById(int deptId);
	public boolean edit(DeptEntity deptEntity);
	public DeptEntity detail(long id);
	/**
	 * 查询所有
	 * @return
	 */
	public List<DeptEntity> queryAll(PageBounds pageBounds);
	public List<Map<String,Object>> queryAllInfo();
	}


