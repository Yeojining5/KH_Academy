package com.day10;

import javax.swing.JButton;

public class SonateSimulation {

	public static void main(String[] args) {
		Sonate myCar = new Sonate(); // 초기화된 상태
		// Sonate myCar = new Sonate(65, "자주색", 4);
		Sonate herCar = new Sonate("핑크");
		System.out.println(herCar.carColor);
		System.out.println(myCar + ", " + herCar);
		System.out.println(myCar.toString() + ", " + herCar.toString());
		JButton jbtn = new JButton("전송");
		System.out.println(jbtn);
	}

}
