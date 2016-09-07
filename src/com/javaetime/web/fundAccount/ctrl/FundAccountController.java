package com.javaetime.web.fundAccount.ctrl;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.ClientEntity;
import com.javaetime.entity.FundAccountEntity;
import com.javaetime.framework.BaseController;
import com.javaetime.framework.page.Pagination;
import com.javaetime.web.ClientInfo.service.ClientService;
import com.javaetime.web.fundAccount.param.FundAccountParam;
import com.javaetime.web.fundAccount.service.FundAccountService;

@Controller
@RequestMapping(value="/fundAccount")
public class FundAccountController extends BaseController{
	public static final String NAME_SPACE="fundAccount/";

	@Autowired
	private  FundAccountService fundAccountService;
	@Autowired
	private ClientService clientService;
	
    /**
     * 查询
     * @param param 
     */
	@RequestMapping(value="/queryForPageList")
	public String queryForList(Model model,Pagination pagination, FundAccountParam param){
		System.out.println("----------进入queryForList（）方法-----------");
		    PageBounds pageBounds = new PageBounds(pagination.getPageIndex(),pagination.getPageSize()); 
			List<FundAccountEntity> items = fundAccountService.queryForList(pageBounds, param);
			
			model.addAttribute(DEFAULT_ITEMS,items);
			
		
			return NAME_SPACE + DEFAULT_LIST;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/delete")
	public String deleteSave(int id,RedirectAttributes redirectAttributes){
		System.out.println("--------------进入deleteSave（）方法-----------");
		boolean deleteType = fundAccountService.deleteSave(id);
		if(deleteType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DELETE_MESSAGE);
		}else{
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "删除失败!");
		}
		
		return  DEFAULT_REDIRECT + NAME_SPACE + DEFAULT_QUERY_FOR_PAGE_LIST;
		
	}
	/**
	 * 增加
	 */
	@RequestMapping(value="/add")
	public  String  add(){
		System.out.println("----------进入插入页面--------");
		return NAME_SPACE  +  DEFAULT_ADD;
	}
	/**
	 * 增加值
	 */
	@RequestMapping(value="/addSave")
	public String addSave(Model model,ServletRequest request,RedirectAttributes redirectAttributes,FundAccountEntity fundAccountEntity){
		    System.out.println("----------插入一条记录--------");
	        fundAccountService.addSave(fundAccountEntity);
	        redirectAttributes.addFlashAttribute("message", "操作成功！");
			model.addAttribute("url", NAME_SPACE+DEFAULT_QUERY_FOR_PAGE_LIST);
	  return DEFAULT_REDIRECT + NAME_SPACE + DEFAULT_QUERY_FOR_PAGE_LIST;
		
	}
	

/**
 * 查询 另一个表的 数据
 * @param pageBounds 
 */
	@RequestMapping("selectForPageList")

	public String selectForPageList(Model model, Pagination pagination ) {
		System.out.println("进入FundAccountController的selectForPageList()");
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(),pagination.getPageSize());
		List<ClientEntity> items = clientService.queryForClientEntity(pageBounds);

		model.addAttribute(DEFAULT_ITEMS, items);
		
		return NAME_SPACE + "select";
	}
	/**
	 * 按一条ID查询
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("detail")
	public String detail(Model model,int id){
		System.out.println("进入FundAccountController的detail()");
		FundAccountEntity item = fundAccountService.queryById(id);
		model.addAttribute(DEFAULT_ITEM, item);
		return NAME_SPACE + DEFAULT_DETAIL;
		
	}
	/**
	 * 进入修改页面
	 * @param model
	 * @param infoId
	 * @return
	 */
	@RequestMapping("edit")
	public String edit(Model model , int id){
		System.out.println("进入FundAccountController的edit()");
		//按照id查询
		
		FundAccountEntity item = fundAccountService.queryById(id);
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
	public String editSave(Model model, RedirectAttributes redirectAttributes,FundAccountEntity fundAccountEntity){
		
		System.out.println("进入FundAccountController的editSave()");
		
		boolean addType = fundAccountService.editSave(fundAccountEntity);
		
		if(addType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DEFAULT_MESSAGE);
		}else{
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "该预约客户已经存在!");
		}
		return DEFAULT_REDIRECT + NAME_SPACE + DEFAULT_QUERY_FOR_PAGE_LIST;
		
	}

	@RequestMapping("queryByName")
	public String queryByName(Model model,Pagination pagination,FundAccountParam param){
		System.out.println("进入FundAccountController的queryByName方法");
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());

		List<FundAccountEntity> items = fundAccountService.queryForList(pageBounds, param);
		
		model.addAttribute(DEFAULT_ITEMS,items);
		model.addAttribute(DEFAULT_PARAM, param);
		return "transactionRecord/selectfundaccount";

	}
	@RequestMapping("queryforByName")
	public String queryforByName(Model model,Pagination pagination,FundAccountParam param){
		System.out.println("进入FundAccountController的queryforByName方法");
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		
		List<FundAccountEntity> items = fundAccountService.queryForList(pageBounds, param);
		
		model.addAttribute(DEFAULT_ITEMS,items);
		model.addAttribute(DEFAULT_PARAM, param);
		return "fundHolding/selectfundaccount";
		
	}

}
