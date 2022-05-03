package com.day10;

public class Circle {
	// 정적 변수 double타입 선언 - PI는 인스턴스화 없이 다른 클래스에서도 사용가능
	// 변수 선언시 final이 붙으면 상수가 되어 다른값으로 재정의 불가함
	// 따라서 setPi 메소드는 생성되지 않는다
	public static final double PI = 3.14;
	// 반지름을 담을 변수 선언 - 전변이므로 초기화 생략가능 - double의 디폴트값은 0.0
	public double radius;
	
	public Circle() { }
	
	public Circle(double radius) { //파라미터가 있는 생성자가 하나라도 있으면 디폴트 생성자를 JVM이 제공안함
		this.radius = radius; // 생성자 호출시 파라미터로 넘어온 값이(Call by value) 전변에 담긴다
	}
	// getter메소드 호출하면 반지름이 저장된 값이 반환됨
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) { // Run클래스의 메소드 호출로 3.1이 복사된다 Call by value
		this.radius = radius; // 파라미터로 복사된 3.1을 전변에 대입
	}
	public static double getPi() {
		return PI;
	}
	// 호출되면 반지름 3.1cm인 원을 그립니다.
	public void draw() {
		System.out.println("반지름" + radius + "cm인 원을 그립니다.");
	}
	
}
