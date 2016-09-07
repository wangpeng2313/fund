package com.javaetime.web.bankcard.ctrl;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.BankCardEntity;
import com.javaetime.entity.ClientEntity;
import com.javaetime.framework.BaseController;
import com.javaetime.framework.page.Pagination;
import com.javaetime.web.ClientInfo.param.ClientParam;
import com.javaetime.web.ClientInfo.service.ClientService;
import com.javaetime.web.bankcard.param.BankCardParam;
import com.javaetime.web.bankcard.service.BankCardService;

@Controller
@RequestMapping(value="/bankcard")
public class BankCardController  extends BaseController{

	public static final String NAME_SPACE = "bankcard/";
	@Autowired
	private BankCardService bankCardService;
	@Autowired
	private ClientService clientService;
	
	
	
	@RequestMapping("queryForPageList")
	public String queryForPageList(Model model,Pagination pagination,BankCardParam param){
		
		System.out.println("进入BankCardController的queryForPageList()方法");
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		
		List<BankCardEntity> items = bankCardService.queryForPageList(param, pageBounds);
		
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
		System.out.println("进入BankCardController的add方法");
		
		return NAME_SPACE + DEFAULT_ADD;
	}
	/**
	 * 保存预约信息
	 */
	@RequestMapping("addSave")
	public String addSave(Model model, RedirectAttributes redirectAttributes,BankCardEntity item) {
		System.out.println("进入BankCardController的addSave方法");
		
		bankCardService.addSave(item);
		redirectAttributes.addFlashAttribute("message", "操作成功！");
		model.addAttribute("url", NAME_SPACE+"success");
		return NAME_SPACE + "success";
	}
	/**
	 * 查询
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("selectForPageList")
	public String selectForPageList(Model model, Pagination pagination,ClientParam param) {
		System.out.println("进入BankCardController的selectForPageList()");
		//分页
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		List<ClientEntity> items = clientService.queryAll(pageBounds, param);
		model.addAttribute(DEFAULT_ITEMS, items);
		
		return NAME_SPACE + "select";
	}
	/**
	 * 修改页面
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("edit")
	public String edit(){
		System.out.println("进入BankCardController的edit方法");
		return NAME_SPACE + DEFAULT_EDIT;
	}
	/**
	 * 修改保存
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("editSave")
	public String editSave(Model model,BankCardEntity bankCardEntity,RedirectAttributes redirectAttributes ){
		System.out.println("进入BankCardController的editSave方法");
		if(bankCardService.queryById(bankCardEntity)){
			bankCardEntity.setAccstate(2);
			bankCardService.editSave(bankCardEntity);
			
			return NAME_SPACE + "success";
			
		}else{
			redirectAttributes.addFlashAttribute("message", "操作失败！");
			return NAME_SPACE + DEFAULT_EDIT;
		}
	}
	/**
	 * 删除页面
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(){
		System.out.println("进入BankCardController的delete方法");
		return NAME_SPACE + DEFAULT_DELETE;
	}
	/**
	 * 删除保存
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteSave")
	public String deleteSave(Model model,BankCardEntity bankCardEntity,RedirectAttributes redirectAttributes ){
		System.out.println("进入BankCardController的deleteSave方法");
		if(bankCardService.queryById(bankCardEntity)){
			bankCardEntity.setAccstate(3);
			bankCardService.editSave(bankCardEntity);
			
			return NAME_SPACE + "success";
			
		}else{
			redirectAttributes.addFlashAttribute("message", "操作失败！");
			return NAME_SPACE + DEFAULT_DELETE;
		}
	}
	
	@RequestMapping("deleteById")
	public String delete(Model model , long id,RedirectAttributes redirectAttributes){
		System.out.println("进入FundInfoController的delete()");
		System.out.println(id);
		boolean deleteType = bankCardService.deleteById(id);
		if(deleteType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DELETE_MESSAGE);
		}else{
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "删除失败!");
		}
		return DEFAULT_REDIRECT + NAME_SPACE + DEFAULT_QUERY_FOR_PAGE_LIST;
	}
}
