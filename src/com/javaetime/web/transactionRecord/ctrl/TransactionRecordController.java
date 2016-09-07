package com.javaetime.web.transactionRecord.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.FundAccountEntity;
import com.javaetime.entity.FundInfoEntity;
import com.javaetime.entity.TransactionRecordEntity;
import com.javaetime.framework.BaseController;
import com.javaetime.framework.page.Pagination;
import com.javaetime.web.fundAccount.service.FundAccountService;
import com.javaetime.web.fundInfo.service.FundInfoService;
import com.javaetime.web.transactionRecord.param.TransactionRecordParam;
import com.javaetime.web.transactionRecord.service.TransactionRecordService;
/**
 * TransactionRecordController
 * @author zym
 * @time 2015-09-14
 */
@Controller
@RequestMapping("/transactionRecord")
public class TransactionRecordController extends BaseController{
	
	public static final String NAME_SPACE = "transactionRecord/";
	
	@Autowired
	private TransactionRecordService transactionRecordService;
	
	@Autowired
	private FundInfoService fundInfoService;
	
	@Autowired
	private FundAccountService fundAccountService;
	/**
	 * 查询
	 * @param model
	 * @param pagination
	 * @param param
	 * @return
	 */
	@RequestMapping("queryForPageList")
	public String queryForPageList(Model model ,Pagination pagination,TransactionRecordParam param){
		
		System.out.println("进入TransactionRecordController的queryForPageList()");
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		
		List<TransactionRecordEntity> items = transactionRecordService.queryForPageList(pageBounds, param);
		
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
	public String delete(Model model , long trId,RedirectAttributes redirectAttributes){
		System.out.println("进入TransactionRecordController的delete()");
		
		boolean deleteType = transactionRecordService.delete(trId);
		if(deleteType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DELETE_MESSAGE);
		}else{
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "删除失败");
		}
		return DEFAULT_REDIRECT + NAME_SPACE + DEFAULT_QUERY_FOR_PAGE_LIST;
	}
	/**
	 * 进入添加页面
	 * @return
	 */
	@RequestMapping("add")
	public String add(){
		System.out.println("进入TransactionRecordController的add()");
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
	public String aadSave(Model model, RedirectAttributes redirectAttributes,TransactionRecordEntity transactionRecordEntity){
		
		System.out.println("进入TransactionRecordController的addSave()");
		
		boolean addType = transactionRecordService.addSave(transactionRecordEntity);
		
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
	public String edit(Model model , int trId){
		System.out.println("进入TransactionRecordController的edit()");
		TransactionRecordEntity item = transactionRecordService.queryById(trId);
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
	public String editSave(Model model, RedirectAttributes redirectAttributes,TransactionRecordEntity transactionRecordEntity){
		
		System.out.println("进入TransactionRecordController的editSave()");
		
		boolean addType = transactionRecordService.editSave(transactionRecordEntity);
		
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
	public String detail(Model model,int trId){
		System.out.println("进入TransactionRecordController的detail()");
		TransactionRecordEntity item = transactionRecordService.queryById(trId);
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
		System.out.println("进入TransactionRecordController的selectForPageList()");
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		List<FundInfoEntity> items = fundInfoService.queryAll(pageBounds);
		model.addAttribute(DEFAULT_ITEMS, items);
		
		return NAME_SPACE + "selectfundinfo";
	}
	/**
	 * 查询
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("selectForAccountList")
	public String selectForAccountList(Model model,Pagination pagination) {
		System.out.println("进入TransactionRecordController的selectForAccountList()");
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		List<FundAccountEntity> items = fundAccountService.queryAll(pageBounds);
		model.addAttribute(DEFAULT_ITEMS, items);
		
		return NAME_SPACE + "selectfundaccount";
	}
}
