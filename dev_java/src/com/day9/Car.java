package com.day9;

public class Car {
	int wheelNum = 0;
	public void stop() {
		
	}

}

class Sonata extends Car{ // Car로 부터 상속받음
	@Override
	public void stop () {
		
	}
	// 메소드 오버로딩 규칙을 준수 했음
	public int stop (int i) {
		return 0;		
	}
	public double stop (double i) {
		return 0;		
	}
}