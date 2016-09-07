package com.javaetime.web.StaffInfo.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.Staff;
import com.javaetime.entity.StaffEntity;
import com.javaetime.web.StaffInfo.param.StaffParam;

/**
 * StaffDao
 * @author fxg
 * @time 2015.09.12 16:30
 */
public interface StaffDao {
		/**
		 * 插入用户数据
		 * @param customer
		 */
		public void insert(Staff staff);
		/**
		 * 修改用户数据
		 * @param customer
		 */
		public void update(Staff staff);
		/**
		 * 根据id删除用户数据
		 * @param id
		 */
		public boolean delete(Long id);
		/**
		 * 查询用户
		 * @param customer
		 */
		public void find(Staff staff);
		/**
		 * 查询用户
		 * @param customer
		 */
		public void queryForPageList(Staff staff);
		/**
		 * 查询所有用户数据
		 * @return
		 */
		public List<Staff> queryAll();
		/**
		 * 添加预约
		 * @param customerEntity
		 */
		public boolean addSave(StaffEntity staffEntity);
		/**
		 * 查询手机号码数量
		 * @param item
		 * @return
		 */
		public int queryTelNum(StaffEntity staffEntity);
		/**
		 * 查询预约
		 * @param param
		 * @param pageBounds
		 * @return
		 */
		public List<StaffEntity> queryForPageList(StaffParam param,PageBounds pageBounds);
		/**
		 * 根据id查询客户信息
		 * @param id
		 * @return
		 */
		public StaffEntity queryById(long id);
		/**
		 * 修改客户信息
		 * @param customerEntity
		 */
		public void editSave(StaffEntity staffEntity);
		/**
		 * 按部门名称查询
		 * @param deptId
		 * @return
		 */
		public List<StaffEntity> queryListByDeptId(long deptId);

	
}
