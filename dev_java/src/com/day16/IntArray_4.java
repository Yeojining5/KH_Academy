package com.day16;
// 1차배열을 파라미터로 받을 수 (넘길 수) 있다
// 사용하기에는 전변보다 지변이 더 어렵다.

public class IntArray_4 {
	// 부서번호를 담을 배열 선언
	public void initArray(int deptnos[]) {
		arrayPrint(deptnos);
	}

	public void arrayPrint(int deptnos[]) {
		for (int deptno : deptnos) {
			System.out.println(deptno);
		}
	}

	public static void main(String[] args) {
		IntArray_4 i3 = new IntArray_4();
		// 배열선언을 지변으로 하였다. - 파라미터 or 리턴타입을 고려해야만 한다.
		int deptnos[] = null;
		deptnos = new int[] { 10, 20, 30 };
		i3.initArray(deptnos); // 가로 안에는 타입을 맞춰야한다는 것 중요!
		
	}

}
