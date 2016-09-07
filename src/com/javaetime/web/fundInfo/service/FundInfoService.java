package com.javaetime.web.fundInfo.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.FundInfoEntity;
import com.javaetime.web.fundInfo.param.FundInfoParam;
/**
 * FundInfoService
 * @author zym
 * @time 2015-09-14
 */
public interface FundInfoService {
	
	public List<FundInfoEntity> queryForPageList(PageBounds pageBounds,FundInfoParam param);
	public boolean addSave(FundInfoEntity fundInfoEntity);
	public boolean delete(long id);
	public FundInfoEntity queryById(int infoId);
	public boolean editSave(FundInfoEntity fundInfoEntity);
	public List<FundInfoEntity> findByName(String name);
	/**
	 * 查看
	 * 
	 * @param id
	 * @return
	 */
	public FundInfoEntity detail(long id);
	public List<FundInfoEntity> queryAll(PageBounds pageBounds);
}
