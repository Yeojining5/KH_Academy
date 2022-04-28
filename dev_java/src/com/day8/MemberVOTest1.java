package com.day8;

import com.method.MemberVO; // package 가 다르므로 import

public class MemberVOTest1 {

	public static void main(String[] args) {
		MemberVO mVO = new MemberVO () ;
		mVO.setName("이순신");
		// 파라미터에 입력한 문자열 상수는 어디에 저장되어 있을까?
		// MemberVO 클래스의 전역변수인 name변수에 들어있다
		System.out.println(mVO.getName());
		// 같은 타입의 클래스라 하더라도 new를 통해서 인스턴스화를 여러번 하면
		// 타입은 같지만 다른 객체가 여러개 만들어지는 것이다.
		mVO = new MemberVO (); // 여기서 mVO는 위에 선언된 것과 다른 주소번지를 가진다 (바뀌어버림)
		mVO.setName("강감찬");
		System.out.println(mVO.getName());
	}

}