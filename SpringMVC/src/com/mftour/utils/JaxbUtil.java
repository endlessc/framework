package com.mftour.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Jaxb2工具类
 * @author		zhuc
 * @create		2013-3-29 下午2:40:14
 */
public class JaxbUtil {

	/**
	 * JavaBean转换成xml
	 * 默认编码UTF-8
	 * @param obj
	 * @param writer
	 * @return 
	 * @throws JAXBException 
	 */
	public static String convertToXml(Object obj) throws JAXBException {
		return convertToXml(obj, "UTF-8");
	}

	/**
	 * JavaBean转换成xml
	 * @param obj
	 * @param encoding 
	 * @return 
	 * @throws JAXBException 
	 */
	public static String convertToXml(Object obj, String encoding) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

		StringWriter writer = new StringWriter();
		marshaller.marshal(obj, writer);
		String result = writer.toString();


		return result;
	}

	/**
	 * xml转换成JavaBean
	 * @param xml
	 * @param c
	 * @return
	 * @throws JAXBException 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T converyToJavaBean(String xml, Class<T> c) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(c);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		T t = (T) unmarshaller.unmarshal(new StringReader(xml));
		
		return t;
	}
}