package com.day17;

public class B {
	// 메소드 선언 뒤에 throws 하는 경우에는 예외처리를 나를 호출한 곳에서 
	// try.. catch 해주세요 라는 의미 (메소드에서 처리하지 않은 예외를 호출한 곳으로 떠넘기는 것)
	void methodA() throws Exception{
		int is[] = {1,2,4};
		System.out.println(is[3]);
		System.out.println("여기");
		}

	
	public static void main(String[] args) {
		B b = new B();
		try {
			b.methodA();
		} catch (Exception e) {
			System.out.println("예외처리 발생");
		}
		
	}

}
