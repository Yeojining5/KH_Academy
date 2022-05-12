package com.day17;

public class A {
	int z = 0;
	void methodA(int i) {
		try {
			z = i/0;
		} catch (Exception e) {
			System.out.println("[Exception]"+e.toString());
		}
	}
	
	public static void main(String[] args) throws Exception {
		int i = 5;
		int j = 0;
		A a = new A();
		a.methodA(i);

	}

}
