package com.mftour.utils;

import java.lang.reflect.Field;
import java.net.URLEncoder;
import com.mftour.utils.MD5Utils;

public class SMSParam {
	private final int epid = 109625;
	private final String username = "mfgj";
	private final String password = MD5Utils.encrypt("mfgj321");
	private final String linkid = "";
	private final String subcode = "";

	private String message = "";
	private String phone = "";

	private String smsMsg = "";

	public SMSParam(String phone, String message) {
		this.phone = phone;
		this.message = message;
		generateSMSMsg();
	}

	private void generateSMSMsg() {
		Field[] fields = this.getClass().getDeclaredFields();
		StringBuilder sb = new StringBuilder();

		for (Field field : fields) {
			if (sb.length() > 0)
				sb.append("&");
			String value = null;
			try {
				value = String.valueOf(field.get(this));
				if ("message".equals(field.getName()))
					value = URLEncoder.encode(value, "GBK");
			} catch (Exception e) {
				e.printStackTrace();
				value = null;
			}

			if (value == null)
				continue;
			sb.append(field.getName()).append("=").append(value);
		}

		this.smsMsg = sb.toString();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		generateSMSMsg();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
		generateSMSMsg();
	}

	@Override
	public String toString() {
		return smsMsg;
	}

	public static void main(String[] args) {
		SMSParam param = new SMSParam("18600576560", "其实是测试");
		System.out.println(param.toString());
	}

}
