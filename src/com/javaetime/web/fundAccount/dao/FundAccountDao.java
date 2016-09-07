package com.javaetime.web.fundAccount.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.FundAccountEntity;
import com.javaetime.web.fundAccount.param.FundAccountParam;

/**
 * @time 20150914
 * @author petter QQ:872024775
 */
public interface FundAccountDao {
	/**
	 * 查询所有
	 * @param param TODO
	 * 
	 * @return
	 */
	public List<FundAccountEntity> queryForList(PageBounds pageBounds, FundAccountParam param);

 /**
  *  删除
  */
	
	public boolean deleteSave(int id );


	/**
	 * 增加
	 */
	public void addSave(FundAccountEntity fundAccountEntity);

	/**
	 * 按照id查询
	 * 
	 * @param id
	 * @return
	 */
	public FundAccountEntity queryById(int id);

	/**
	 * 编辑
	 * 
	 * @param fundAccountEntity
	 * @return
	 */

	public boolean editSave(FundAccountEntity fundAccountEntity);
   public List<FundAccountEntity> queryAll(PageBounds pageBounds);
   public int update(FundAccountEntity fundAccountEntity);
}
