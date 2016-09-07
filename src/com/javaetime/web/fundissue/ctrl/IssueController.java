package com.javaetime.web.fundissue.ctrl;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.IssueEntity;
import com.javaetime.framework.BaseController;
import com.javaetime.framework.page.Pagination;
import com.javaetime.web.fundInfo.service.FundInfoService;
import com.javaetime.web.fundissue.param.IssueParam;
import com.javaetime.web.fundissue.service.IssueService;

@Controller
@RequestMapping("/issue")
public class IssueController extends BaseController{

	public static final String NAME_SPACE = "issue/";
	
	@Autowired
	private IssueService issueService;
	
	@Autowired
	private FundInfoService fundInfoService;
	
	@RequestMapping("queryForPageList")
	public String queryForPageList(Model model,Pagination pagination,IssueParam param){
		
		System.out.println("进入IssueController的queryForPageList()");
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		
		List<IssueEntity> items = issueService.queryForPageList(param, pageBounds);
		
		model.addAttribute(DEFAULT_ITEMS, items);
		model.addAttribute(DEFAULT_PARAM, param);
		
		return NAME_SPACE + DEFAULT_LIST;
	}
	
	/**
	 * 进入add页面
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("add")
	public String add(Model model, ServletRequest request) {
		System.out.println("进入IssueController的add方法");
		
		return NAME_SPACE + DEFAULT_ADD;
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("addSave")
	public String addSave(Model model, RedirectAttributes redirectAttributes,IssueEntity item) {
		System.out.println("进入IssueController的addSave方法");
		//设置当前登录人的ID
		//item.setManagerId(getCurrentUserId());
		
		boolean addType = issueService.addSave(item);
		
		if(addType){
			//可以重定向的时候,传值
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DEFAULT_MESSAGE);
		}else{
			//可以重定向的时候,传值
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "该预约客户已经存在!");
		}
		return DEFAULT_REDIRECT + NAME_SPACE + DEFAULT_QUERY_FOR_PAGE_LIST;
	}
	/**
	 * 修改页面
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("edit")
	public String edit(Model model,long id){
		System.out.println("进入IssueController的edit方法");
		IssueEntity item = issueService.queryById(id);
		model.addAttribute(DEFAULT_ITEM, item);
		
		return NAME_SPACE + DEFAULT_EDIT;
	}
	
	/**
	 * 修改保存
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("editSave")
	public String editSave(Model model,IssueEntity entity,RedirectAttributes redirectAttributes ){
		System.out.println("进入IssueController的editSave方法");
		boolean returnType = issueService.editSave(entity);
		
		if(returnType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DEFAULT_MESSAGE);
		}else{
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "客户电话号码已存在!");
		}
		
		return DEFAULT_REDIRECT + NAME_SPACE + DEFAULT_QUERY_FOR_PAGE_LIST;
	}
	
	/**
	 * 查询客户信息明细
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("detail")
	public String detail(Model model,long id){
		System.out.println("进入IssueController的detail方法");
		IssueEntity item = issueService.queryById(id);
		model.addAttribute(DEFAULT_ITEM, item);
		
		return NAME_SPACE + DEFAULT_DETAIL;
	}
	@RequestMapping("delete")
	public String delete(Model model,long id,RedirectAttributes redirectAttributes){
		System.out.println("进入IssueController的delete方法");
		boolean deleteType = fundInfoService.delete(id);
		boolean deleteT = issueService.deleteSave(id);
		if(deleteT){
			if(deleteType){
				redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "删除失败!");
			}else{
				redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DELETE_MESSAGE);
			}
		}
		
		return DEFAULT_REDIRECT + NAME_SPACE + DEFAULT_QUERY_FOR_PAGE_LIST;
	}
	
	@RequestMapping("queryByName")
	public String queryByName(Model model,Pagination pagination,IssueParam param){
		System.out.println("进入IssueController的queryByName方法");
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		
		List<IssueEntity> items = issueService.queryForPageList(param, pageBounds);
		
		model.addAttribute(DEFAULT_ITEMS, items);
		model.addAttribute(DEFAULT_PARAM, param);
		
		return  "fundinfo/select";
	}
}
