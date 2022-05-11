package com.day16;

public class DuckSimulation {

	public static void main(String[] args) {
		//FlyBehavior flyBehavior = new FlyBehavior(); //선언부와 생성부의 타입이 달라야 하기 때문에 오류
		Duck myDuck = new MallardDuck();
		// MallardDuck은 FlyBehavior의 구현체 클래스가 아니다.
		// MallardDuck은 fly메소드를 직접 오버라이딩 하지 않기때문에 아래 fly()를 호출할 수 없다.
		// myDuck.fly(); 오류
		myDuck.performFly();
		myDuck.display();
		myDuck = null;
		myDuck = new RubberDuck();
		myDuck.display();
		myDuck.performFly();
	}

}
