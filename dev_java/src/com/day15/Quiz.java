package com.day15;

public class Quiz {
// 자바 성적을 난수를 발생시켜 5개 받은후
// 총점 평균 석차를 구하는 프로그램 작성
	public static void main(String[] args) {
		int jumsu[] = new int[5];

		jumsu[0] = (int) (Math.random() * 100) + 1;
		jumsu[1] = (int) (Math.random() * 100) + 1;
		jumsu[2] = (int) (Math.random() * 100) + 1;
		jumsu[3] = (int) (Math.random() * 100) + 1;
		jumsu[4] = (int) (Math.random() * 100) + 1;

		System.out.println(jumsu[0] + ", " + jumsu[1] + ", " + jumsu[2] + ", " + jumsu[3] + ", " + jumsu[4]);

		int sum = 0;

		for (int i = 0; i < jumsu.length; i++) {
			sum += jumsu[i];
		}
		System.out.println("총점 : " + sum);
		double avg = sum / jumsu.length;
		System.out.println("평균 : " + avg);
	}

}
