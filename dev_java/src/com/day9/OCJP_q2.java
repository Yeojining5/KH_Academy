package com.day9;
// 메소드의 이름이 다르면 메소드오로딩 이나 오버 라이딩을 따질 필요가 없다
public class OCJP_q2 {
	public void setVar(int a, int b, float c) {
	}

	private void setVar(int a, float c, int b) {} // 인자의 순서가 다르므로 ok
	
	//protected void setVar(int a, int b, float c) {} // 인자의 순서가 같으면 안된다
	
    public int setVar(int a, float c, int b) { return a; } // ok 
    
	//public int setVar(int a, int b, float c) { return a; }
	
	//protected float setVar(int a, int b, float c) { return c; }

}
