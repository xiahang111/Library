package cn.xie.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xie.pojo.Book;
import cn.xie.service.BookService;
import vo.SysResult;

@Controller
@RequestMapping("/item")
public class BookController {
	
	private UserController userController;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public SysResult saveBook(Book book,@RequestParam("itemParams") String itemParams,@RequestParam("status") String status){
		
		if(status.contains("不")){
			book.setBookStatus(0);
		}else{
			book.setBookStatus(1);
		}
		
		Integer id;
		
		id = (int) (System.currentTimeMillis()-1000000000);
		
		book.setBookId(id);
		
		bookService.save(book);
		
		return SysResult.ok();
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public SysResult updateBook(Book book,@RequestParam("itemParams") String itemParams,@RequestParam("status") String status){
		
		if(status.contains("不")){
			book.setBookStatus(0);
		}else{
			book.setBookStatus(1);
		}
		
		Integer id = book.getBookId();
		
		bookService.update(book);
		
		return SysResult.ok();
	}
	
	@RequestMapping("/query")
	public String queryBook(Model model){
			
		List<Book> bookList = new ArrayList<Book>();
		bookList = bookService.queryList();
		model.addAttribute("bookList", bookList);
		
		return "item-list";
	}
	
	@RequestMapping("/jDeptlist")
	public String jDeptlist(Model model){
		
		List<Book> bookList = new ArrayList<Book>();
		bookList = bookService.queryList();
		model.addAttribute("bookList", bookList);
		
		return "pages/sysadmin/jBookList";
	}
	
	
	@RequestMapping("/delete")
	public String itemDelete(@RequestParam(value="bookId")Integer bookId){
		
		@SuppressWarnings("unused")
		Integer id = bookId;
		try{
			
			bookService.deleteById(bookId);
		
			return "redirect:page/index";
		}catch(Exception e){
			return "failDelete";
		}
	}
	
	

	
}
