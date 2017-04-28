package com.xml�ĵ���д.demo;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {

	public static void main(String[] args) {
        SAXParser parser = null;
        try {
            //����SAXParser
            parser = SAXParserFactory.newInstance().newSAXParser();
            //ʵ����  DefaultHandler����
            SaxParseXml parseXml=new SaxParseXml();
            
            InputStream stream = new FileInputStream("demo.xml");
            //����parse()����
            parser.parse(stream, parseXml);
            //�������
            List<Student> list = parseXml.getList();
            for(Student student:list){
                System.out.println("id:"+student.getId()+"\tgroup:"+student.getGroup()+"\tname:"+student.getName()+"\tsex:"+student.getSex()+"\tage:"+student.getAge()+"\temail:"+student.getEmail()+"\tbirthday:"+student.getBirthday()+"\tmemo:"+student.getMemo());
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
