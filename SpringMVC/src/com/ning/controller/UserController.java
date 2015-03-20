package com.ning.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ning.model.User;
import com.ning.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@RequestMapping("/pre/login")
	public String preLogin(
			HttpServletRequest request, Model model){
		System.out.println("**********user pre login***************");
		
	
		return "login";
	}
	
	/**
	 * 登陆
	 * @param name
	 * @param password
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String login(
			@RequestParam(value="name", required=false)String name,
			@RequestParam(value="password", required=false)String password,
			HttpServletRequest request, Model model){
		System.out.println("**********user login***************");
		
	
		return "login-success";
	}
	
	@RequestMapping("/springajax")
	@ResponseBody
	public JSONObject json(){
		JSONObject json = new JSONObject();
		json.put("name", "liangning");
		return json;
	}
	
	
	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		json.put("name", "liangning");
		
		System.out.println(json.toString());
	}
	
	/**
	 * 注册
	 * @param name
	 * @param password
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/register")
	public String register(
			@RequestParam(value="name", required=false)String name,
			@RequestParam(value="password", required=false)String password,
			HttpServletRequest request, Model model
			){
			System.out.println("**********user register***************");
			
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			
			try {
				this.userService.saveUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "register-success";
	}
	
	/**
	 * 遍历
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/query")
	public String queryUser(
			HttpServletRequest request, Model model
			){
			System.out.println("**********user query***************");
			
			List<User> users = userService.findUser();
			if(users!=null){
				for(User u : users){
					System.out.println(u.getName());
				}
			}
			
			model.addAttribute("users", users);
			return "register-success";
	}
	
}
