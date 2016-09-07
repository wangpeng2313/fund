package com.javaetime.web.StaffInfo.ctrl;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.DeptEntity;
import com.javaetime.entity.StaffEntity;
import com.javaetime.framework.BaseController;
import com.javaetime.framework.page.Pagination;
import com.javaetime.web.DeptInfo.service.DeptService;
import com.javaetime.web.StaffInfo.param.StaffParam;
import com.javaetime.web.StaffInfo.service.StaffService;

/**
 * StaffController
 * @author 范兴贵
 * @time 2015.09.12
 */
@Controller
@RequestMapping(value="/staff")
public class StaffController extends BaseController{
	public static final String NAME_SPACE = "staff/";
	@Autowired
	private StaffService staffService;
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("queryForPageList")
	public String queryForPageList(Model model, Pagination pagination,StaffParam param) {
		System.out.println("进入StaffController的queryForPageList方法");
		//分页
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		List<StaffEntity> items = staffService.queryForPageList(param, pageBounds);
		
		//回放数据到页面
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
		System.out.println("进入StaffController的add方法");
		
		return NAME_SPACE + DEFAULT_ADD;
	}
	/**
	 * 保存员工信息
	 */
	@RequestMapping("addSave")
	public String addSave(Model model, RedirectAttributes redirectAttributes,StaffEntity item) {
		System.out.println("进入StaffController的addSave方法");
		staffService.addSave(item);
		redirectAttributes.addFlashAttribute("message", "操作成功！");
		model.addAttribute("url", NAME_SPACE+DEFAULT_QUERY_FOR_PAGE_LIST);
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
		System.out.println("进入StaffController的edit方法");
		StaffEntity item = staffService.queryById(id);
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
	public String editSave(Model model,StaffEntity entity,RedirectAttributes redirectAttributes ){
		System.out.println("进入StaffController的editSave方法");
		boolean returnType = staffService.editSave(entity);
		
		if(returnType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DEFAULT_MESSAGE);
		}else{
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "客户电话号码已存在!");
		}
		
		return DEFAULT_REDIRECT + NAME_SPACE + DEFAULT_QUERY_FOR_PAGE_LIST;
	}
	
	/**
	 * 查询员工信息明细
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("detail")
	public String detail(Model model,long id){
		System.out.println("进入StaffController的detail方法");
		StaffEntity item = staffService.queryById(id);
		model.addAttribute(DEFAULT_ITEM, item);
		
		return NAME_SPACE + DEFAULT_DETAIL;
	}
	/**
	 * 根据id删除员工信息
	 * @param model
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(Model model,long id,RedirectAttributes redirectAttributes){
		System.out.println("进入StaffController的delete方法");
		boolean deleteType = staffService.delete(id);
		if(deleteType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DELETE_MESSAGE);
		}else{
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "删除失败!");
		}
		
		return DEFAULT_REDIRECT + NAME_SPACE + DEFAULT_QUERY_FOR_PAGE_LIST;
	}
	/**
	 * 查询选择
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("selectForPageList")
	public String selectForPageList(Model model, Pagination pagination) {
		System.out.println("进入StaffController的selectForPageList()");
		//分页
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		 List<DeptEntity> items = deptService.queryAll(pageBounds);
		model.addAttribute(DEFAULT_ITEMS, items);
		
		return NAME_SPACE + "select";
	}
}
