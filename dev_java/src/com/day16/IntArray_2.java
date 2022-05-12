package com.day16;

public class IntArray_2 {
	// 부서번호를 담을 배열 선언
	int deptnos[] = null; // 나는 1차 배열입니다.
	// 아래 디폴트 생성자는 언제 호출되나요? -31
	public IntArray_2() {
		deptnos = new int[3]; // 배열 생성 - 어떤 장애를 갖나? 오직 int만 담을 수 있다 [해결: 컬렉션프레임워크(자료구조) 공부]
		System.out.println(deptnos); // 변수명 depnos - 주소번지 출력됨
		initArray();
		arrayPrint();
	}

	public void initArray() {
		deptnos[0] = 10;
		deptnos[1] = 20;
		deptnos[2] = 30;
	}

	public void arrayPrint() {
		// 개선된  for문 - 전체조회 할때 (배열의 인덱스만큼 반복)
		// for(변수선언 : 내안에 있는 타입 : 배열의 변수명)
		for (int deptno : deptnos) { // deptnos를 int deptno에 저장
			System.out.println(deptno); 
		}
	}

	public static void main(String[] args) {
		// 인스턴스 변수를 재사용하지 않는 경우라면 아래처럼 해도 괜찮다.
		// 메소드 호출을 생성자에서 하고 있잖아
		new IntArray_2();
	}

}
