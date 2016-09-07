package com.javaetime.framework.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.javaetime.entity.DictionaryEntity;
import com.javaetime.framework.util.SpringContextHolder;
import com.javaetime.web.dictionary.service.DictionaryService;

public class HtmlRadioTag extends TagSupport{
	private String type;
	private String id;
	private String name;
	private String html;
	private int value;
	
	private static final long serialVersionUID = 7296904942506374746L;
	
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		try {
			//从数据库查询的。即可
			//Spring取bean 把查询的数据放入缓存。
			DictionaryService dictionaryService = SpringContextHolder.getBean("dictionaryService");
			//按编码取字典集合,查询数据的条件
			DictionaryEntity param = new DictionaryEntity();
			param.setTypeCode(type);
			List<DictionaryEntity> list = dictionaryService.queryList(param);
			
			//定义要输出的html内容
			StringBuffer sb = new StringBuffer();
			for (DictionaryEntity d: list) {
				sb.append("<input type='radio' id='");
				sb.append(id);
				sb.append("' ");
				sb.append("name='");
				sb.append(name);
				sb.append("' ");
				sb.append("value='");
				sb.append(d.getKey());
				sb.append("' ");
				if(d.getKey().equals(String.valueOf(value))){
					sb.append("checked='checked'");
				}
				sb.append(html);
				sb.append("/>");
				sb.append(d.getValue());
			}
			out.print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.doStartTag();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
