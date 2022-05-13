package com.day17;

import java.util.Scanner;

public class BaseBallGameDemo4 {
	// 파라미터를 String으로 한 이유, 화면에서 입역받을 때 숫자를 쳐도 문자열로 취급되기 때문 "245"
	public String account(String input) {
		System.out.println("사용자가 입력한 값 받아오기 : "+input);
		// length : 배열의 원소개수
		// length() : 문자열의 개수
		if(input.length() !=3) {
			// 반복문을 탈출할 때는 break
			// 조건문을 탈출할 때는 return
			return "세자리 숫자를 입력하세요.";
		}
		
		int temp = 0;
		try { 
			temp = Integer.parseInt(input);
		} catch (NumberFormatException ex) {
			return "숫자만 입력하세요.";
		}

		return "1스트라이크 0볼";
	}
	

	public static void main(String[] args) {
		BaseBallGameDemo4 bbg = new BaseBallGameDemo4();
		Scanner scan = new Scanner(System.in);
		System.out.println("0부터 9까지 세자리 숫자를 입력하세요.");
		String result = bbg.account(scan.next()); 
		System.out.println("판정 결과 : " + result);

	}

}
