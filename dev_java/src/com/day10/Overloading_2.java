package com.day10;

class Super1 {
	public int i = 0;

	// 필요가 없는 생성자라 하더라도 상속관계에 있을 때는
	// 반드시 상위 클래스의 디폴트 생성자를 정의해야 합니다.
	Super1() { // 디폴트 생성자 - 파라미터가 없는 생성자, 여기를 주석으로 막으면 컴파일에러
		System.out.println("Super1 디폴트 생성자 호출");
	}

	Super1(String text) {
		System.out.println("Super1(text) 생성자 호출");
		this.i = 1;
	}
}

class Sub1 extends Super1 {
	Sub1(String text) {
		super("Hello"); // super는 상위 클래스를 가리키는 수정자임
		// 그 수정자뒤에 괄호가 붙으면 생성자를 호출하게 됨.
		i = 2;
	}
}

public class Overloading_2 {

	public static void main(String[] args) {
		// 자녀 클래스를 인스턴스화 하더라도 부모 클래스의 생성자를
		// 먼저 호출하게 되는데 이때 선언된 생성자가 하나라도 존재하면
		// 디폴트 생성자라 하더라도 JVM이 제공하지 않는다.
		Sub1 sub = new Sub1("Hello");
		System.out.println(sub.i);

	}

}
