package com.javaetime.web.fundHolding.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.FundAccountEntity;
import com.javaetime.entity.FundHoldingEntity;


/**
 * @time petter
 * @author petter
 *
 */
public interface FundHoldingService {

	/**
	 * 查询所有
	 * @return
	 */
	List<FundHoldingEntity> queryAll(PageBounds pageBounds,
			FundHoldingEntity fundHoldingEntity);

	FundHoldingEntity queryById(int id);

	boolean addSave(FundHoldingEntity fundHoldingEntity);


	boolean delete(int id);

	boolean editSave(FundHoldingEntity fundHoldingEntity);

	
	
}
