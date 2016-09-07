package com.javaetime.web.fundInfo.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.FundAccountEntity;
import com.javaetime.entity.FundInfoEntity;
import com.javaetime.entity.IssueEntity;
import com.javaetime.framework.BaseController;
import com.javaetime.framework.page.Pagination;
import com.javaetime.web.fundAccount.param.FundAccountParam;
import com.javaetime.web.fundInfo.param.FundInfoParam;
import com.javaetime.web.fundInfo.service.FundInfoService;
import com.javaetime.web.fundissue.service.IssueService;
/**
 * FundInfoController
 * @author zym
 * @time 2015-09-14
 */
@Controller
@RequestMapping("/fundinfo")
public class FundInfoController extends BaseController{
	
	public static final String NAME_SPACE = "fundinfo/";
	
	@Autowired
	private FundInfoService fundInfoService;
	
	@Autowired
	private IssueService issueService;
	/**
	 * 查询
	 * @param model
	 * @param pagination
	 * @param param
	 * @return
	 */
	@RequestMapping("queryForPageList")
	public String queryForPageList(Model model ,Pagination pagination,FundInfoParam param){
		
		System.out.println("进入FundInfoController的queryForPageList()");
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		
		List<FundInfoEntity> items = fundInfoService.queryForPageList(pageBounds, param);
		
		model.addAttribute(DEFAULT_ITEMS,items);
		model.addAttribute(DEFAULT_PARAM, param);
		
		return NAME_SPACE + DEFAULT_LIST;
	}
	/**
	 * 删除
	 * @param model
	 * @param infoId
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(Model model , long id,RedirectAttributes redirectAttributes){
		System.out.println("进入FundInfoController的delete()");
		
		boolean deleteType = fundInfoService.delete(id);
		if(deleteType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DELETE_MESSAGE);
		}else{
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "删除失败!");
		}
		return DEFAULT_REDIRECT + NAME_SPACE + DEFAULT_QUERY_FOR_PAGE_LIST;
	}
	/**
	 * 进入添加页面
	 * @return
	 */
	@RequestMapping("add")
	public String add(){
		System.out.println("进入FundInfoController的add()");
		return NAME_SPACE + DEFAULT_ADD;
	}
	/**
	 * 添加
	 * @param model
	 * @param redirectAttributes
	 * @param fundInfoEntity
	 * @return
	 */
	@RequestMapping("addSave")
	public String aadSave(Model model, RedirectAttributes redirectAttributes,FundInfoEntity fundInfoEntity){
		
		System.out.println("进入FundInfoController的addSave()");
		
		boolean addType = fundInfoService.addSave(fundInfoEntity);
		
		if(addType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DEFAULT_MESSAGE);
		}else{
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "该预约客户已经存在!");
		}
		return DEFAULT_REDIRECT + NAME_SPACE + DEFAULT_QUERY_FOR_PAGE_LIST;
		
	}
	/**
	 * 进入修改页面
	 * @param model
	 * @param infoId
	 * @return
	 */
	@RequestMapping("edit")
	public String edit(Model model , int id){
		System.out.println("进入FundInfoController的edit()");
		FundInfoEntity item = fundInfoService.queryById(id);
		model.addAttribute(DEFAULT_ITEM, item);
		return NAME_SPACE + DEFAULT_EDIT;
	}
	/**
	 * 修改
	 * @param model
	 * @param redirectAttributes
	 * @param fundInfoEntity
	 * @return
	 */
	@RequestMapping("editSave")
	public String editSave(Model model, RedirectAttributes redirectAttributes,FundInfoEntity fundInfoEntity){
		
		System.out.println("进入FundInfoController的editSave()");
		
		boolean addType = fundInfoService.editSave(fundInfoEntity);
		
		if(addType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DEFAULT_MESSAGE);
		}else{
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "该预约客户已经存在!");
		}
		return DEFAULT_REDIRECT + NAME_SPACE + DEFAULT_QUERY_FOR_PAGE_LIST;
		
	}
	/**
	 * 按一条ID查询
	 * @param model
	 * @param infoId
	 * @return
	 */
	@RequestMapping("detail")
	public String detail(Model model,int id){
		System.out.println("进入FundInfoController的detail()");
		FundInfoEntity item = fundInfoService.queryById(id);
		model.addAttribute(DEFAULT_ITEM, item);
		return NAME_SPACE + DEFAULT_DETAIL;
		
	}
	
	/**
	 * 查询
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("selectForPageList")
	public String selectForPageList(Model model,Pagination pagination) {
		System.out.println("进入FundInfoController的selectForPageList()");
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		List<IssueEntity> items = issueService.queryAll(pageBounds);
		model.addAttribute(DEFAULT_ITEMS, items);
		
		return NAME_SPACE + "select";
	}
	@RequestMapping("queryByName")
	public String queryByName(Model model,Pagination pagination,FundInfoParam param){
		System.out.println("进入FundInfoController的queryByName方法");
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		
		List<FundInfoEntity> items = fundInfoService.queryForPageList(pageBounds, param);
		
		model.addAttribute(DEFAULT_ITEMS, items);
		model.addAttribute(DEFAULT_PARAM, param);
		
		return  "transactionRecord/selectfundinfo";
	}
}
