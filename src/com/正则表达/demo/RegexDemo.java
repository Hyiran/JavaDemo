package com.正则表达.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
	
	public static void test() {
		Pattern p = Pattern.compile(".");
		Matcher matcher = p.matcher("asdfasd123dasdf11");
		System.out.println(matcher.find());
		System.out.println(matcher.group());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

}
