package com.jsoup����HTML.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * ����JSOUP����XML�ļ�
 * Created by libingxian on 2017/4/12.
 */
public class JsoupXmlDemo {

    /**
     * ��ָ���ļ��ж�ȡxml����
     * @param xmlFilePath
     * @return
     * @throws Exception
     */
    public String getXmlStringFromFile(String xmlFilePath) throws Exception{
        StringBuilder stringBuilder = new StringBuilder();
        FileReader fileReader = new FileReader(xmlFilePath);
        BufferedReader bufferedReader= new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine())!= null){
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    /**
     * ��ָ����xml�����ж�ȡ��Ӧ��Ԫ��
     * @param xml
     */
    public void getXmlElementValue(String xml){
        Document document = Jsoup.parse(xml);
        Elements elements = document.select("recipe recipename");
        for (Element em:elements) {
            System.out.println(em.text());
        }

    }

    public static void main(String args[]) throws Exception{
        String xmlPath = "";
        JsoupXmlDemo jxd = new JsoupXmlDemo();

        jxd.getXmlElementValue(jxd.getXmlStringFromFile(System.getProperty("user.dir") + "\\jsoupxmldemo.xml"));
    }

}
