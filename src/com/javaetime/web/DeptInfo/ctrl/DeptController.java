package com.javaetime.web.DeptInfo.ctrl;


import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.javaetime.entity.DeptEntity;
import com.javaetime.framework.BaseController;
import com.javaetime.framework.page.Pagination;
import com.javaetime.web.DeptInfo.param.DeptParam;
import com.javaetime.web.DeptInfo.service.DeptService;

@Controller
@RequestMapping("/DeptInfo")
public class DeptController extends BaseController{
	@Resource
	private DeptService deptService;
	/**
	 * 查询所有数据
	 * @param model
	 * @param request
	 * @param pagination
	 * @param deptEntity
	 * @return
	 */
	@RequestMapping("queryForPageList")
	public String queryForPageList(Model model,ServletRequest request, Pagination pagination,DeptParam param){
		
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());
		model.addAttribute("items",deptService.queryForPageList(param, pageBounds));
		model.addAttribute("item",param);
		System.out.println("进入DeptController的queryForPageList()方法");
		return "DeptInfo/list";
	}
	
	/**
	 * 前往添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping("add")
	public String toadd(Model model){
		System.out.println("进入DeptController的toadd()方法");
		return "DeptInfo/add";
	}
	/**
	 * 添加数据
	 * @param model
	 * @param request
	 * @param deptEntity
	 * @return
	 */
	@RequestMapping("addSave")
	public String addsave(Model model,RedirectAttributes redirectAttributes,DeptEntity deptEntity){
		System.out.println("进入DeptController的addSave()方法");
		boolean addType = deptService.addSave(deptEntity);
		if(addType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DEFAULT_MESSAGE);
		}else{
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "该预约客户已经存在!");
		}
		return "redirect:/DeptInfo/queryForPageList";
	}
	/**
	 * 删除数据
	 * @param model
	 * @param request
	 * @param deptId
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(Model model,RedirectAttributes redirectAttributes,int deptId){
		System.out.println("进入DeptController的delete()方法");
		boolean deleteType = deptService.delete(deptId);
		if(deleteType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DELETE_MESSAGE);
		}else{
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "删除失败!");
		}
	    return "redirect:/DeptInfo/queryForPageList";
	}
	/**
	 * 查看数据详情
	 * @param model
	 * @param request
	 * @param deptId
	 * @return
	 */
	@RequestMapping("detail")
	public String detail(Model model,ServletRequest request,Integer deptId){
	    DeptEntity items = deptService.queryById(deptId);
		System.out.println("进入DeptController的detail()方法");
		model.addAttribute("item",items);
		return "DeptInfo/detail";
	}
	/**
	 * 修改数据
	 * @param model
	 * @param request
	 * @param deptId
	 * @return
	 */
	@RequestMapping("toedit")
	public String toedit(Model model,ServletRequest request,Integer deptId){
		DeptEntity items = deptService.queryById(deptId);
		System.out.println("进入DeptController的toedit()方法");
		model.addAttribute("item",items);
		return "DeptInfo/edit";
	}
	
	@RequestMapping("edit")
	public String edit(Model model,RedirectAttributes redirectAttributes,DeptEntity deptEntity){
		System.out.println("进入DeptController的edit()方法");
		boolean editType = deptService.edit(deptEntity);
		if(editType){
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, REDIRECT_DEFAULT_MESSAGE);
		}else{
			redirectAttributes.addFlashAttribute(REDIRECT_MESSAGE_KEY, "该预约客户已经存在!");
		}
		return "redirect:/DeptInfo/queryForPageList";
	}
	@RequestMapping("queryByName")
	public String queryByName(Model model,Pagination pagination,DeptParam param){
		System.out.println("进入DeptController的queryByName方法");
		PageBounds pageBounds = new PageBounds(pagination.getPageIndex(), pagination.getPageSize());

		List<DeptEntity> items = deptService.queryForPageList(param, pageBounds);
		
		model.addAttribute(DEFAULT_ITEMS,items);
		model.addAttribute(DEFAULT_PARAM, param);
		return "staff/select";

	}
	
	@RequestMapping("daoChu")
	public void daoChu(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		    System.out.println("daoChu()");
		    List<Map<String,Object>> list = deptService.queryAllInfo();
		    String fileName="部门信息表.xls";
		    Excel ex=new Excel();
		    String sheetName=ex.huoQuMingZi(request,response,fileName);
		    HSSFWorkbook wb=new HSSFWorkbook();
		    HSSFSheet sheet=wb.createSheet(sheetName);
		    Row row=sheet.createRow(0);
		    String[] biaoTou={"主键","部门名称","备注","创建时间"};
		    String[] lieMing={"DEPT_ID","DEPT_NAME","REMARK","CREATE_TIME"};
		    for (int i = 0; i < biaoTou.length; i++) {
				row.createCell(i).setCellValue(biaoTou[i]);
			}
		    for (int i = 0; i < list.size(); i++) {
				Row row2=sheet.createRow(i+1);
				Map<String, Object> map = list.get(i);
				for (int j = 0; j < lieMing.length; j++) {
					Object object = map.get(lieMing[j]);
					if(object!=null){
						row2.createCell(j).setCellValue(object+"");
					}else{
						row2.createCell(j).setCellValue("");
					}
				}
			}
		    OutputStream out=response.getOutputStream();
		    wb.write(out);
		    out.close();
	}
	
}
