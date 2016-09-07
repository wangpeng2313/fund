package com.javaetime.web.ClientInfo.ctrl;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.ClientEntity;
import com.javaetime.framework.BaseController;
import com.javaetime.framework.page.Pagination;
import com.javaetime.web.ClientInfo.param.ClientParam;
import com.javaetime.web.ClientInfo.service.ClientService;
/**
 * @time 20150912
 * @author petter
 * QQ872024775
 */
@Controller
@RequestMapping(value="/ClientInfo")

public class ClientController extends BaseController{

	@Autowired
	private  ClientService clientService; 

@RequestMapping(value="/list")


	/**
	 * 
	 * @return
	 * 分页查询
	 */
public String list(Model model,Pagination pagination,ClientParam param) {
		System.out.println("----------查询全部--------");
		//分页对像参数
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		List<ClientEntity> items= clientService.queryAll(pageBounds,param);
		
		model.addAttribute("items",items);
	    model.addAttribute("param", param);
	    
		 return "ClientInfo/list";
	}

/**
 * 删除
 * @return
 * 
 */
@RequestMapping("delete")
public String deleteSave(Model model,RedirectAttributes redirectAttributes,int id){
	System.out.println("----------删除一条记录--------");
    boolean deleteType = clientService.deleteSave(id);
    if(deleteType){
		redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DELETE_MESSAGE);
	}else{
		redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "删除失败!");
	}
	return   "redirect:/ClientInfo/list";
}


/**
 * 添加页面
 * 
 * @return
 */
@RequestMapping("add")
public String add(){
	System.out.println("----------进入插入页面--------");
	return "ClientInfo/add";
}

/**
 * 保存
 * 
 * @param model
 * @param requst
 * @param Coding
 * @return
 */
@RequestMapping("addSave")
public String addSave(Model model,RedirectAttributes redirectAttributes,ClientEntity clientEntity){
	System.out.println("----------插入一条记录--------");
	boolean addType = clientService.addSave(clientEntity);
	if(addType){
		redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DEFAULT_MESSAGE);
	}else{
		redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "该预约客户已经存在!");
	}
    System.out.println(clientEntity.getEmail());
	return "redirect:/ClientInfo/list";
}

/**
 * 进入修改页面
 * @return
 */

@RequestMapping("edit")
public String edit(Model model,Integer id){
	System.out.println("----------进入修改页面--------");
	model.addAttribute("item",clientService.findById(id));
	return "ClientInfo/edit";
}
/**
 * 修改
 * 
 * @param model
 * @param requst
 * @param Coding
 * @return
 */
@RequestMapping("editSave")
public String editSave(Model model,RedirectAttributes redirectAttributes,ClientEntity clientEntity){
	System.out.println("----------修改一条记录--------");
	boolean editType = clientService.editSave(clientEntity);
	if(editType){
		redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DEFAULT_MESSAGE);
	}else{
		redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "该预约客户已经存在!");
	}
	//System.out.println(clientEntity.getEmail());
	return "redirect:/ClientInfo/list";

}
/**
 * 进入详情页面
 * @return
 */

@RequestMapping("detail")
public String detail(Model model,ServletRequest request,Integer id){
	System.out.println("----------进入详情页面--------");
	model.addAttribute("item",clientService.findById(id));
	return "ClientInfo/detail";
}
@RequestMapping("queryByName")
public String queryByName(Model model,Pagination pagination,ClientParam param){
	System.out.println("进入ClientController的queryByName方法");
	PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());

	List<ClientEntity> items = clientService.queryAll(pageBounds, param);
	
	model.addAttribute(DEFAULT_ITEMS,items);
	model.addAttribute(DEFAULT_PARAM, param);
	return "bankcard/select";

}
@RequestMapping("queryForByName")
public String queryForByName(Model model,Pagination pagination,ClientParam param){
	System.out.println("进入ClientController的queryByName方法");
	PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
	
	List<ClientEntity> items = clientService.queryAll(pageBounds, param);
	
	model.addAttribute(DEFAULT_ITEMS,items);
	model.addAttribute(DEFAULT_PARAM, param);
	return "fundAccount/select";
	
}
}
