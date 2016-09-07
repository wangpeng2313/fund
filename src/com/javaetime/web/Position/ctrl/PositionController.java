package com.javaetime.web.Position.ctrl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.PositionEntity;
import com.javaetime.framework.BaseController;
import com.javaetime.framework.page.Pagination;
import com.javaetime.web.Position.param.PositionParam;
import com.javaetime.web.Position.service.PositionService;


/**
 * 字典编码管理
 * 
 * @author 褚瑞峰
 * 
 */
@Controller
@RequestMapping("position")
public class PositionController extends BaseController {

	@Resource
	public PositionService positionService;
	/**
	 * 分页查询
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("queryForPageList")
	public String queryForPageList(Model model, Pagination pagination,PositionParam param) {
		//分页
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		//重构
		List<PositionEntity> items = positionService.queryForPageList(pageBounds, param);
		//request.setAttribute//
		model.addAttribute("items", items);
		
		return "position/list";
	}
	/**
	 * 通过跳转，进入添加页面
	 * @param model
	 * @param item
	 * @return
	 */
	@RequestMapping("add")
	public String add(Model model) {
		
		return "position/add";
	}
	
	@RequestMapping("addSave")
	public String addSave(Model model,RedirectAttributes redirectAttributes, PositionEntity positionEntity) {
		boolean addType = positionService.addSave(positionEntity);
		
		if(addType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DEFAULT_MESSAGE);
			return "redirect:/position/queryForPageList";
		}else{
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "该部门已经存在!");
			return this.add(model);
		}			
		
	}
	
	
	@RequestMapping("detail")
	public String detail(Model model,int id){
		PositionEntity entity=positionService.detail(id);
		model.addAttribute("item", entity);
		return "/position/detail";
	}
	@RequestMapping("edit")
	public String edit(Model model,int id){
		PositionEntity entity =positionService.detail(id);
		model.addAttribute("items", entity);
		return "/position/edit";
	}
	
	/**
	 * 修改
	 * @param model
	 * @param item
	 * @return
	 */
	@RequestMapping("editSave")
	public String editSave(Model model,RedirectAttributes redirectAttributes,PositionEntity entity){
		boolean addType = positionService.editSave(entity);
		if(addType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DEFAULT_MESSAGE);
			return "redirect:/position/queryForPageList";
		}else{
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "该部门已经存在!");
			return this.edit(model, entity.getPositionId());
		}	
	}

	/**
	 * 删除
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(Model model,RedirectAttributes redirectAttributes,int id){
		boolean addType = positionService.delete(id);
		if(addType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DELETE_MESSAGE);
		}else{
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "删除失败！");
		}	
		return "redirect:/position/queryForPageList";
	}

	

}
