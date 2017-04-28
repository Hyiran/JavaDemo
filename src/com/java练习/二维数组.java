package com.java练习;

public class 二维数组 {
	// 二维数组练习
	public void tester(){
		int [][]test = new int[][]{{1,2,3},{2,3},{5,6,7}};
		test[0][0] = 10;
		test[0][1] = 11;
		System.out.println(test[0][0]);
	}
	public static void main(String args[]){
		new 二维数组().tester();
	}
}
