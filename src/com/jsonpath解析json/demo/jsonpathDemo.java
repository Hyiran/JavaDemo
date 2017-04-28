package com.jsonpath½âÎöjson.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

import net.minidev.json.JSONObject;

public class jsonpathDemo {

	private String jsonString;
	private JSONObject jsonObject;

	public void read(String filePath) {
		StringBuilder sb = new StringBuilder();
		try {
			FileReader fr = new FileReader(filePath);
			BufferedReader bfd = new BufferedReader(fr);
			String s = "";
			while ((s = bfd.readLine()) != null) {
				sb.append(s);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(sb);
		this.jsonString = sb.toString();
	}

	public void printList(List<?> li) {
		for (Iterator<?> a = li.iterator(); a.hasNext();) {
			System.out.println(a.next());
		}
	}

	public static void jsonPathTest(String jsonCont) {
		List<String> jsonStrings = jsonObject
	}

	public static void main(String[] args) {

	}

}
