package com.java��ϰ;

import java.text.MessageFormat;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.google.protobuf.Message;

public class �ַ������� {
	
	static String name = "hanmeimei";
	
	public static void main(String args[]){
		
		String  str = "hello,my name is %s";
		System.out.println(String.format(str,�ַ�������.name));
	}
}
