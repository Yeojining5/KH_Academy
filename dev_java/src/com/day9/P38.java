package com.day9;

public class P38 {
	
	public static void main(String[] args) {
		int i = 10;
		double d = 3.14;
		String s = null;
		boolean isOk = false;
		// 캐스팅 연산자는 받아주는 쪽의 타입으로 쓴다. (int로 맞춤)
		// 받아주는 쪽의 데이터 범위만 담을 수 있다.
		i = (int)d; // 형변환(Casting 연산자)
		d = i;
		// s = (String)d; > 오류. 바꿀 수 있는 타입이 아니다
		// isOk = (boolean) i; > 오류. 논리형이라 불가능
		System.out.println(i);  // 3.14 > 3 출력
		
	}

}
