package com.day15;

public class Quiz {
// 자바 성적을 난수를 발생시켜 5개 받은후
// 총점 평균 석차를 구하는 프로그램 작성
	public static void main(String[] args) {
		int jumsu[] = new int[5];
		int rank[] = new int[5];
		int sum = 0;
		
		for (int i = 0; i < jumsu.length; i++) {
			jumsu[i] = (int) (Math.random() * 100) + 1;
			sum += jumsu[i];			
		}
		
		for(int i=0;i<jumsu.length;i++) {
			rank[i] = 1;
		}
		
		for(int i=0; i<jumsu.length;i++) {
			rank[i] = 1;
			for(int j=0;j<jumsu.length;j++) {
				if(jumsu[i] < jumsu[j]) {
					rank[i] = rank[i]+1; // j점수보다 작으면 순위 증가
				}
			}
		}
		
		for (int i = 0; i < jumsu.length; i++) {
			System.out.println("점수"+ (i+1)+" : "+jumsu[i]+ " (석차 : "+rank[i]+")");
		}
		
		System.out.println("총점 : " + sum);
		double avg = sum / jumsu.length;
		System.out.println("평균 : " + avg);
	}

}
