package com.day9;

public class OCJP_q3 {

	class BaseClass {
		private float x = 1.0f;
		protected float getVar() { return x; }
		}
		class SubClass extends BaseClass {
		private float x = 2.0f;
		//insert code here
		
		}
}

// 상속 관계이므로 메소드 오버라이드
// 부모 BaseClass / 자식 SubClass
