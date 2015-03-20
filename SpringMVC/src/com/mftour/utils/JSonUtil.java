package com.mftour.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;


/**
 * JSonUtil
 *
 * @author jinliang
 */
public class JSonUtil {
    private static Logger logger = Logger.getLogger(JSonUtil.class);

    private static ObjectMapper serializer = new ObjectMapper();
    
    private static ObjectMappingCustomer customer = new ObjectMappingCustomer();


    public static String writeCustomerObject(Object ob)
    {
    	try {
            return customer.writeValueAsString(ob);
        } catch (Exception e) {
        	e.printStackTrace();
            return "";
        }
    }
    
    /**
     * 将一个对象序列化为JSon字符串
     *
     * @param ob
     * @return
     * @throws Exception
     */
    public static  String writeObject(Object ob) {
        try {
            return serializer.writeValueAsString(ob);
        } catch (Exception e) {
            return "";
        }
    }

    public static <T> T readObject(String json, Class<T> cls) {
        try {
            return serializer.readValue(json, cls);
        } catch (Exception e) {
            logger.error("Parse Json error", e);
            return null;
        }
    }

    /**
     * 将一个数组对象序列化为json字符串
     *
     * @param ob
     * @return
     * @throws Exception
     */
    public static String writeObjects(Object... ob) throws Exception {
        return serializer.writeValueAsString(ob);
    }

    public static String getFieldInJsonString(String jsonString, String fieldName) {
        try {
            JsonNode field = string2Json(jsonString).get(fieldName);
            return field.getValueAsText();
        } catch (Exception e) {
            return null;
        }

    }

    public static JsonNode string2Json(String jsonString) {

        try {
            return serializer.readTree(jsonString);
        } catch (Exception e) {
            return null;
        }
    }

    private static class CLS {
        public Long a;
        public Integer b;
    }
    
    public static List<Map> jsonToList(String json)
    {
    	 JSONArray jsonarray = JSONArray.fromObject(json);  
        List<Map> list = (List)JSONArray.toCollection(jsonarray,Map.class);  

    	return list;
    }
    
    
    /**   
     * 从一个JSON数组得到一个java对象集合   
     * @param object   
     * @param clazz   
     * @return   
     */    
    public static List getDTOList(String jsonString, Class clazz){     
     //   setDataFormat2JAVA();     
        JSONArray array = JSONArray.fromObject(jsonString);     
        List list = new ArrayList();     
        for(Iterator iter = array.iterator(); iter.hasNext();){     
            JSONObject jsonObject = (JSONObject)iter.next();     
            list.add(JSONObject.toBean(jsonObject, clazz));     
        }     
        return list;     
    } 
    
    public static void main(String[] args) throws Exception {
    	Map<String, Object> map = readObject("{\"valid_ends\":\"2014-08-16 23:59:59\",\"valid_start\":\"2014-08-14 00:00:00\"}", Map.class);
    	System.out.println(map.get("valid_ends"));
    }

}
