package com.集合操作.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 映射表哈希结构 {
	
	public static void main(String args[]){
		HashMap<String, String> map = new HashMap<>();
		map.put("a","a1");
		map.put("b", "b1");
		map.put("c", "c1");
		
		System.out.println(map.get("a"));
		System.out.println("aa");
		
		/***
		 * 一个映射表结构有三个视图
		 * 1、键集 -Set<k> keySet()
		 * 2、值集合（注意不是集）Collection<k> values() 
		 * 3、键/值对集  Set<Map.Entry<k,v>> entrySet()
		 */
		Set<String> set = map.keySet();
		for(String s:set){
			System.out.println(s);
		}
		
		Collection<String> values = map.values();
		for (String s:values){
			System.out.println(s);
		}
		
		Set<Map.Entry<String,String>> entrySet = map.entrySet();
		for (Map.Entry<String,String> entry : entrySet){
			System.out.println(entry.getKey()+entry.getValue());
		}
	}
	
}
