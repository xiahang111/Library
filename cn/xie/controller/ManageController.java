package cn.xie.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.xie.pojo.Book;
import cn.xie.pojo.MessBook;
import cn.xie.service.ManageService;

@Controller
@RequestMapping("/act")
public class ManageController {
	
	@Autowired
	private ManageService manageService;
	
	@RequestMapping("/borrow")
	public String toBorrow(@CookieValue(value="userId",required=false)Integer idCookie,@RequestParam(value="bookId") Integer bookId){
		
		Integer userId = idCookie;
		
		int i = manageService.toBorrow(userId, bookId);
		
		if(i == 1){
			return "pages/sysadmin/borSuccess";
		}else{
			return "pages/sysadmin/borFail";
		}
	}
	
	@RequestMapping("jBorrowlist")
	public String toBorrowlist(Model model){
		Integer userId = null;
		
		List<Book> bookList = new ArrayList<Book>();
		bookList = manageService.toBorrowlist(userId);
		
		List<MessBook> messList = new ArrayList<MessBook>();
		messList = manageService.toMessList(userId);
		
		model.addAttribute("bookList", bookList);
		//model.addAttribute("messList", messList);
		
		
		return "pages/sysadmin/jBorrowList";
	}

}	
	

