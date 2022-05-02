package com.day10;

// 두 개의 클래스가 A is a B 관계에 있을 때
// 객체 지향 언어에서는 상속관계로 설계한다
// 전변은 초기화를 생략할 수 있다 - 생성자를 통해서 초기화를 대신 지원받는다.

class Super { // 부모클래스
	// 파라미터가 아무것도 없으니까 생략하면 JVM이 대신 로딩해준다 (convention)
	Super() { // 파라미터가 없는 생성자를 디폴트 생성자라 한다.
		System.out.println("Super() 호출 성공!");
	}

	public void methodA() {
		System.out.println("Super methodA 호출 성공");
	}
} ////////////////////////////// Super class 끝


class Sub extends Super { // 자식클래스
	Sub() { // 파라미터가 없는 생성자를 디폴트 생성자라 한다.
		System.out.println("Sub() 호출 성공");
	}

	@Override
	public void methodA() {
		System.out.println("Sub - methodA 호출 성공");

	}
} ////////////////////////////// Sub class 끝

public class Overloading_1 {

	public static void main(String[] args) {
		Super sup = new Super();
		sup.methodA(); // Super - methodA 호출 성공
		Sub sub = new Sub();
		sub.methodA(); // Sub - methodA 호출 성공

		// **선언부와 생성부의 타입이 다르다!** 다형성(폴리모피즘), 인스턴스화의 2번째 방법
		// Super sup1 = new Sub ();
		// sup1.methodA(); // 생성부의 이름으로 호출된다.

	}

}
