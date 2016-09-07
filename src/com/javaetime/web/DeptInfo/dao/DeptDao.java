package com.javaetime.web.DeptInfo.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.DeptEntity;
import com.javaetime.web.DeptInfo.param.DeptParam;
/**
 * 部门类的dao接口
 * @author 王洋洋
 *
 */
public interface DeptDao {
	/**
	 * 查询所有数据
	 * @param pageBounds
	 * @param deptEntity
	 * @return
	 */
	public List<DeptEntity> queryForPageList(PageBounds pageBounds,DeptParam deptParam);
	public boolean addSave(DeptEntity deptEntity);
	public boolean delete(int deptId);
	public DeptEntity queryById(int deptId);
	public boolean edit(DeptEntity deptEntity);
	public List<DeptEntity> findByName(String deptName);
	/**
	 * 查看
	 * 
	 * @param id
	 * @return
	 */
	public DeptEntity detail(long id);
	/**
	 * 查询所有
	 * @return
	 */
	public List<DeptEntity> queryAll(PageBounds pageBounds);
	public List<Map<String,Object>> queryAllInfo();
	 
}
