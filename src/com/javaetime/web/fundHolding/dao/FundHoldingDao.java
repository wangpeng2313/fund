package com.javaetime.web.fundHolding.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.FundHoldingEntity;

/**
 * @time 20150915
 * @author 褚瑞峰
 */
public interface FundHoldingDao {

	
	/**
	 * 查询所有
	 * @param fundHoldingEntity 
	 * @return
	 */
	List<FundHoldingEntity> queryAll(PageBounds pageBounds, FundHoldingEntity fundHoldingEntity);
	FundHoldingEntity queryById(int id);
	void addSave(FundHoldingEntity fundHoldingEntity);
	boolean delete(int id);
	boolean editSave(FundHoldingEntity fundHoldingEntity);
	int queryTelNum(FundHoldingEntity fundHoldingEntity);
	
}
