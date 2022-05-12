package com.day16;

public class GradeArray_2 {
	// 다음은 우리반 학생들의 자바, html, 오라클과목에 대한 성적표 이다.
	// 총점과 평균 그리고 석차를 구하는 프로그램을 작성하시오.
	// 아래 성적은 2차 배열로 선언한 것입니다.

	int sum = 0;
	double avg = 0.0;
	int count = 0;
	
	// 배열 선언
	public void initArray(int[][] score) {
		arrayPrint(score); // 총점, 평균을 구하는 메소드 호출
		arrayRank(score); // 석차를 구하는 메소드 호출
	}

	public void arrayPrint(int[][] score) {
		for(int i=0; i<score.length;i++) { // score.length = 5
			for(int j=0; j<score[i].length; j++) { // score[i].length = 모두3
				sum = sum + score[i][j];
				count++;
			}
		}
		avg = (double) sum / count;
		
		System.out.println("sum : "+ sum);
		System.out.println("avg : "+ avg);
	}
	
	public void arrayRank(int[][] score) {
		for()
	}
	

	public static void main(String[] args) {
		GradeArray_2 GA = new GradeArray_2();
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
