package com.ning.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author liangning
 *
 */
public class IndexAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
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
