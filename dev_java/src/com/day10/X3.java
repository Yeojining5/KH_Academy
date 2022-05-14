package com.day10;

public class X3 {

	public static void main(String[] args) {
		String s1 = new String("true"); // 여기서 true 는 논리연산자가 아니다.
		// 원시형타입 boolean의 wrapper클래스 이다
		// 원시형타입은 변수와 메소드를 가질 수 없다.
		// 그런데 이러한 원시형도 변수와 메소드 선언이 필요한 경우가 있다.
		// 이것을 지원하기 위해서 제공되는 클래스가 있는데 그것을 wrapper클래스라고 한다.
		Boolean b1 = new Boolean("true");		
		if(s1.equals(b1)) {
			System.out.println("Equal");
		}else {
			System.out.println("Not Equal");
		}

	}
}

