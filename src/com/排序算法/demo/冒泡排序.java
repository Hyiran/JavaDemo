package com.ÅÅĞòËã·¨.demo;

public class Ã°ÅİÅÅĞò {
	
	
	public static void sourt(int []list) {
		for(int i=0;i < list.length;i++){
			for(int j=list.length -1;j > 0; j--){
				if(list[j] < list[j - 1]){
					int tmp = list[j];
					list[j] = list[j-1];
					list[j-1] = tmp;
				}
			}
			System.out.println("\n");
			for (int k : list) {
				System.out.print(k + " ");
			}
		}
		
	}

	public static void main(String args[]) {

		int[] arr = { 5,4,3,2,1,0 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length - 1; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					int tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}
			}
			
			System.out.println("\n");
			for (int k : arr) {
				System.out.print(k + " ");
			}
		}
		
		int[] arr1 = { 5,4,3,2,1,0 };
		System.out.println("\n");
		sourt(arr1);
	}
	
	
	
	

}
