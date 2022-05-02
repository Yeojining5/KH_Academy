package com.day10;

public class X {

	public static void main(String[] args) {
		String s1 = new String("true"); // 여기서 true 는 논리연산자가 아니다.
		boolean isOk = false;
		// Boolean b1 = new Boolean("true");
		if (isOk) {
			System.out.println("참이다");
		} else {
			System.out.println("거짓이다");
		}

		// if(s1.equals(b1)) {
		// System.out.println("Equal"); // 참이 아니라서 아무것도 출력되지 않는다.
	}
}
