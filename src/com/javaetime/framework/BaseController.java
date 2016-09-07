package com.javaetime.framework;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;

import com.javaetime.web.account.service.ShiroDbRealm.ShiroUser;

/**
 * 控制类父类
 * 
 * @author 赵俊鹏
 * @version 1.0
 * @company Java E Time（时代）
 * @QQ 8031541
 * @site http://www.javaetime.com
 * 
 */
public class BaseController {

	@SuppressWarnings("unused")
	private final Logger log = Logger.getLogger(BaseController.class.getName());

	public static final String REDIRECT_URL_KEY = "url";

	public static final String AUTO_REDIRECT_TYPE = "autoRedirectType";

	public static final String REDIRECT_DEFAULT_MESSAGE = "操作成功！";
	public static final String REDIRECT_DELETE_MESSAGE = "删除成功！";
	public static final String REDIRECT_DICTIONARY_ERROR ="该字典类型编码已经存在!";

	public static final String REDIRECT_MESSAGE_KEY = "message";
	public static final String REDIRECT_ERROR_PAGE = "frame/error";

	public static final String REDIRECT_BUSINESS_EXCEPTION_ERROR_PAGE = "frame/business_error";

	public static final String SESSION_KEY = "WNT_SESSION";
	
	/**
	 * items集合的key
	 */
	public static final String DEFAULT_ITEMS = "items";
	/**
	 * param的key
	 */
	public static final String DEFAULT_PARAM = "param";
	/**
	 * item
	 */
	public static final String DEFAULT_ITEM = "item";
	/**
	 * 默认请求queryForPageList
	 */
	public static final String DEFAULT_QUERY_FOR_PAGE_LIST = "queryForPageList";
	/**
	 * 默认列表LIST页面
	 */
	public static final String DEFAULT_LIST = "list";
	/**
	 * 默认列表add页面
	 */
	public static final String DEFAULT_ADD = "add";
	/**
	 * 默认列表edit页面
	 */
	public static final String DEFAULT_EDIT = "edit";
	/**
	 * 默认列表delete页面
	 */
	public static final String DEFAULT_DELETE = "delete";
	/**
	 * 默认列表detail页面
	 */
	public static final String DEFAULT_DETAIL = "detail";
	/**
	 * 默认列表redirect页面
	 */
	public static final String DEFAULT_REDIRECT = "redirect:/";
	
	
	/**
	 * 取出Shiro中的当前用户Id.
	 */
	protected Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.id;
	}

	/**
	 * 取出Shiro中的当前用户
	 */
	protected ShiroUser getCurrentUser() {
		
		return (ShiroUser) SecurityUtils.getSubject().getPrincipal();
	}
}
