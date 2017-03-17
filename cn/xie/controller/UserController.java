package cn.xie.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.xie.pojo.User;
import cn.xie.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
   


	@Autowired
	private UserService userService;

	@RequestMapping("/regist")
	public String toRegist(User user){
		
		Integer id = (int) (System.currentTimeMillis()%10000000);
		
		user.setUserId(id);
		
		user.setLevel(1);
		
		userService.save(user);
		
		return "toLogin";
	}
	
	@RequestMapping("/userlogin")
	public String userLogin(@RequestParam("username") String username,@RequestParam("password") String password,
			HttpServletResponse response){
		
		Integer userId;
		
		int status = userService.doLogin(username, password);
		
		userId = userService.selectUserId(username);
		
		Cookie cookie = new Cookie("userId", userId.toString());
		cookie.setMaxAge(60*30);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		
		if(status == 1){
			return "pages/home/fmain";
		}else{
			return "failLogin";
		}
		
		
	}
	
	@RequestMapping("/adminLogin")
	public String adminLogin(@RequestParam("username") String username,@RequestParam("password") String password){
		
		int status = userService.adminLogin(username, password);
		if(status == 1){
			return "redirect:/page/index";
		}else{
			return "redirect:/";
		}
		
	}
	
	@RequestMapping("/query")
	public String queryUserAll(Model model){
		
		List <User> userList = userService.queryAll();
		model.addAttribute("userList", userList);
		
		return "user-list";
	}


}
