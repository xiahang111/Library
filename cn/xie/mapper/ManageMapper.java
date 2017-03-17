package cn.xie.mapper;

import java.util.List;

import cn.xie.pojo.MessBook;

public interface ManageMapper  extends SysMapper<MessBook>{
	
	public Integer[] selectBookId(Integer userId);
	
	public List<MessBook> queryAll(Integer userId);
 }
