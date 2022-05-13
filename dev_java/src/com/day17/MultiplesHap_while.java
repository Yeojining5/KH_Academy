package com.day17;

public class MultiplesHap_while {

	int i;
	int hap = 0; // 3의 배수의 합을 담을 변수

	public void count() {
		System.out.println("MultiplesHap_while");
		i = 1;
		while (i < 101) {
			if (i % 3 == 0) {
				hap += i;
				System.out.println(i + " / 3의 배수의 합 : " + hap);
			} else {
				System.out.println(i);
			}
			i++;
		} /////////////////////// end of while
	}

	public static void main(String[] args) {
		MultiplesHap_while MH = new MultiplesHap_while();
		MH.count();
	}
}
