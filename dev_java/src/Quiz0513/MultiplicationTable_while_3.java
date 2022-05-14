package Quiz0513;

import java.util.Scanner;

public class MultiplicationTable_while_3 {

	Scanner scan = new Scanner(System.in);
	int num1; // 시작단을 담을 변수 선언
	int num2; // 끝단을 담을 변수 선언
	
	
	public MultiplicationTable_while_3(int i, int j) {
		multiply();
	}
	
	public void multiply() {
		
		System.out.println("구구단의 시작단을 입력하세요."); 
		num1 = scan.nextInt(); // 입력받은 시작단을 num1에 저장
		
		System.out.println("구구단의 끝단을 입력하세요.");
		num2 = scan.nextInt(); // 입력받은 끝단을 num1에 저장
		
		int i = num1;
		int j;
		while(i<=num2) {
			j=1; // 초기화문
			while(j<=9) {
				System.out.println(i + "x" + j + "=" + (i * j));
				j++;
			}
			i++;
		} ///////////////////// end of while
	}

	public static void main(String[] args) {
		new MultiplicationTable_while_3 (1, 1);

	}
}