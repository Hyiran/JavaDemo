package com.jodd�ӿ�����.demo;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

public class �ӿڲ��� {
	
	static HttpRequest httpRequest;
	
	public String get(String url){
		
		return httpRequest.get(url).send().bodyText();
		
	}
	
	public  String post(String url) {
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpResponse  res = httpRequest.send();
		System.out.println(res.bodyText());
	}

}
