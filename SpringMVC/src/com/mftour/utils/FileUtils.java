package com.mftour.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileUtils {
	/* 读取数据 */
	public static String ReadFile(String file) {
		try {
			FileInputStream fr = new FileInputStream(file);
			BufferedReader brd = new BufferedReader(new InputStreamReader(fr, "UTF-8"));
			// ****字节流可以把编码进行设置。。问题解决
			String returnStr = "";
			while (brd.readLine() != null) {
				String fileline = brd.readLine().replaceAll("\\t", "");
				returnStr += fileline;
			}
			brd.close();
			fr.close();
			return returnStr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
