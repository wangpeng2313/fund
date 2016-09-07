package com.javaetime.web.DeptInfo.ctrl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class Excel {
	public String huoQuMingZi(HttpServletRequest request,
			HttpServletResponse response, String fileName) throws UnsupportedEncodingException {
		Excel ex=new Excel();
		fileName=ex.encodeFileName(request,response,fileName);
		response.setHeader("Content-Disposition", "attachment;fileName="+fileName);
		String sheetName="部门信息表";
		return sheetName;
	}

	private String encodeFileName(HttpServletRequest request,
			HttpServletResponse response, String fileName) throws UnsupportedEncodingException {
		response.setHeader("Connection", "close");
		response.setHeader("Content-Type", "application/vnd.ms-excel;charset=UTF-8");
		String agent=request.getHeader("USER-AGENT");
		if(null!=agent&&-1!=agent.indexOf("MSIE")){
			return URLEncoder.encode(fileName,"UTF-8");
		}else if(null!=agent&&-1!=agent.indexOf("Mozilla")){
			return "=?UTF-8?B?"+(new String(Base64.encode(fileName.getBytes("UTF-8"))))+"?=";
			
			
		}else{
			return fileName;
		}
	
	}

}
