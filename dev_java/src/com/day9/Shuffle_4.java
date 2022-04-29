package com.day9;
// 변수가 몇 개 필요? - 3개
// 변수 위치는?
public class Shuffle_4 {
	public boolean methodA(int i, int j) {
		int imsi; // 지역변수 선언
		imsi = i;
		i = j; // 3 > 6
		j = imsi;
		System.out.println(i+", "+j);
		return true;  //셔플이 성공하면 true, 실패하면 false
	}
	public void methodB() {
		
	}
	public static void main(String[] args) {
		Shuffle_4 s4 = new Shuffle_4();
		boolean isOk = s4.methodA(3,  6);
		if(isOk) {
			System.out.println("참 잘했어요^^");
		}
		
		s4.methodB(); // return타입이 없기때문에 methodA 와 다르게 적는다
		
	}

}
