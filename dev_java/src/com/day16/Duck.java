package com.day16;

public abstract class Duck {
	// 선언 (뒷부분은 변수명)
	FlyBehavior flyBehavior = null; // null 생략가능
	QuackBehavior quackBehavior = null;
	// 추상클래스는 생성자를 가질 수 있다.
	public Duck() { }
	// 고무오리-나무오리-청둥오리는 외모가 각기 다르다.
	// 서로 다른 외모를 구현하려면 구현체 클래스가 필요하다.
	// 결정할 수 없기 때문에 구현체 클래스에서 결정해야함
	
	//flyBehavior = new FlywithWings(); > 추상클래스에서는 구현체 클래스를 결정할 수 없다. (인스턴스화 불가)
	// 왜냐, 구체적인 클래스가 정해지지 않았다. (나무 or 고무 or 청둥 ..)
	
	   public abstract void display(); 
	
	   public void performFly(){ // 바로 이코드가 결합도가 낮다는 것 (fly호출)
	      flyBehavior.fly();
	   }
	   public void performQuack(){
	      quackBehavior.quack();
	   }
	   public void swimming(){
	      System.out.println("모든 오리는 물에 뜹니다. 가짜 오리도 뜨죠");
	   }
	}
