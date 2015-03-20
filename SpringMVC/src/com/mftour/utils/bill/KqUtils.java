package com.mftour.utils.bill;

import com.mftour.utils.CheckUtils;

public class KqUtils {
	public static String signMsgVal(String num, String orderID,String orderTime,String notify ) {
		return signMsgVal(num, orderID, orderTime, notify, "00", "","");
	}
	public static String signMsgVal(String num, String orderID,String orderTime,String notify,String ext1) {
		return signMsgVal(num, orderID, orderTime, notify, "00", "", ext1);
	}
	public static String signMsgVal(String num, String orderID,
			String orderTime, String notify, String payType, String bankId,String ext1) {
		String signMsgVal = "";
		String signMsg="";
		try{
			signMsgVal = appendParam(signMsgVal, "inputCharset", PayProperty.CACHE.get("inputcharset"));
			signMsgVal = appendParam(signMsgVal, "bgUrl", PayProperty.CACHE.get("url")+notify);
			signMsgVal = appendParam(signMsgVal, "version", PayProperty.CACHE.get("version"));
			signMsgVal = appendParam(signMsgVal, "language", PayProperty.CACHE.get("language"));
			signMsgVal = appendParam(signMsgVal, "signType", PayProperty.CACHE.get("signtype"));
			signMsgVal = appendParam(signMsgVal, "merchantAcctId",PayProperty.CACHE.get("merchantacctid"));
			signMsgVal = appendParam(signMsgVal, "orderId",orderID);
			signMsgVal = appendParam(signMsgVal, "orderAmount", num);
			signMsgVal = appendParam(signMsgVal, "orderTime", orderTime.trim() );
			signMsgVal = appendParam(signMsgVal, "productName", PayProperty.CACHE.get("productname"));
			signMsgVal = appendParam(signMsgVal, "productId", PayProperty.CACHE.get("productid"));
			signMsgVal = appendParam(signMsgVal, "productDesc", PayProperty.CACHE.get("productdesc"));
			signMsgVal = appendParam(signMsgVal, "ext1", ext1);
			signMsgVal = appendParam(signMsgVal, "payType", payType);
			signMsgVal = appendParam(signMsgVal, "bankId", bankId);
			signMsgVal = appendParam(signMsgVal, "redoFlag", PayProperty.CACHE.get("redoflag"));
			signMsgVal = appendParam(signMsgVal, "pid", PayProperty.CACHE.get("pid"));
			signMsgVal = appendParam(signMsgVal, "key",PayProperty.CACHE.get("key"));
			signMsg = MD5Util.md5Hex(signMsgVal.getBytes("UTF-8")).toUpperCase();
		}catch(Exception e){
			e.printStackTrace();
		}
		return signMsg;
	}
	
	public static String appendParam(String returns, String paramId, String paramValue) {
		if (returns != "") {
			if (CheckUtils.isNotNull(paramValue)) {
				returns += "&" + paramId + "=" + paramValue;
			}
		} else {

			if (CheckUtils.isNotNull(paramValue)) {
				returns = paramId + "=" + paramValue;
			}
		}
		return returns;
	}
	/**
	 * 退款获得加密密钥
	 * @param returns
	 * @param paramId
	 * @param paramValue
	 * @return
	 */
	public static String refundAppendParam(String returns, String paramId, String paramValue) {
		if (returns != "") {
			if (paramValue != "") {
				returns +=  paramId + "=" + paramValue;
			}
		} else {
			if (paramValue != "") {
				returns = paramId + "=" + paramValue;
			}
		}
		return returns;
	}
	
}
