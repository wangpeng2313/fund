package com.javaetime.web.Position.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.PositionEntity;
import com.javaetime.web.Position.param.PositionParam;



/**
 * 职位管理的DAO
 * 
 * @author 褚瑞峰
 * 
 */
public interface PositionDao {

	
	/**
	 * 分页查询
	 * @param pageBounds 
	 * @param dictionaryParam 
	 * 
	 * @return
	 */
	List<PositionEntity> queryForPageList(PageBounds pageBounds,PositionParam param);

	
	
	/**
	 * 添加
	 * @param item
	 */
	boolean addSava(PositionEntity positionEntity);



	PositionEntity detail(int id);



	boolean editSave(PositionEntity entity);



	boolean delete(int id);



	int queryTelNum(PositionEntity positionEntity);
	
}
