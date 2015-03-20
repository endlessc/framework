package com.mftour.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.mftour.utils.bill.MD5Util;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

public class MD5Utils {

	
	public static String encrypt(String org)
	{
        MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
	        md.update(org.getBytes());//update处理  
	        byte [] encrypted = md.digest();//调用该方法完成计算 
	        return ByteUtils.Byte2Hex(encrypted);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return null;
	}
	/**
	 * MD5加密
	 * @param source
	 * @return
	 */
	public static String MD5(byte[] source) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
//            System.out.println("MD5(" + sourceStr + ",32) = " + result);
//            System.out.println("MD5(" + sourceStr + ",16) = " + buf.toString().substring(8, 24));
        } catch (NoSuchAlgorithmException e) {
        	e.printStackTrace();
            System.out.println(e);
        }
        return result.toUpperCase();
   }

	/**
	 * 解密
	 * @param key
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws Base64DecodingException
	 */
	public static String base64Decode(String key) throws UnsupportedEncodingException, Base64DecodingException{
		return new String(Base64.decode(key), "UTF-8");
	}
	/**
	 * 加密
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String base64Encode(String str) throws UnsupportedEncodingException{
		String a=Base64.encode(str.getBytes("UTF-8"));
		return a;
	}
	public static void main(String [] args) throws IOException{
////		String sign = "1F60114F25639260B480DEA324AB38F9";
//		String sign = "BDF535CC2076E2CBED21BF76EA13C68E";
//		String base = "6233313736666661346533303166346438666163393935303937663233373739636f6e73756d655f74797065306974656d5f7469746c65c6b1d6aebcd2b2e2cad4b2fac6b728d2c3bacdd4b0d1a7c9fac6b1296c6566745f6e756d316d6574686f64726573656e646d6f62696c6531383531313132393239306e756d316e756d5f69696434303333303036393734326f726465725f696437353030323131333534333239333173656c6c65725f6e69636bc6b1d6aebcd2bfc6bcbc73656e645f7479706532736b755f70726f70657274696573c3c5c6b1d6d6c0e03ab3c9c8cbc6b13bc3c5c6b1c0e0d0cd3ab5e7d7d3c6b1736d735f74656d706c617465d1e9d6a4c2eb24636f64652ec4fad2d1b3c9b9a6b6a9b9bac6b1d6aebcd2bfc6bcbccce1b9a9b5c4c6b1d6aebcd2b2e2cad4b2fac6b728d2c3bacdd4b0d1a7c9fac6b1292cd3d0d0a7c6da323031342f30372f3238d6c1323031342f30372f32382ccffbb7d1cab1c7ebb3f6cabeb1beb6ccd0c5d2d4d1e9d6a42ec8e7d3d0d2c9ceca2cc7ebc1aacfb5c2f4bcd22e7375625f6f757465725f6969643232313434373635343738383331363874616f62616f5f7369643231353531383932323774696d657374616d70323031342d30372d32382032313a33323a3331746f6b656e326130303166366534353839313630323130373866366231306135336462313576616c69645f656e6473323031342d30372d32382032333a35393a353976616c69645f7374617274323031342d30372d32382030303a30303a30307765656b735b312c322c332c342c352c362c375d";
//		System.out.println(base.length());
////		String md51 = encrypt(base);
//		String md52 = MD5(ByteUtils.Hex2Byte(base));
////		System.out.println(md51);
//		System.out.println(md52);
//		System.out.println(sign);
//		
//		System.out.println(Tools.getDateTime(Tools.getNewDateTime(2)));
//		String result = "merchantAcctId=1002349029001&version=v2.0&language=1&signType=1&payType=10&bankId=CMB&orderId=2214463662981955&orderTime=20140805111255&orderAmount=20000&dealId=1599698256&bankDealId=8678602704&dealTime=20140805111621&payAmount=20000&fee=60&payResult=10&key=X79NIBXS4F5D7IRG";
		String result = "merchantAcctId=1002349029001&version=v2.0&language=1&signType=1&payType=10&bankId=CMB&orderId=2214463662981957&orderTime=20140805124134&orderAmount=1000&dealId=1599830797&bankDealId=8678605828&dealTime=20140805124258&payAmount=1000&fee=3&payResult=10&key=X79NIBXS4F5D7IRG";
		String sign = MD5Util.md5Hex(result.getBytes("UTF-8"));
		System.out.println(sign);
		System.out.println(sign.equalsIgnoreCase("88098D1D796D7DE189FE43AE6F671D96"));
		
	}
}
