package com.java��ϰ;

public class ���� {
	static final int TYPE = 0;
	public static void main(String args[]) {
		����.TYPE = 1; //���������Ա��޸�
	}
}

class test2 extends ����{
	
	public static void main(String args[]) {
		System.out.println(����.TYPE);
		System.out.println(test2.TYPE); // �������Ա��̳�
	}
	

}

