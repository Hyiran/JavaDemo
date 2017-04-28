package com.ʵ��demo;

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
 * @author hongliang.dinghl Dom4j ����XML�ĵ������XML�ĵ�
 */
public class Dom4jXML��ȡDemo{
	
	/***
	 * ����һ��xml�ļ�
	 * @param fileName
	 */
	@SuppressWarnings("deprecation")
	public static void createXml(String fileName) {
		
		Document document = DocumentHelper.createDocument();
		
		Element employees = document.addElement("employees"); // �½�һ����ʼ�ڵ�
		Element employee = employees.addElement("employee"); // ��employees�ڵ�������һ��employee�ڵ�

		Element name = employee.addElement("name"); // ��employee�ڵ�������һ��name�ڵ�
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
	 * ����xml�ļ�����ȡ�ڵ��ı�
	 * @param fileName
	 */
	public static void parserXml(String fileName) {
		File inputXml = new File(fileName);
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(inputXml);
			Element employees = document.getRootElement(); // ��ȡ���ڵ�
			for (Iterator i = employees.elementIterator(); i.hasNext();) { // �������µ����е��ӽڵ�
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
	 * ����xml�ļ�����ȡ�ڵ�����ֵ
	 * path-xml�ļ���·�� 
	 * ParametersName-�ڵ�����
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