package com.实用demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 
 * @author hongliang.dinghl Dom4j 生成XML文档与解析XML文档
 */
public class Dom4jXML读取Demo{
	
	/***
	 * 创建一个xml文件
	 * @param fileName
	 */
	@SuppressWarnings("deprecation")
	public static void createXml(String fileName) {
		
		Document document = DocumentHelper.createDocument();
		
		Element employees = document.addElement("employees"); // 新建一个开始节点
		Element employee = employees.addElement("employee"); // 在employees节点下新增一个employee节点

		Element name = employee.addElement("name"); // 在employee节点下新增一个name节点
		name.setText("ddvip");
		name.setAttributeValue("name", "name");
		
		Element sex = employee.addElement("sex");
		sex.setText("m");
		
		Element age = employee.addElement("age");
		age.setText("29");
		
		Element addr = DocumentHelper.createElement("addr");
		addr.setText("adsfasdfasdf");
		Element root = document.getRootElement();
		root.element("employee").element("name").add(addr);
		
		try {
			Writer fileWriter = new FileWriter(fileName);
			XMLWriter xmlWriter = new XMLWriter(fileWriter);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/***
	 * 解析xml文件，获取节点文本
	 * @param fileName
	 */
	public static void parserXml(String fileName) {
		File inputXml = new File(fileName);
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(inputXml);
			Element employees = document.getRootElement(); // 获取根节点
			for (Iterator i = employees.elementIterator(); i.hasNext();) { // 遍历其下的所有的子节点
				Element employee = (Element) i.next();
				for (Iterator j = employee.elementIterator(); j.hasNext();) {
					Element node = (Element) j.next();
					System.out.println(node.getName() + ":" + node.getText());
				}
			}
		} catch (DocumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("dom4j parserXml");
	}
	
	/**
	 * 解析xml文件，获取节点属性值
	 * path-xml文件的路径 
	 * ParametersName-节点名称
	 * */
	public static String getTestngParametersValue(String path,String ParametersName) throws DocumentException, IOException {
		File file = new File(path);
		if (!file.exists()) {
			throw new IOException("Can't find " + path);
		}
		String value = null;
		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		Element root = document.getRootElement();
		for (Iterator<?> i = root.elementIterator(); i.hasNext();) {
			Element page = (Element) i.next();
			if (page.attributeCount() > 0) {
				if (page.attribute(0).getValue().equalsIgnoreCase(ParametersName)) {
					value = page.attribute(1).getValue();
					// System.out.println(page.attribute(1).getValue());
				}
				continue;
			}
		}
		return value;
	}
	
	public static void main(String args[]){
		createXml("test.xml");
		parserXml("test.xml");
	}
}