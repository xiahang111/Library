package cn.xie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

	@RequestMapping("/{pageName}")
	public String toPage(@PathVariable("pageName") String pageName){
		
		return pageName;
		
	}
	
	@RequestMapping("/front/{pageName}")
	public String toFrontPage(@PathVariable("pageName") String pageName){
		
		return "/pages/"+pageName;
	}
	

	@RequestMapping("/front/{fileName}/{pageName}")
	public String toFront(@PathVariable("pageName") String pageName,@PathVariable("fileName") String fileName){
		
		return "/pages/"+fileName+"/"+pageName;
	}
	
	

}
