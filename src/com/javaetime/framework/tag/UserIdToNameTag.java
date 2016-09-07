package com.javaetime.framework.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 用户数据处理类
 * 
 * @author 赵俊鹏
 * @version 1.0
 * @company JavaETime
 * 
 */
public class UserIdToNameTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7255521437459833743L;
	/**
	 * 用户编号
	 */
	private long userId;

	public int doStartTag() {
		JspWriter out = this.pageContext.getOut();

		try {
			// Spring取bean
//			userService.queryById
//			userId.getName
			if(3 == userId){
				out.print("咨询经理");
			}else if(2 == userId){
				out.print("预约经理");
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

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}

}
