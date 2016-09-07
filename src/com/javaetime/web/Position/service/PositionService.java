package com.javaetime.web.Position.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.PositionEntity;
import com.javaetime.web.Position.param.PositionParam;

/**
 * 职位管理接口
 * 
 * @author 褚瑞峰
 * 
 */
public interface PositionService {

	
	
	/**
	 * 分页
	 * @param pageBounds
	 * @param dictionaryParam
	 * @return
	 */
	List<PositionEntity> queryForPageList(PageBounds pageBounds,PositionParam param);

	
	/**
	 * 添加
	 * @param item
	 */
		 boolean addSave(PositionEntity positionEntity);


	PositionEntity detail(int id);


	boolean editSave(PositionEntity entity);


	boolean delete(int id);


}
