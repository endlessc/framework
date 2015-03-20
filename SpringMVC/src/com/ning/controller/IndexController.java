package com.ning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(){
		System.out.println("********* index ****");
		
		return "index";
	}
	
	public static void main(String[] args) {
		Long a = 123L;
		Long b = 123L;
		 System.out.println(a.equals(b));
	}
}
