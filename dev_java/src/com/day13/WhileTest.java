package com.day13;

public class WhileTest {
	/****************************************************
	 * 합을 구하는 메소드 구현
	 * 
	 * @param i   카운트 하는 변수
	 * @param hap 합을 담을 변수
	 ****************************************************/
	int i;
	int hap;
	public int account(int i, int hap) { //파라미터 자리에 선언된 변수는 지변이다.
		while (i < 6) {
			hap = hap + i;
			System.out.println("i : " + i);
			System.out.println("hap : " + hap);
			i++;
		}
		return hap; // 반환타입이 int인 경우 return 값을 주어야함
	}

	public static void main(String[] args) {
		WhileTest w = new WhileTest();
		int hap = w.account(1, 0); // 원시형 타입은 메소드 호출시 값에 의한 호출이 일어난다.
		System.out.println("1부터 5까지의 합은 " + hap);
		System.out.println(w.hap);

	}

}
