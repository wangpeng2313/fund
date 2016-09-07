package com.javaetime.web.dictionary.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.DictionaryEntity;
import com.javaetime.web.dictionary.param.DictionaryParam.DictionaryParam;

/**
 * 字典管理的DAO
 * 
 * @author 褚瑞峰
 * 
 */
public interface DictionaryDao {
	/**
	 * 分页查询
	 * @param pageBounds 
	 * @param dictionaryParam 
	 * 
	 * @return
	 */
	public List<DictionaryEntity> queryForPageList(PageBounds pageBounds, DictionaryParam dictionaryParam);
	
	/**
	 * 添加
	 * @param item
	 */
	public boolean addSave(DictionaryEntity item);
	
	/**
	 * 查询
	 * @param item
	 * @return
	 */
	public List<DictionaryEntity> queryList(DictionaryEntity item);
	
	/**
	 * 跟据省查询城市信息
	 * @param parentId
	 * @return
	 */
	public List<DictionaryEntity> queryForCityList(long parentId);

	
	
	
	public DictionaryEntity detail(int dictionaryId);

	public boolean delete(int id);

	public boolean editSave(DictionaryEntity item);

	public int queryTelNum(DictionaryEntity item);
}
