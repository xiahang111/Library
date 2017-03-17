package cn.xie.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xie.mapper.BookMapper;
import cn.xie.mapper.ManageMapper;
import cn.xie.pojo.Book;
import cn.xie.pojo.MessBook;

@Service
public class ManageService {
	
	@Autowired
	private ManageMapper manageMapper;
	
	@Autowired
	private BookMapper bookMapper;
	
	public int toBorrow(Integer userId,Integer bookId){
		
		bookMapper.updateById(bookId);
		
		MessBook messBook = new MessBook(); 
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		String borrowTime = sdf.format(d).toString();
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE,60);
		
		String returnTime = sdf.format(c.getTime());
		
		messBook.setBookId(bookId);
		messBook.setUserId(userId);
		messBook.setBorrowTime(borrowTime);
		messBook.setReturnTime(returnTime);
		
		try {
			manageMapper.insertSelective(messBook);
		} catch (Exception e) {
			return 0;
		}
		
		return 1;
		
	}
	
	public List<Book> toBorrowlist(Integer userId){
		Integer[] bookIds = manageMapper.selectBookId(userId);
		
		List<Book> bookList = new ArrayList<Book>();
		
		Book book = null;
		
		for (Integer bookId : bookIds) {
			book = bookMapper.selectByPrimaryKey(bookId);
			bookList.add(book);
		}
		
		return bookList;
		
	}
	
	public List<MessBook> toMessList(Integer userId){
		
		List<MessBook> messList = new ArrayList<MessBook>();
		messList =  manageMapper.queryAll(userId);
		
		return messList;
	}


}
