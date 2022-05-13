package com.day17;

/* 2022년 5월12일 숙제
 * 1부터 100까지 세면서 3의 배수의 합을 구하는 프로그램을 작성하시오.
 * for문을 이용해서 풀어보고 나서 while문으로 바꾸어서도 풀어보기
 */
public class MultiplesHap_for {

	int num[] = new int[100];
	int hap = 0; // 3의 배수의 합을 담을 변수

	public void count() {
		System.out.println("MultiplesHap_for");
		for (int i = 0; i < num.length; i++) {
			num[i] = i + 1;
			if (num[i] % 3 == 0) {
				hap += num[i];
				System.out.println(num[i] + " / 3의 배수의 합 : " + hap);
			} else {
				System.out.println(num[i]);
			}
		}////////////////////// end of for
	}

	public static void main(String[] args) {
		MultiplesHap_for MH = new MultiplesHap_for();
		MH.count(); 
	}
}
