package com.javaetime.web.StaffInfo.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.Staff;
import com.javaetime.entity.StaffEntity;
import com.javaetime.web.StaffInfo.param.StaffParam;

/**
 * StaffService
 * @author 范兴贵
 * @time 2015.09.12 16:38
 */
public interface StaffService {
	/**
	 * 查询所有客户
	 * @return
	 */
	public List<Staff> queryAll();
	/**
	 * 添加客户
	 * @param staff
	 */
	public void insert(Staff staff);
	/**
	 * 添加预约
	 * @param staffEntity
	 * @return
	 */
	public boolean addSave(StaffEntity staffEntity);
	/**
	 * 查询预约
	 * @param param
	 * @param pageBounds
	 * @return
	 */
	public List<StaffEntity> queryForPageList(StaffParam param,PageBounds pageBounds);
	/**
	 * 按照id查询客户信息
	 * @param id
	 * @return
	 */
	public StaffEntity queryById(long id);
	/**
	 * 修改保存客户信息
	 * @param staffEntity
	 * @return
	 */
	public boolean editSave(StaffEntity staffEntity);
	/**
	 * 根据id删除用户数据
	 * @param id
	 */
	public boolean delete(Long id);
}
