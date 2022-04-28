package com.day8;

public class B {

	public static void main(String[] args) {
		// insert here - A 클래스의 변수 i호출하기
		A a = new A ();
		// 변수 호출은 선언이 먼저이다.
		// B클래스 안에서 i가 선언되지 않았다
		// 아래와 같이 호출할 수 있는 이유 - 변수 i가 전변이기 때문
		System.out.println(a.i); // 5출력
		a.i = 10; // 전역변수 i 의 최초의 값을 10으로 재정의
		System.out.println(a.i);
	}

}
