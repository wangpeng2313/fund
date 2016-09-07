package com.javaetime.web.dictionary.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.DictionaryEntity;
import com.javaetime.web.dictionary.param.DictionaryParam.DictionaryParam;

/**
 * 字典管理接口
 * 
 * @author 褚瑞峰
 * @Email:8031541@qq.com
 * 
 */
public interface DictionaryService {
	
	/**
	 * 分页
	 * @param pageBounds
	 * @param dictionaryParam
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

	public DictionaryEntity detail(int id);

	public boolean delete(int id);

	public boolean editSave(DictionaryEntity item);
	
}
