package com.day16;
// FlyWithWings는 FlyBehavior 인터페이스의 구현체 클래스이다.
// Why?  FlyBehavior 에 있는 추상메소드 fly()를 내가 오버라이딩 하고 있으니까
// 아래 클래스는 고무오리와 청둥오리중에 누구의 구현체 클래스가 되어야 하나?
public class FlyWithWings implements FlyBehavior {
	
	@Override
	public void fly() {
		System.out.println("날고 있어요");
	}
}
