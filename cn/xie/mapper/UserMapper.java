package cn.xie.mapper;

import cn.xie.pojo.User;

public interface UserMapper extends SysMapper<User>{

	public Integer selectIdByUsername(String username);
}
