package com.jsoup解析HTML.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 利用JSOUP解析XML文件
 * Created by libingxian on 2017/4/12.
 */
public class JsoupXmlDemo {

    /**
     * 从指定文件中读取xml内容
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
     * 从指定的xml内容中读取对应的元素
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
