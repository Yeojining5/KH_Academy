package com.week1;

class Dog{
	int leg = 0;
}
public class Parameter_1 {
	static void methodA(Dog myDog) {
		System.out.println(myDog.leg);
		myDog.leg = 2;
	}
	public static void main(String[] args) {
		Dog myDog = new Dog();
		myDog.leg = 4; // 0 > 4
		methodA(myDog); // 4 출력 > 메서드를 통과하면 값이 2로 변함
		System.out.println(myDog.leg); // 2출력
	}

}
