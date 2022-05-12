package com.day16;

public class GradeArray_3 {
	// 다음은 우리반 학생들의 자바, html, 오라클과목에 대한 성적표 이다.
	// 총점과 평균 그리고 석차를 구하는 프로그램을 작성하시오.
	// 아래 성적은 2차 배열로 선언한 것입니다.
	public static void main(String[] args) {
		int score[][] = {
				 {100,90,80}
				,{85,90,80}
				,{70,70,80}
				,{90,60,65}
				,{65,80,70}
		};
		//과목별 총점
		int javaTot = 0, htmlTot = 0, oracleTot = 0;
		
		System.out.println("번호  java  html  oracle  총점  평균");
		System.out.println("======================================");
		
		for(int i =0; i<score.length;i++) {
			int sum = 0; // 개인별 총점  
			double avg = 0.0; // 개인별 평균
			
			javaTot += score[i][0];
			htmlTot += score[i][1];
			oracleTot += score[i][2];
			System.out.printf("%3d", i+1); // 번호 출력
			
			for(int j=0;j < score[i].length; j++) {
				sum += score[i][j];
				System.out.printf("%6d", score[i][j]); // 각 점수 출력
			}
			
			 avg = (double) sum / score[i].length; // 평균계산
			 System.out.printf("%8d %6.1f%n", sum, avg); // 총점, 평균 출력
		}
		
		System.out.println("======================================");
		System.out.printf("총점: %4d %4d %5d%n", javaTot, htmlTot, oracleTot);
	}

}
