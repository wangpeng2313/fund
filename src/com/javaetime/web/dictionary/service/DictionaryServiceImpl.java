package com.javaetime.web.dictionary.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.DictionaryEntity;
import com.javaetime.web.dictionary.dao.DictionaryDao;
import com.javaetime.web.dictionary.param.DictionaryParam.DictionaryParam;

/**
 * 字典编码接口实现
 * 
 * @author 褚瑞峰
 * 
 */
@Component("dictionaryService")
@Transactional
public class DictionaryServiceImpl implements DictionaryService {

	@Resource
	public DictionaryDao dictionaryDao;

	@Override
	public List<DictionaryEntity> queryForPageList(PageBounds pageBounds, DictionaryParam dictionaryParam) {
		return dictionaryDao.queryForPageList(pageBounds, dictionaryParam);
	}

	@Override
	public boolean addSave(DictionaryEntity item) {
		 int PhoneNum = dictionaryDao.queryTelNum(item);
			if(PhoneNum == 0){
				dictionaryDao.addSave(item);
				return true;
			}else{
				return false;
			}
	}

	@Override
	public List<DictionaryEntity> queryList(DictionaryEntity item) {

		return dictionaryDao.queryList(item);
	}

	@Override
	public List<DictionaryEntity> queryForCityList(long parentId) {

		return dictionaryDao.queryForCityList(parentId);
	}

	@Override
	public DictionaryEntity detail(int id) {
		return dictionaryDao.detail(id);
	}

	@Override
	public boolean delete(int id) {
		dictionaryDao.delete(id);
		return true;
	}

	@Override
	public boolean editSave(DictionaryEntity item) {
		 int PhoneNum = dictionaryDao.queryTelNum(item);
			if(PhoneNum == 0){
				dictionaryDao.editSave(item);
				return true;
			}else{
				return false;
			}
	}

}
