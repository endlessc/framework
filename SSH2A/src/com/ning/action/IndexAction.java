package com.ning.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author liangning
 *
 */
@Scope("prototype")  //支持多例
@ParentPackage("struts-default")
@Namespace(value="/")
public class IndexAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Action(value="index",results={@Result(name="success",location="/index.jsp",type="redirect")})
	public String index(){
		System.out.println("*********************index page*******************");
		return	SUCCESS;
	}
	
	public String index_index(){
		
		System.out.println("宋丹是二货");
		return SUCCESS;
	}
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
}
