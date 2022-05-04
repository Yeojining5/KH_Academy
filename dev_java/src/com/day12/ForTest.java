package com.day12;

public class ForTest {

	public static void main(String[] args) {
		int hap = 10;
		for(int i=1 ; i<6 ; i=i+1) { //for(초기화;조건식;증감연산자)
			if(i%2==0) {
				hap = hap+i;
			}
			System.out.println(i);
		}
		System.out.println("1부터 5까지의 합은 "+hap);
	}

}
