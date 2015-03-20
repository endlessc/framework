package com.mftour.utils.bill;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.mftour.utils.ResolveDomainProperty;

public class PayProperty {
	static Logger logger = Logger.getLogger(ResolveDomainProperty.class);
	private static String MERCHANT_ACCTID; //人民币账号
	private static String INPUTCHARSET;//固定选择值：1、2、3 1代表UTF-8; 2代表GBK; 3代表GB2312
	private static String VERSION;//网关版本固定值：v2.0
	private static String LANGUAGE;//网关页面显示诧言种类 1代表中文显示
	private static String SIGNTYPE;//签名类型 4代表DSA戒者RSA签名方式
	private static String PRODUCTNAME;//商品名称
	private static String PRODUCTID;//商品代码
	private static String PRODUCTDESC;//商品描述
	
	private static String GUIDE_REGISTER_COUPON;
	
	private static String REFUND_EXPIRED_TICKET;
	/**
	 * 支付方式
	 * 固定选择值：00、10、11、12、13、14、15、17、19、21、22 
	 * 00代表显示快钱各支付方式列表（默讣开通10、11、12、13四种支付方式）； 
	 * 10代表只显示银行卡支付方式； 
	 * 10-1 代表储蓄卡网银支付；
	 * 10-2 代表信用卡网银支付 
	 * 11代表只显示申话银行支付方式； 
	 * 11-1 代表储蓄卡申话支付；
	 * 11-2 代表信用卡申话支付 
	 * 12代表只显示快钱账户支付方式； 
	 * 13代表只显示线下支付方式； 
	 * 14代表显示企业网银支付； 
	 * 15信用卡无卡支付 
	 * 17预付卡支付; 
	 * 19手机诧音支付; 
	 * 19-1 代表储蓄卡手机诧音支付 ；
	 * 19-2 代表信用卡手机诧音支付 
	 * 21 快捷支付 
	 * 21-1 代表储蓄卡快捷；
	 * 21-2 代表信用卡快捷 *其中”-”只允许在半角状态下输入,无字符集限制. *企业网银支付、信用卡无卡支付/快捷支付、手机诧音支付、预付卡支付需单独甲请，默讣丌开通。
	 */
	private static String PAYTYPE;
	/**
	 * 同一订单禁止重复提交标志
	 * 固定选择值： 1、0 
	 * 1代表同一订单号只允许提交1次；
	 * 0表示同一订单号在没有支付成功的前提下可重复提交多次。
	 *  默讣为0 建议实物购物车结算类商户采用0；虚拟产品类商户采用1；
	 */
	private static String REDOFLAG;
	private static String PID;//合作伙伴在快钱的用户编号
    private static String KEY;//秘钥  
    private static String PCFEE;
    private static String MOBILEFEE;
    private static String URL;
    private static String ACTION;
    /**
     * /提交方式
     *  00: 代表前台提交
     *  01 ：代表后台提交 ：
     */
    private static String SUBMITTYPE;
    /**
     * pc端最低限额
     */
    private static String PCNILNORM;
    /**
     * 移动端最低限额
     */
    private static String MOBILENILNORM;
    
    /**
     * 查询方式   固定选择值：0、1  
     *0按商户订单号单笔查询（返回该订单信息）
     *1按交易结束时间批量查询（只返回成功订单）
     */
    private static String QUERYTYPE;
    /**
     * 查询模式   固定值：1  1代表简单查询（返回基本订单信息）
     */
    private static String QUERYMODE;
    /**
     * 充值显示方式 0:快钱 1：支付宝 2:两个都有
     */
    private static String SHOW;
    
    /**
     * 微信端使用的merchantAcctId
     */
    private static String WAPMERCHANTACCTID;
    
    /**
     * 微信端使用的key
     */
    private static String WAPKEY;
    private static String FLIGHTURL;
    public static Map<String, String> CACHE;
 
    static{
		try {
			Properties p = new Properties();
			InputStream is = PayProperty.class.getClassLoader().getResourceAsStream("pay-config.properties");
			p.load(is);
			MERCHANT_ACCTID=p.getProperty("merchantacctid").trim();
			INPUTCHARSET=p.getProperty("inputcharset").trim();
			VERSION=p.getProperty("version").trim();
			LANGUAGE=p.getProperty("language").trim();
			SIGNTYPE=p.getProperty("signtype").trim();
			PRODUCTNAME=new String(((String) p.getProperty("productname")).getBytes("ISO-8859-1"), "UTF-8").trim();
			PRODUCTID=p.getProperty("productid").trim();
			PRODUCTDESC=new String(((String) p.getProperty("productdesc")).getBytes("ISO-8859-1"), "UTF-8").trim();
			PAYTYPE=p.getProperty("paytype").trim();
			REDOFLAG=p.getProperty("redoflag").trim();
			PID=p.getProperty("pid").trim();
			KEY=p.getProperty("key").trim();
			SUBMITTYPE=p.getProperty("submitType").trim();
			PCFEE=p.getProperty("recharge.pc.value").trim();
			MOBILEFEE=p.getProperty("recharge.mobile.value").trim();
			URL=p.getProperty("url").trim();
			ACTION=p.getProperty("action".trim());
			PCNILNORM=p.getProperty("pcnilnorm").trim();
			MOBILENILNORM=p.getProperty("mobilenilnorm").trim();
			QUERYTYPE=p.getProperty("queryType").trim();
			QUERYMODE=p.getProperty("queryMode").trim();
			GUIDE_REGISTER_COUPON = p.getProperty("guide_register_coupon", "0.0").trim();
			REFUND_EXPIRED_TICKET = p.getProperty("refund_expired_ticket", "0").trim();
			SHOW=p.getProperty("show").trim();
			WAPMERCHANTACCTID=p.getProperty("wapmerchantacctid");
			WAPKEY=p.getProperty("wapkey");
			FLIGHTURL=p.getProperty("flighturl");
			
			//init cache
			CACHE = new HashMap<String, String>();
			CACHE.put("merchantacctid",MERCHANT_ACCTID);
			CACHE.put("inputcharset",INPUTCHARSET);
			CACHE.put("version",VERSION);
			CACHE.put("language",LANGUAGE);
			CACHE.put("signtype",SIGNTYPE);
			CACHE.put("productname",PRODUCTNAME);
			CACHE.put("productid",PRODUCTID);
			CACHE.put("productdesc",PRODUCTDESC);
			CACHE.put("paytype",PAYTYPE);
			CACHE.put("redoflag",REDOFLAG);
			CACHE.put("pid",PID);
			CACHE.put("key",KEY);
			CACHE.put("submitType",SUBMITTYPE);
			CACHE.put("pcfee",PCFEE);
			CACHE.put("mobilefee",MOBILEFEE);
			CACHE.put("url",URL);
			CACHE.put("action",ACTION);
			CACHE.put("pcnilnorm",PCNILNORM);
			CACHE.put("mobilenilnorm", MOBILENILNORM);
			CACHE.put("querytype", QUERYTYPE);
			CACHE.put("querymode", QUERYMODE);
			CACHE.put("guideRegisterCoupon", GUIDE_REGISTER_COUPON);
			CACHE.put("refundExpiredTicket", REFUND_EXPIRED_TICKET);
			CACHE.put("show",SHOW);
			CACHE.put("wapmerchantacctid",WAPMERCHANTACCTID);
			CACHE.put("wapkey",WAPKEY);
			CACHE.put("flighturl",FLIGHTURL);
			is.close();
			p.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
