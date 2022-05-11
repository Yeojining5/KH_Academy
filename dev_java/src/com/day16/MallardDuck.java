package com.day16;

public class MallardDuck extends Duck {
	
	public MallardDuck() {
		//quackBehavior = new XXXXXX();
		flyBehavior = new FlyWithWings();
	}
	
	@Override
	public void display() { // 구현체 클래스
		System.out.println("저는 청둥오리 입니다.");
	}
}
