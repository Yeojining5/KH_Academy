package com.day21;
// 0 부터 9사이의 임의의 수를 100개를 채번하여 한 줄에 10개씩
// 출력하고 그 숫자의 빈도수를 계산하여 출력하시오

import java.util.Random;

public class BinDoTemplate {
	public BinDoTemplate() {
		int nanSus[] = new int[100];
		int pCount[] = new int[10];
		int size = 0;
		initArray(nanSus, nanSus.length); // size는 nanSus.length을 파라미터로 넘김
		numberCount(nanSus, nanSus.length, pCount);
		print10PerLine(nanSus, nanSus.length); // 초기화 메서드 이후에 와야함
		printResult(pCount, 10);
	}

	// 배열의 초기화
	void initArray(int nanSus[], int size) {
		for(int i=0;i<nanSus.length;i++) {
			nanSus[i] = (int)(Math.random()*10); // 0부터 9까지 랜덤하게 채번
		}
	}

	// 빈도 검사 nanSus에 들어 있는 숫자의 빈도를 pCount에 저장함
	void numberCount(int nanSus[], int size, int pCount[]) {
		int nIndex = 0;
		// 채번된 100개의 숫자에 대해 판정을 해야한다.
		for(int i=0;i<size;i++) {
			// 카운트하기 위해서 일단 배열의 값을 담았다.
			// 채번된 숫자가 배열(pCount)의 인덱스에 담김
			nIndex = nanSus[i];
			//pCount는 100개의 숫자에 대한 빈도수를 관리하는 1차배열이다.
			pCount[nIndex]++;
		}

	}

	// 배열 출력 한 줄에 10개씩 출력하고 줄바꿈 하기
	void print10PerLine(int nanSus[], int size) {
		System.out.printf("원본 : 	");
		for (int i = 0; i < size; i++) {
			System.out.printf("%3d", nanSus[i]);
			if (i % 10 == 9)
				System.out.printf("\n	");
		}
	}

	// 빈도 출력 빈도 배열과 인덱스를 함께 출력
	void printResult(int pCount[], int size) {
		System.out.println("\n "); // 개행 처리
		System.out.printf("숫자 :");
		for(int i =0;i<size;i++) {
			System.out.printf("%3d", i);
		}
		System.out.println("\n ");
		System.out.printf("개수 :");
		for(int i=0;i<size;i++) {
			System.out.printf("%3d", pCount[i]);
		}
	}

	public static void main(String[] args) {
		new BinDoTemplate();
		
		
	}

}