package com.day21;

import com.day16.MallardDuck;

// 사용자정의 클래스
public class DuckTest {
	MallardDuck myDuck = null; // 전역변수 선언
	
	// 메소드를 통해서 객체를 주입 받을 수 있다.
	MallardDuck getInstance () {
		// 중급으로 가는 길 - 싱글턴 패턴 검색 - 공유
		if(myDuck == null) {	
		myDuck = new MallardDuck();
		}
		myDuck = new MallardDuck();
		return new MallardDuck();
	}
	
	void test() {
		getInstance().display();
	}
	
	public static void main(String[] args) {
		DuckTest dt = new DuckTest();
		dt.test();
	}

}
