package cn.xie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.xie.mapper.BookMapper;
import cn.xie.pojo.Book;
import vo.EasyUIResult;

@Service
public class BookService extends BaseService<Book>{
	
	@Autowired
	private BookMapper bookMapper;

	public List<Book> queryList() {
		List<Book> bookList = new ArrayList<Book>();
		bookList = bookMapper.queryList();
		
		return bookList;
	}
	
}
