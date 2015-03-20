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
public class ResolveDomainProperty {
	static Logger logger = Logger.getLogger(ResolveDomainProperty.class);
	public static String DOMAIN_NAME;
	
	static{
		try {
			Properties p = new Properties();
			InputStream is = ResolveDomainProperty.class.getClassLoader().getResourceAsStream("domain-name-config.properties");
			p.load(is);
			DOMAIN_NAME = p.getProperty("web.domain.name","http://www.piaozhijia.cn");
			logger.info("------------------------DOMAIN_NAME=" + DOMAIN_NAME);
			System.out.println("------------------------DOMAIN_NAME=" + DOMAIN_NAME);
			is.close();
			p.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(ResolveDomainProperty.DOMAIN_NAME);
		
	}
}
