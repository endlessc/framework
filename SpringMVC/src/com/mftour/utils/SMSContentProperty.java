package com.mftour.utils;

import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;


/**
 * 解析property文件得到web域名
 * 
 * @author chenweiqiang
 * 
 */
public class SMSContentProperty {
	static Logger logger = Logger.getLogger(SMSContentProperty.class);
	private static SMSContentProperty instance = new SMSContentProperty();
	public static Properties prop = new Properties();  
	public static String SMSContent;
	public static String fhSMSContent;
	public static String ios_down_url;
	public static String android_down_url;
	public static String ios_SMS_Template;
	public static String android_SMS_Template;
	public static SMSContentProperty getInstance() {
		return instance;
	}
    static{  
        try {  
//            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("SMS-template-content.properties"));  
//              
//            //转码处理  
//            Set<Object> keyset = prop.keySet();  
//            Iterator<Object> iter = keyset.iterator();  
//            while (iter.hasNext()) {  
//                String key = (String) iter.next();  
//                String newValue = null;  
//                try {  
//                    //属性配置文件自身的编码  
//                    String propertiesFileEncode = "utf-8";  
//                    newValue = new String(prop.getProperty(key).getBytes("ISO-8859-1"),propertiesFileEncode);  
//                    if(key.equalsIgnoreCase("send.SMS.template.content"))
//                    	SMSContent = newValue;
//                } catch (UnsupportedEncodingException e) {  
//                    newValue = prop.getProperty(key);  
//                }  
//                prop.setProperty(key, newValue);  
//            }
        	Properties p = new Properties();
			InputStream is = ResolveDomainProperty.class.getClassLoader().getResourceAsStream("SMS-template-content.properties");
			p.load(is);
			SMSContent = new String(p.getProperty("send.SMS.template.content","亲爱的用户，您购买了%supplierName%的%productName%，请于%startTime%前往，有效期为%startTime%至%expTime%，发送时间%sendDate%，详情请参见%ticketUrl% 【票之家】").getBytes("ISO-8859-1"),"utf-8");
			fhSMSContent = new String(p.getProperty("send.SMS.fh.content","【票之家】亲爱的用户，您购买了%supplierName%的门票，一共%ticketNum%张,共%ticketAmount%元,有效期为%startTime%至%expTime%，发送时间%sendDate%").getBytes("ISO-8859-1"),"utf-8");
			ios_down_url = new String(p.getProperty("ios_down_url").getBytes("ISO-8859-1"),"utf-8");
			android_down_url = new String(p.getProperty("android_down_url").getBytes("ISO-8859-1"),"utf-8");
			ios_SMS_Template = new String(p.getProperty("ios_SMS_Template").getBytes("ISO-8859-1"),"utf-8");
			android_SMS_Template = new String(p.getProperty("android_SMS_Template").getBytes("ISO-8859-1"),"utf-8");
			logger.info("------------------------SMSContent=" + SMSContent);
			is.close();
			p.clone();
        } catch (Exception e) {  
        	logger.error("读取配置文件conf.properties出错！", e);  
        }  
    } 
	
	public static void main(String[] args) {
//		System.out.println(SMSContentProperty.SMSContent.replace("$ticketUrl", "123"));
		System.out.println(SMSContentProperty.ios_SMS_Template);
	}
}
