package com.day13;

public class Initialization_6 {
	int count;
	int hap = 0;
	public void account1() {
		for(count=1;count<6;count++) {
			hap = hap+count;
		}
		System.out.println("after count : "+count); 
		System.out.println("after hap : "+hap);// 출력 문장은 for문 바깥에!
		
		count = 1;
		for(;count<6;count++) {
			 if(count%2==1)
				hap = hap+count;
		}
		System.out.println("홀수의 합은 : "+hap);

	}

	public static void main(String[] args) {
		Initialization_7 i3 = new Initialization_7 ();
		i3.account();

	}

}
