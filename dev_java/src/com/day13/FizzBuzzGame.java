package com.day13;

public class FizzBuzzGame {

	public static void main(String[] args) {
		int i; // 선언과 초기화를 쪼개서 쓸 수 있는 건 메소드 안 또는 생성자 안에서만 가능함.
		i = 1;
		while (i < 101) { // while문은 for문과 달리 초기화가 없기 때문에 선언 먼저!
			// 초기값이 1인 경우 1부터 출력해야하니까 출력 먼저, 초기값이 0이면 증가 먼저 
			if((i%5==0) && (i%7==0)) {
				System.out.println("FizzBuzz");
			}else if (i%5==0) {
				System.out.println("Fizz");
			}else {
				System.out.println(i);
			}
			++i;
		} /////////////////////////// end of while
	}/////////////////////////////// end of main
}/////////////////////////////////// end of FizzBuzzGame
