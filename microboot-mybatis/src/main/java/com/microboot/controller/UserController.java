package com.microboot.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microboot.bean.User;
import com.microboot.service.UserService;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年1月18日 下午2:19:12 
* 类说明 
*/
@Controller
public class UserController extends AbstractBaseController{
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/getAll")
	public String getAll(Model model){
		List<User> userList = userService.list();
		if(null != userList){
			model.addAttribute("userList",userList);
		}
		return "user/user_show";
	}
	
	@RequestMapping(value = "/addUser")
	public String addUser(Model model){
		return "user/user_add";
	}
	
	
	@RequestMapping(value = "/addUserDo")
	public String addUserDo(User user){
		boolean flag = false;
		if(null != user){
			flag = userService.addUser(user);
		}
		return flag ? "redirect:/getAll" : "ERROR";
	}

}
 