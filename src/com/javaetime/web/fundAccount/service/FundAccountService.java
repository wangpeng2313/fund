package com.javaetime.web.fundAccount.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.FundAccountEntity;
import com.javaetime.framework.page.Pagination;
import com.javaetime.web.fundAccount.param.FundAccountParam;


/**
 * @time petter
 * @author petter
 *
 */
public interface FundAccountService {
	
	
	/**
	 * 查询所有
	 * @param param TODO
	 * @return
	 */


	public List<FundAccountEntity> queryForList(PageBounds pageBounds, FundAccountParam param);
	/**
	 * 删除
	 * @param id
	 */
    public boolean deleteSave(int id);
    /**
     * 添加
     * 
     */
    public void addSave(FundAccountEntity fundAccountEntity);
    
    public FundAccountEntity queryById(int id);
    
    public boolean editSave(FundAccountEntity fundAccountEntity);
	public List<FundAccountEntity> queryAll(PageBounds pageBounds);
   
}
