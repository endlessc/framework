package com.ning.action;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ning.model.User;
import com.ning.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author liangning
 *
 */
@Namespace("/")
@ParentPackage("json-default") 
@Component
public class UserAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//依赖
	@Autowired
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
	private Map<String,Object> dataMap;  
	private InputStream inputStream;
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	
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

	@Action(value="/user-login", results={@Result(name="login-success", location="/login-success.jsp", type="redirect")})
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
	@Action(value="/user-json", results={@Result(name="success", type="json", params={"root","result"})})
	public String userJSON(){
		
		System.out.println("userjson");
		JSONObject json = new JSONObject();
		
		json.put("name", "liangning");
		
		result = json.toString();
		
		return SUCCESS;
	}
	/**
	 * ajax json
	 * @return
	 */
	@Action(value="/user-json-object", results={@Result(name="success", type="json", params={"root","dataMap"})})
	public String userJSONObject(){
		
		System.out.println("userjson");
		dataMap = new HashMap<String, Object>();
		dataMap.put("name", "liangning");
		
		return SUCCESS;
	}
	@Action(value="/user-add", results={@Result(name="add-success", location="/index.jsp", type="redirect")})
	public String add(){
		
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
