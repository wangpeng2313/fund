package com.javaetime.web.fundHolding.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.FundAccountEntity;
import com.javaetime.entity.FundHoldingEntity;
import com.javaetime.entity.FundInfoEntity;
import com.javaetime.framework.BaseController;
import com.javaetime.framework.page.Pagination;
import com.javaetime.web.fundAccount.service.FundAccountService;
import com.javaetime.web.fundHolding.service.FundHoldingService;
import com.javaetime.web.fundInfo.service.FundInfoService;
@Controller
@RequestMapping(value="/fundHolding")
public class FundHoldingController extends BaseController{
	@Autowired
	private  FundHoldingService fundHoldingService;
	@Autowired
	private  FundAccountService fundAccountService;
	@Autowired
	private FundInfoService fundInfoService;
	
 /**
  * 查询
  */
	@RequestMapping(value="/queryAll")
	public String queryAll(Model model,Pagination pagination,FundHoldingEntity fundHoldingEntity){
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(),pagination.getPageSize()); 
		List<FundHoldingEntity> items = fundHoldingService.queryAll(pageBounds,fundHoldingEntity);
		model.addAttribute("items",items);
		return "fundHolding/list";
	}
	 /**
	  * 根据ID查询
	  */
		@RequestMapping(value="/deatil")
		public String queryById(Model model,Pagination pagination,int id){
			FundHoldingEntity items=fundHoldingService.queryById(id);
			//System.out.println(items.getFundInfoEntity().getName()+"------------");
			model.addAttribute("items",items);
			return "fundHolding/detail";
		}
		
		/**
		 * 增加
		 */
		@RequestMapping(value="/add")
		public String add(){
			return "fundHolding/add";
		}
	
		
		/**
		 * 查询 FundInfo表的 数据
		 */
		@RequestMapping("selectForPageList")
		public String selectForPageList(Model model,Pagination pagination) {
			PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
			List<FundInfoEntity> items = fundInfoService.queryAll(pageBounds);
			model.addAttribute(DEFAULT_ITEMS, items);
			
			return "fundHolding/selectfundinfo";
		}
		/**
		 * 查询Account表
		 */
		@RequestMapping("selectForAccountList")
		public String selectForAccountList(Model model,Pagination pagination) {
			PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
			List<FundAccountEntity> items = fundAccountService.queryAll(pageBounds);
			model.addAttribute(DEFAULT_ITEMS, items);
			
			return "fundHolding/selectfundaccount";
		}
		
		/**
		 * 增加值
		 */
		@RequestMapping(value="/addSave")
		public String addSave(Model model,RedirectAttributes redirectAttributes,FundHoldingEntity fundHoldingEntity){
			    System.out.println("----------插入一条记录--------");
				boolean addType = fundHoldingService.addSave(fundHoldingEntity);
				if(addType){
					redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DEFAULT_MESSAGE);
				}else{
					redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "该持仓信息已经存在!");
					return this.add();
				}
				return "redirect:/fundHolding/queryAll";
			
		}
		
		/**
		 * 删除
		 */
		@RequestMapping(value="/delete")
		public String delete(Model model,RedirectAttributes redirectAttributes,int id){
			boolean addType = fundHoldingService.delete(id);
			if(addType){
				redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DELETE_MESSAGE);
			}else{
				redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "删除失败");
			}
			return "redirect:/fundHolding/queryAll";
		}
		
		/**
		 * 进入修改页面
		 * @param model
		 * @param id
		 * @return
		 */
		@RequestMapping("edit")
		public String edit(Model model,int id){
			FundHoldingEntity item = fundHoldingService.queryById(id);
			model.addAttribute("item", item);
			return "fundHolding/edit";
		}
		
		/**
		 * 修改
		 * @param model
		 * @param redirectAttributes
		 * @param fundInfoEntity
		 * @return
		 */
		@RequestMapping("editSave")
		public String editSave(Model model, RedirectAttributes redirectAttributes,FundHoldingEntity fundHoldingEntity){
			boolean addType = fundHoldingService.editSave(fundHoldingEntity);
			if(addType){
				redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DEFAULT_MESSAGE);
			}else{
				redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "该持仓信息已经存在!");
				return "fundHolding/edit";
			}
			return "redirect:/fundHolding/queryAll";
			
		}
}
