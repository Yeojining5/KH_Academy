package com.day9;

class OCJP_pq1 {
	public byte getNumber() {
		return 1;
	}
}

public class OCJP_q1 extends OCJP_pq1{  // 자식 왼쪽 extends 부모 오른쪽
	@Override
	public byte getNumber() {
		return 2;
	}	
	
			
	public static void main(String args[]) {
		OCJP_q1 b = new OCJP_q1();
		System.out.println(b.getNumber());
	}


}
