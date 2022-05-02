package com.day10;

public class Banana {
	// int는 정수형이므로 초기값이 0이다 (C언어와 다름)
	public int x; // 초기화 생략됨 - 그러면 0이 담겨있음
	private static int nth;

// 8번 14번은 같은 타입의 생성자라고 할 수 있으나, 파라미터의 개수가 다르다 : 오버로딩
	Banana() {
		// (nth = nth +1;)과 같음
		x = nth++; // 초기값 0 에서 1로 바뀜
		x = nth;
	}

	Banana(int x) {
		this.x = x;
	}

	public static void main(String[] args) {
		// new를 붙이면 타입은 같지만 다른 객체이다
		Banana b1 = new Banana(); // 8번라인 호출
		Banana b2 = new Banana(); // 8번라인 호출
		Banana b3 = new Banana(1); // 14번라인 호출
		Banana b4 = b3; // 14번라인 호출
		Banana b5 = new Banana();
		System.out.println(b1 + ", " + b2 + "\n" + b3 + ", " + b4); // 1,2의 주소번지는 다르고 3,4의 주소번지는 같다
		System.out.println("b1.x => " + b1.x); // 1
		System.out.println("b1.x => " + b2.x); // 2
		System.out.println("b3.x => " + b3.x); // 1
		System.out.println("b4.x => " + b4.x); // 1
		System.out.println("b5.x => " + b5.x); // 3
	}

}
