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
 * 
 */
public class HtmlSelectTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * select html id
	 */
	private String id;
	/**
	 * select html name
	 */
	private String name;
	/**
	 * selected option value
	 */
	private String value;
	/**
	 * 字典类型 
	 */
	private String type;
	/**
	 * 允许使用html代码
	 */
	private String html;
	//是否出现可选择项
	private String haveSelect = "false";
	/**
	 * parentId父ID，当需要父子级别数据时使用
	 */
	private int parentId = 0;
	
	public int doStartTag() {
		JspWriter out = this.pageContext.getOut();

		try {
			//从数据库查询的。即可
			//Spring取bean 把查询的数据放入缓存。
			DictionaryService dictionaryService = SpringContextHolder.getBean("dictionaryService");
			//按编码取字典集合,查询数据的条件
			DictionaryEntity param = new DictionaryEntity();
			param.setTypeCode(type);
			//静态代码
			if("CITY".equals(type) && parentId == 0){
				parentId = -1;
			}
			param.setParentId(parentId);
			List<DictionaryEntity> list = dictionaryService.queryList(param);
			
			//定义要输出的html内容
			StringBuffer htmlBody = new StringBuffer();
			htmlBody.append("<select ");
			if(id != null && !"".equals(id)){
				htmlBody.append(" id='");
				htmlBody.append(id);
				htmlBody.append("'");
			}
			if(name != null && !"".equals(name)){
				htmlBody.append(" name='");
				htmlBody.append(name);
				htmlBody.append("' ");
			}
			if(html != null && !"".equals(html)){
				htmlBody.append(html);
			}
			htmlBody.append(">");
			if("true".equals(haveSelect)){
				htmlBody.append("<option value='0'>--请选择--</option>");
			}
			for(DictionaryEntity d : list){
				htmlBody.append("<option value='");
				htmlBody.append(d.getKey());
				htmlBody.append("'");
				if(value != null && !"".equals(value) && value.equals(d.getKey())){
					htmlBody.append(" selected='selected'");
				}
				htmlBody.append(">");
				htmlBody.append(d.getValue());
				htmlBody.append("</option>");
			}
			htmlBody.append("</select>");
			//组装结束
			out.print(htmlBody.toString());
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHaveSelect() {
		return haveSelect;
	}

	public void setHaveSelect(String haveSelect) {
		this.haveSelect = haveSelect;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}



}
