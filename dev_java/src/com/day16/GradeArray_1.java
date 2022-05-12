package com.day16;

public class GradeArray_1 {
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
		
		int sum = 0;
		double avg = 0.0;
		
		int count = 0; //배열의 항목수를 누적해서 저장하는 변수
		for(int i=0; i<score.length;i++) { // score.length = 5
			for(int j=0; j<score[i].length; j++) { // score[i].length = 모두3
				System.out.println("i : "+i);
				System.out.println("j : "+j);
				sum = sum + score[i][j];
				count++;
				System.out.println(score[i][j]); //100에서 70까지 순서대로 출력
				System.out.println("count : "+count); // 1 에서 15까지 순서대로 출력
				System.out.println("-------------");
			}
			
		}
		avg = (double) sum / count;
		
		System.out.println("sum : "+ sum);
		System.out.println("avg : "+ avg);
	}

}
