package com.javaetime.web.fundissue.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.IssueEntity;
import com.javaetime.web.fundissue.param.IssueParam;
/**
 * IssueDao
 * @author zym
 * @time 2015-09-13
 */
public interface IssueDao {
	
	/**
	 * 查询全部
	 * @return
	 */
	public List<IssueEntity> queryForPageList(IssueParam param,PageBounds pageBounds);
	
	/**
	 * 查询手机号码数量
	 * @param item
	 * @return
	 */
	public int queryTelNum(IssueEntity issueEntity);
	
	/**
	 * 根据id查询一条
	 * @return
	 */
	public IssueEntity queryById(long id); 
	
	/**
	 * 根据一条id删除
	 * @param id
	 */
	public boolean deleteSave(long id);
	
	/**
	 * 添加
	 * @param issueEntity
	 */
	public void addSave(IssueEntity issueEntity);
	
	/**
	 * 修改
	 * @param issueEntity
	 */
	public void editSave(IssueEntity issueEntity);
	
	public List<IssueEntity> queryAll(PageBounds pageBounds);
}
