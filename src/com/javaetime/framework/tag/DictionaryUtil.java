package com.javaetime.framework.tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javaetime.entity.DictionaryEntity;

/**
 * 静态字典
 * 
 * @author 赵俊鹏
 * @version 1.0
 * @company JavaETime
 * @site http://www.javaetime.com
 * 
 */
public class DictionaryUtil {

	public static Map<String, Map<Integer, String>> mapDictionary = new HashMap<String, Map<Integer, String>>();
	public static Map<String, List<DictionaryEntity>> listDictionary = new HashMap<String, List<DictionaryEntity>>();
	/**
	 * 性别字典KEY
	 */
	public static final String SEX = "SEX";

	public static String getDictionaryValue(String type, int key) {
		List<DictionaryEntity> list = getDictionaryList(type);
		for(DictionaryEntity d : list) {
			if(d.getKey().equals(key+"")||d.getKey()==key+""){
				return d.getValue();
			}
		}
		return "";
	}

	public static List<DictionaryEntity> getDictionaryList(String type) {
		List<DictionaryEntity> list = listDictionary.get(type);
		return list == null ? new ArrayList<DictionaryEntity>() : list;
	}

	/**
	 * 初始化字典
	 */
	static {
		List<DictionaryEntity> SEX_LIST = new ArrayList<DictionaryEntity>();
		DictionaryEntity d0 = new DictionaryEntity();
		d0.setKey(String.valueOf(0));
		d0.setValue("请选择");
		SEX_LIST.add(d0);

		DictionaryEntity d1 = new DictionaryEntity();
		d1.setKey(String.valueOf(1));
		d1.setValue("男");
		SEX_LIST.add(d1);

		DictionaryEntity d2 = new DictionaryEntity();
		d2.setKey(String.valueOf(2));
		d2.setValue("女");
		SEX_LIST.add(d2);

		listDictionary.put(DictionaryUtil.SEX, SEX_LIST);
	}

}
