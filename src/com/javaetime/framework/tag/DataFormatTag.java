package com.javaetime.framework.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 字典处理类
 * 
 * @author 赵俊鹏
 * @version 1.0
 * @company JavaETime
 * @site http://www.javaetime.com
 * 
 */
public class DataFormatTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 日期值
	 */
	private Date value;
	
	private String type = "yyyy-MM-dd";
	

	public int doStartTag() {
		JspWriter out = this.pageContext.getOut();

		try {
			//道先取到字典类型 ： SEX 然后 通过字典的类型 ，找出这个字典的集合，然后再循环集合，对比key，得到value
			SimpleDateFormat df = new SimpleDateFormat(type);
			out.print(df.format(value));
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

	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



}
