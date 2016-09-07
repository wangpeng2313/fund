package com.javaetime.web.util.crtl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.javaetime.framework.BaseController;

/**
 * 系统共用控制层
 * 
 * @author 赵俊鹏
 * 
 */
@Controller
@RequestMapping("util")
public class UtilController extends BaseController {

	@RequestMapping("uploadPage")
	public String uploadPage(Model model, String type) {
		System.out.println("222222222222222222");
		return "frame/uploadPage";
	}

	@RequestMapping("upload")
	public String upload(Model model,@RequestParam("file") CommonsMultipartFile file, String type,HttpServletRequest request) throws IOException {
		//==处理成为新的文件名，以防上传文件时，重复
		System.out.println("11111111111111");
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String[] split = file.getFileItem().getName().split("\\.");
		String fileName = df.format(new Date()) + "." + split[split.length-1];
		
		String realPath = request.getRealPath("/") + "/static/upload/"+fileName;
		File destDir = new File(realPath);
		file.transferTo(destDir); 
		model.addAttribute("fileName", fileName);
		return "frame/uploadPage";
	}
	
	
}
