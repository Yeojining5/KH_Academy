package com.day9;
// 변수가 몇 개 필요? - 3개
// 변수 위치는?
public class Shuffle_2 {
	int i = 21;
	int j = 45;
	int imsi = 0;
	
	public Shuffle_2() {
		imsi = i;
		i = j; // 3 > 6
		j = imsi;
		System.out.println(i+", "+j);
	}
	
	public static void main(String[] args) {
		Shuffle_2 s1 = new Shuffle_2(); // 여기서 ()는 생성자 호출 자리
		
	}

}
