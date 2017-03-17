package cn.xie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xie.mapper.UserMapper;
import cn.xie.pojo.User;

@Service
public class UserService extends BaseService<User>{
	
	@Autowired
	private UserMapper userMapper;
	
	public Integer selectUserId(String username){
		
		return userMapper.selectIdByUsername(username);
	}
	
	public int doLogin(String username,String password){
		
		Integer id =  userMapper.selectIdByUsername(username);
		
		User user2 = userMapper.selectByPrimaryKey(id);
		
		String password2 = user2.getPassword();
		
		if(password.equals(password2)){
			return 1;
		}else{
			return 0;
		}
		
	}
	
	public int adminLogin(String username,String password){
		
		Integer userId = userMapper.selectIdByUsername(username);
		
		User user = userMapper.selectByPrimaryKey(userId);
		
		String password2 = user.getPassword();
		
		if(password.equals(password2)&&user.getLevel() == 2){
			return 1;
		}else{
			return 0;
		}
	}

}
