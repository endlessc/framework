package com.mftour.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ShortenUrl {

	// 新浪短网址api地址
	public static final String SINA_SHORTEN_URL = "https://api.weibo.com/2/short_url/shorten.json?url_long=";

	/*
	 * method:新浪API把长网址转为短网址 param：输入长网址-String(例：http://www.baidu.com)
	 * return：短网址-String author:孙照利 time:2014-04-17
	 */
	public String getShortenUrl(String url) {
		URL geturl;
		String urlshort = null;
		try {
			// 拼接字符串url+应用授权ID
			String getURL = SINA_SHORTEN_URL + url + "/&source=1681459862";
			// 把拼接的字符串转为url地址
			geturl = new URL(getURL);
			// 打开httpurl连接
			HttpURLConnection connection = (HttpURLConnection) geturl
					.openConnection();
			connection.setRequestMethod("GET");
			// 建立与服务器的连接并发送数据
			connection.connect();
			// 读取数据
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String lines;
			while ((lines = reader.readLine()) != null) {
				System.out.println(lines);
				// 截取短url
				String[] arrays = lines.split("url_short");
				if (arrays.length >= 2) {
					urlshort = arrays[1].split(",")[0];
					urlshort = urlshort.substring(3, urlshort.length() - 1);
				}
				// ////////////////
			}
			// 关闭读取流
			reader.close();
			// 断开连接
			connection.disconnect();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return urlshort;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortenUrl ssu = new ShortenUrl();
		String url = ssu.getShortenUrl("http://192.168.1.137:8080/biz/queryordertwodimensionalcode/2214446483112546");
		System.out.println(url);

	}

}
