package com.day16;

public class GradeArray_2 {
	// 다음은 우리반 학생들의 자바, html, 오라클과목에 대한 성적표 이다.
	// 총점과 평균 그리고 석차를 구하는 프로그램을 작성하시오.
	// 아래 성적은 2차 배열로 선언한 것입니다.
	
	// int jumsu[] = new int[5]; 선언 방식
	// int rank[] = new int[5];
	//int score[][] = new int[5][3]; // 4행 3열의 2차원 배열 선언
	// int[][] score;  int score[][]; 가능
	int score[][] = {
			 {100,90,80}
			,{85,90,80}
			,{70,70,80}
			,{90,60,65}
			,{65,80,70}
	};
	
	int sum;
	double avg;
	int rank[] = new int[5];
	double results[][] = new double[score.length][3]; // 총점,평균,석차의 결과를 담을 변수 배열 선언
	
	public GradeArray_2() {
		initArray();
	}
	
	public void initArray() {
		for(int i=0; i<score.length; i++) {
			sum = 0; //j for문 한번 돌고 0으로 초기화 시켜야 1행-2행-3행의 각각 합계를 구할 수 있음
			avg = 0.0;
			for(int j=0; j<score[i].length; j++) {
				sum += score[i][j];
				avg = (double) sum / score[i].length;
			}
			System.out.println("[학생"+(i+1)+"] 총점 : "+sum+" / 평균 : "+avg);
			results[i][0] = sum; //석차구할때 사용
			results[i][1] = 1;  //석차구할때 사용 1등으로 초기화
			System.out.println(results[i][0]);
		}
		
		for(int i=0; i<score.length; i++) {
			rank[i] = 1;
		}
		
		for(int i=0; i<score.length; i++) {
			rank[i] = 1;
			for(int j=0; j<score[i].length; j++) {
				if(results[i][0] < results[j][0]) {
					results[i][1]++;
				}
			}
		}
		for(int i =0;i<score.length;i++) {
			System.out.println("석차 : "+(int)results[i][1]);
		}
	}

	public static void main(String[] args) {
		new GradeArray_2();
	}

}
