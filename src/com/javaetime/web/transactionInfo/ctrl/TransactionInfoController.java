package com.javaetime.web.transactionInfo.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.FundAccountEntity;
import com.javaetime.entity.TransactionInfoEntity;
import com.javaetime.framework.BaseController;
import com.javaetime.framework.page.Pagination;
import com.javaetime.web.fundAccount.service.FundAccountService;
import com.javaetime.web.transactionInfo.param.TransactionInfoParam;
import com.javaetime.web.transactionInfo.service.TransactionInfoService;

@Controller
@RequestMapping(value = "/transactionInfo")
public class TransactionInfoController extends BaseController {
	@Autowired
	private TransactionInfoService transactionInfoService;
	@Autowired
	private FundAccountService fundAccountService;
	@RequestMapping("queryForPageList")
	public String queryForPageList(Model model, Pagination pagination,TransactionInfoParam transactionInfoParam){
		System.out.println("欢迎进入查询页面（list）");
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		List<TransactionInfoEntity> items = transactionInfoService.queryForPageList(pageBounds,transactionInfoParam);
		System.out.println(items.size());
		model.addAttribute("items",items );
		model.addAttribute("item", transactionInfoParam);
		return "transactionInfo/list";
	}
	
	@RequestMapping("add")
	public String toadd(){
		System.out.println("欢迎进入添加页面");
		return "transactionInfo/add";
	}
	
	@RequestMapping("addSave")
	public String addSave(Model model,TransactionInfoEntity transactionInfoEntity){
		System.out.println("欢迎添加");
		transactionInfoService.addSave(transactionInfoEntity);
		return "redirect:/transactionInfo/queryForPageList";
	}
	
	@RequestMapping("delete")
	public String deleteSave(int rid){
		System.out.println("--------");
		transactionInfoService.deleteSave(rid);
		System.out.println("---++++++++--");
		return "redirect:/transactionInfo/queryForPageList";
	}
	
	@RequestMapping("detail")
	public String detail(Model model,int rid){
		System.out.println("====================");
		TransactionInfoEntity items = transactionInfoService.detail(rid);
		model.addAttribute("items",items);
		return "transactionInfo/detail";
	}
	/**
	 * 查询Account表
	 */
	@RequestMapping("selectForAccountList")
	public String selectForAccountList(Model model,Pagination pagination) {
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		List<FundAccountEntity> items = fundAccountService.queryAll(pageBounds);
		model.addAttribute(DEFAULT_ITEMS, items);
		
		return "transactionInfo/selectfundaccount";
	}
}
