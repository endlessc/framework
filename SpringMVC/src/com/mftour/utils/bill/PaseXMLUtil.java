package com.mftour.utils.bill;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class PaseXMLUtil {
	// 具体解析XML方法
		public static String paseXML(String myurl) {
			myurl="https://www.99bill.com/gateway/getOrderTimestamp.htm";
			URL url = null;
			String temp = null;
			try {
				url = new URL(myurl);
				URLConnection uc = url.openConnection(); // 建立连接
				BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));

				while (true) {
					temp = br.readLine();
					if (temp.indexOf("timestamp") > -1) {
						break;
					}
				}
				temp = temp.substring(temp.indexOf("<timestamp>") + 11, temp.indexOf("</timestamp>"));
				br.close(); // 一定记得要关闭连接！（br因为是用内部类直接定义的，所以不需要一个个的关闭连接）
			} catch (Exception e) {
				e.printStackTrace();
			}

			return temp;
		}
}
