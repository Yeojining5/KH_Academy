package com.day19;

import com.day16.Duck;
import com.day16.MallardDuck;
import com.day16.RubberDuck;

// 생성부와 선언부의 이름이 다르면 안된다 - 상속관계, 인터페이스를 implements한게 아니니까

public class DuckTest {
	// 파라미터에 더 상위 클래스 타입을 적어주면 다양한 구현체 클래스를 받을 수 있다 - 다형성 기대 가능함
	// 같은 이름의 메소드가 호출되더라도 기능이 서로 다르게 동작된다.
	// 선언부와 생성부의 이름이 다를때 가능하다.
	// 이것이 가능하려면 상속관계 or 인터페이스의 구현체 클래스 이라면 가능하다.
	public void methodA(Duck duck) {
		System.out.println("methodA(Duck)");
		if(duck instanceof RubberDuck) { // 너 RubberDuck 타입이니?
			System.out.println("I am RubberDuck Type");
		}else if(duck instanceof MallardDuck) {
			System.out.println("I am MallardDuck Type");
		}else {
			System.out.println("I am just Duck Type"); // 기타 덕타입
		}
		
		
		System.out.println(duck);
	}
	public void methodA(MallardDuck duck) {
		System.out.println("methodA(MallardDuck)");
		System.out.println(duck);
	}
	// 메소드의 파라미터 자리는 선언만. 초기화는 불가하다
	public void methodC(int i) {
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		DuckTest dt = new DuckTest();
		//Duck myDuck = new Duck(); // 추상클래스 생성자호출 - 단독으로 호출할 수없다! Duck클래스에 가보면 생성자있음 
		//** 구현체 클래스가 필요하다**
		Duck herDuck = new MallardDuck();
		Duck myDuck = new RubberDuck();
		// 인스턴스 변수가 있으면 다른 변수나 다른 메소드 호출 시 재사용 가능
		// new RubberDuck(); 이렇게 사용하면 한번만 사용 가능하고 재사용 불가
		dt.methodA(new RubberDuck()); // RubberDuck의 상위클래스는 Duck이다. 러버덕 클래스 가보면 상속받고 잇음
		
		// 참조형 타입(주소번지)를 파라미터로 넘기는 사람 =  잘하는 사람
		dt.methodA(herDuck);
		dt.methodA(myDuck); // pass by value(주소번지를 넘긴다=원본,참조형) <-> call by value(값에의한호출=복사본,원시형)
		//dt.methodB(new MallardDuck());
		dt.methodC(5);
		//dt.methodA(참조형타입); // 파라미터 자리에 숫자는 올수 없다. 타입이 다르니까
	}

}
