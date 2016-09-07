package com.javaetime.web.index;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/index")
public class IndexController {

	@RequestMapping("menu")
	public String menu(Model model,ServletRequest request) {

		return "index/menu";
	}
}
