package com.day17;

public class TwoArray_1 {
	// jumsus[0] 호출하면 값이 출력되지만 2차배열에서는 1차 배열의 주소번지 이다.
	// 다차원 배열이 가능하다
	
	public static void main(String[] args) {

		// UI - 테이블 구조 / 오라클 테이블 조회
		int jumsus[][] = new int[3][2]; // 컬럼 + 로우
		jumsus[0] = new int[2];
		jumsus[0][0] = 0;
		jumsus[0][1] = 0;
		jumsus[1] = new int[2];
		jumsus[1][0] = 0;
		jumsus[1][1] = 0;
		jumsus[2] = new int[2];
		for(int i=0;i<jumsus.length;i++) {
			for(int j=0;j<jumsus[i].length;j++) {
				System.out.println("jumsu["+i+"] ["+j+"] = "+jumsus[i][j]);
			}
		}
		
	}

}
