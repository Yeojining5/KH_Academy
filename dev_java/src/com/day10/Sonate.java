package com.day10;

public class Sonate {
	int speed; // 너는 지금 몇 km로 달리고 있니?
	String carColor; // 자동차 마다 대표 색상이 있다
	int wheelNum;

	public Sonate() {
	}

	public Sonate(String carColor) {
		System.out.println(carColor);
		// carColor = "검정색";
		this.carColor = "검정색"; // this는 전역변수를 말함
		System.out.println(carColor);
	}

	public static void main(String[] args) {
		// this.speed = speed;
		// this.carColor = carColor;
		// this.wheelNum = wheelNum;

	}

	@Override
	public String toString() {
		return "내 자동차는 현재 " + speed + "로 달리고 있고 바퀴수는 " + wheelNum + "이고, 자동차 색상은 " + carColor + "입니다.";
	}

}
