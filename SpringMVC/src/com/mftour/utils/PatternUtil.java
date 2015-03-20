package com.mftour.utils;

import java.util.regex.Pattern;
/**
 * 
 * @author zhangyl
 *
 */
public class PatternUtil {

	/*
	  * 判断是否为整数 
	  * @param str 传入的字符串 
	  * @return 是整数返回true,否则返回false 
	*/
	 public static boolean isInteger(String str) {  
		 Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
		 return pattern.matcher(str).matches();  
	 }
	 /**
	  * 判断手机号
	  * @param mobiles
	  * @return
	  */
	 public static boolean isMobileNO(String mobiles){  
		 Pattern pattern=Pattern.compile("^1\\d{10}$");  
		 return pattern.matcher(mobiles).matches();
	 
	 }  


	 public static void main(String[] args)
	 {
		 System.out.println(PatternUtil.isMobileNO("18080792980"));
	 }
	 

}
