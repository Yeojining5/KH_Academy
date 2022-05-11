package com.day16;

public class GradeArray {
	// 다음은 우리반 학생들의 자바, html, 오라클과목에 대한 성적표 이다.
	// 총점과 평균 그리고 석차를 구하는 프로그램을 작성하시오.
	// 아래 성적은 2차 배열로 선언한 것입니다.
	public void initArray(int[][] score) {
		arrayPrint(score);
	}

	public void arrayPrint(int[][] score) {
		
	}
	

	public static void main(String[] args) {
		GradeArray GA = new GradeArray();
		int score[][] = {
				 {100,90,80}
				,{85,90,80}
				,{70,70,80}
				,{90,60,65}
				,{65,80,70}
		};
		GA.initArray(score);
	}

}
