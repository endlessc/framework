package com.ning.action;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.support.RequestContext;

import com.ning.model.User;
import com.ning.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author liangning
 *
 */
public class UserAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//依赖
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//传递参数
	private User user;
	private String beizhu;

	private String result;
	private InputStream inputStream;
	
	
	public String getResult() {
	    return result;
	}
	public void setResult(String result) {
	    this.result = result;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login(){
		System.out.println(this.hashCode());
		System.out.println(user.getName());
		
		System.out.println(beizhu);
		
		System.out.println("login success");
		
		return "login-success";
	}
	
	/**
	 * ajax 
	 * @return
	 */
	public String userAjax(){
		
	
		 return null;
	}
	
	/**
	 * ajax json
	 * @return
	 */
	public String userJSON(){
		
		System.out.println("userjson");
		JSONObject json = new JSONObject();
		
		json.put("name", "liangning");
		
		result = json.toString();
		
		return SUCCESS;
	}
	
	public String add(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		RequestContextHolder.getRequestAttributes();
	//	Responsec
		
		System.out.println(user.getName());
		
		try {
			this.userService.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "add-success";
	}
	
}
