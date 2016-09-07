package com.javaetime.web.dictionary.crtl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.DictionaryEntity;
import com.javaetime.framework.BaseController;
import com.javaetime.framework.page.Pagination;
import com.javaetime.web.dictionary.param.DictionaryParam.DictionaryParam;
import com.javaetime.web.dictionary.service.DictionaryService;

/**
 * 字典编码管理
 * 
 * @author 褚瑞峰
 * 
 */
@Controller
@RequestMapping("dictionary")
public class DictionaryController extends BaseController {

	@Resource
	public DictionaryService dictionaryService;
	/**
	 * 分页查询
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("queryForPageList")
	public String queryForPageList(Model model, Pagination pagination,DictionaryParam dictionaryParam) {
		//分页
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		//重构
		List<DictionaryEntity> items = dictionaryService.queryForPageList(pageBounds, dictionaryParam);
		//request.setAttribute//
		model.addAttribute("items", items);
		
		return "dictionary/list";
	}
	/**
	 * 根据ID查询
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("detail")
	public String detail(int id,Model model) {
		DictionaryEntity detail = dictionaryService.detail(id);
		model.addAttribute("items", detail);
		return "dictionary/check";
	}
	
	
	
	/**
	 * 通过跳转，进入添加页面
	 * @param model
	 * @param item
	 * @return
	 */
	@RequestMapping("add")
	public String add(Model model) {
		
		return "dictionary/add";
	}
	
	@RequestMapping("addSave")
	public String addSave(Model model,RedirectAttributes redirectAttributes, DictionaryEntity item) {
		
		boolean addType = dictionaryService.addSave(item);
		if(addType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DEFAULT_MESSAGE);
			return "redirect:/dictionary/queryForPageList";
		}else{
			System.out.println("1111111");
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DICTIONARY_ERROR);
			return "/dictionary/add";
		}
	}
	/**
	 * 请求json数据
	 * @param parentId
	 * @return
	 */
	@RequestMapping("queryForCityList")
	@ResponseBody
	public List<DictionaryEntity> queryForCityList(long parentId){
		//如果省的编码为0；
		if(parentId == 0){
			return new ArrayList<DictionaryEntity>();
		}
		List<DictionaryEntity> cityList = dictionaryService.queryForCityList(parentId);
		return cityList;
	}
	
	/**
	 * 删除
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(Model model,RedirectAttributes redirectAttributes,int id){
		boolean addType = dictionaryService.delete(id);;
		if(addType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DELETE_MESSAGE);
		}else{
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "删除失败");
		}
		return "redirect:/dictionary/queryForPageList";
	}
	/**
	 * 跳转修改页面
	 * @param model
	 * @param id
	 * @return
	 */
	
	@RequestMapping("edit")
	public String edit(Model model,int id){
		DictionaryEntity detail =dictionaryService.detail(id);
		model.addAttribute("items", detail);
		return "/dictionary/edit";
	}
	/**
	 * 修改
	 * @param model
	 * @param item
	 * @return
	 */
	@RequestMapping("editSave")
	public String editSave(Model model,RedirectAttributes redirectAttributes,DictionaryEntity item){	
		boolean addType = dictionaryService.editSave(item);
		if(addType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DEFAULT_MESSAGE);
			return "redirect:/dictionary/queryForPageList";
		}else{
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "该信息已经存在！");
			return "redirect:/dictionary/edit";
		}	

	}

	

}
