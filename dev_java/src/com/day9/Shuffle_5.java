package com.day9;
// 변수가 몇 개 필요? - 3개
// 변수 위치는?
public class Shuffle_5 {
	int i = 3;
	int j = 6;
	public boolean methodA() {
		boolean isOk = false;
		i = j; // 3 > 6
		j = i;
		System.out.println(i+", "+j);
		if(i!=3 && j!=6) isOk = true;
		return isOk;  
	}
	public void methodB() {
		
	}
	public static void main(String[] args) {
		Shuffle_5 s4 = new Shuffle_5();
		boolean isOk = s4.methodA();
		if(isOk) {
			System.out.println("참 잘했어요^^");
		}else
			System.out.println("다시 한 번 생각해보세요.");
		
		s4.methodB(); // return타입이 없기때문에 methodA 와 다르게 적는다
		
	}

}
