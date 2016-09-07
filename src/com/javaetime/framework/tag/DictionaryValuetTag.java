package com.javaetime.framework.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.javaetime.entity.DictionaryEntity;
import com.javaetime.framework.util.SpringContextHolder;
import com.javaetime.web.dictionary.service.DictionaryService;

/**
 * 字典处理类
 * 
 * @author 赵俊鹏
 * @version 1.0
 * @company JavaETime
 * @site http://www.javaetime.com
 * 
 */
public class DictionaryValuetTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 字典类型
	 */
	private String type;
	
	/**
	 * 字典值
	 */
	private int key;
	/**
	 * parentId父ID，当需要父子级别数据时使用
	 */
	private int parentId;
	
	public int doStartTag() {
		JspWriter out = this.pageContext.getOut();

		try {
			//Spring取bean 把查询的数据放入缓存。
			DictionaryService dictionaryService = SpringContextHolder.getBean("dictionaryService");
			//按编码取字典集合
			DictionaryEntity param = new DictionaryEntity();
			param.setTypeCode(type);
			//静态代码。。CITY值可以从配置文件中取得
			if("CITY".equals(type) && parentId==0){
				parentId = -1;
			}
			param.setParentId(parentId);
			List<DictionaryEntity> list = dictionaryService.queryList(param);
			//根据KEY取字典的值
			for (DictionaryEntity d : list) {
				if(d.getKey().equals(String.valueOf(key))){
					out.print(d.getValue());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return EVAL_BODY_INCLUDE;
	}

	public int doAfterBody() throws JspException {
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

}
