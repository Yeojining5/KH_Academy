package com.day10;

class TestSuper {
	// 파라미터가 있는 생성자가 하나라도 있다면 디폴트 생성자는 자동으로 제공안됨
	TestSuper() {
	} // 이 디폴트 생성자를 생성해야 컴파일 에러가 나지않음

	TestSuper(int i) { // int 타입의 i를 가진 생성자
		System.out.println("TestSuper(int i) 호출 성공");
	}
}

class TestSub extends TestSuper {

}

public class TestAll {

	public static void main(String[] args) {

	}

}
