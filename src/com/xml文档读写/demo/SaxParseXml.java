package com.xml�ĵ���д.demo;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * ��������:����sax��ʽ����XML<br>
 * 
 * @author sxyx2008
 * 
 */
public class SaxParseXml extends DefaultHandler {

	// ��ű�������
	private List<Student> list;

	// ����Student����
	private Student student;

	// �������ÿ�α������Ԫ������(�ڵ�����)
	private String tagName;

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	// ֻ����һ�� ��ʼ��list����
	@Override
	public void startDocument() throws SAXException {
		list = new ArrayList<Student>();
	}

	// ���ö�� ��ʼ����
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (qName.equals("student")) {
			student = new Student();
			// ��ȡstudent�ڵ��ϵ�id����ֵ
			student.setId(Integer.parseInt(attributes.getValue(0)));
			// ��ȡstudent�ڵ��ϵ�group����ֵ
			student.setGroup(Integer.parseInt(attributes.getValue(1)));
		}
		this.tagName = qName;
	}

	// ���ö��
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equals("student")) {
			this.list.add(this.student);
		}
		this.tagName = null;
	}

	// ֻ����һ��
	@Override
	public void endDocument() throws SAXException {
	}

	// ���ö��
	@Override
	public void characters(char[] ch, int start, int length)throws SAXException {
		if (this.tagName != null) {
			String date = new String(ch, start, length);
			if (this.tagName.equals("name")) {
				this.student.setName(date);
			} else if (this.tagName.equals("sex")) {
				this.student.setSex(date);
			} else if (this.tagName.equals("age")) {
				this.student.setAge(Integer.parseInt(date));
			} else if (this.tagName.equals("email")) {
				this.student.setEmail(date);
			} else if (this.tagName.equals("birthday")) {
				this.student.setBirthday(date);
			} else if (this.tagName.equals("memo")) {
				this.student.setMemo(date);
			}
		}
	}
}