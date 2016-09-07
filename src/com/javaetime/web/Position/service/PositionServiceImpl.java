package com.javaetime.web.Position.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.PositionEntity;
import com.javaetime.web.Position.dao.PositionDao;
import com.javaetime.web.Position.param.PositionParam;


/**
 * 职位编码接口实现
 * 
 * @author 褚瑞峰
 * 
 */
@Component("positionService")
@Transactional
public class PositionServiceImpl implements PositionService {

	@Resource
	public PositionDao positionDao;

	@Override
	public List<PositionEntity> queryForPageList(PageBounds pageBounds,
			PositionParam param) {
		return positionDao.queryForPageList(pageBounds,param);
	}

	@Override
	public boolean addSave(PositionEntity positionEntity) {
		 	int PhoneNum = positionDao.queryTelNum(positionEntity);
			if(PhoneNum == 0){
				positionDao.addSava(positionEntity);
				return true;
			}else{
				return false;
			}
	}

	@Override
	public PositionEntity detail(int id) {
		return positionDao.detail(id);
	}

	@Override
	public boolean editSave(PositionEntity entity) {
		int PhoneNum = positionDao.queryTelNum(entity);
		if(PhoneNum == 0){
			positionDao.editSave(entity);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		return positionDao.delete(id);
	}

	
}
