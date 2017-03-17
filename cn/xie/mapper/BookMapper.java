package cn.xie.mapper;

import java.util.List;

import cn.xie.pojo.Book;

public interface BookMapper extends SysMapper<Book>{

	public List<Book> queryList();
	
	public void updateById(Integer bookId);

}
