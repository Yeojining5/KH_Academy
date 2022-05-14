package Quiz0513;
// 구구단 중에서 시작단과 끝단을 입력받아서  출력하는 프로그램을 작성하시오.
// 메소드 호출 활용
import java.util.Scanner;

public class MultiplicationTable_for_1 {

	Scanner scan = new Scanner(System.in);
	int num1, num2; // 시작단과 끝단을 담을 변수 선언
	
	
	public void multiply() {
		
		System.out.println("구구단의 시작단을 입력하세요."); 
		num1 = scan.nextInt(); // 입력받은 시작단을 num1에 저장
		
		System.out.println("구구단의 끝단을 입력하세요.");
		num2 = scan.nextInt(); // 입력받은 끝단을 num1에 저장
		
		for (int i = num1; i <= num2; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + "x" + j + "=" + (i * j));
			}
		} /////////////////// end of for
	} /////////////////////// end of method multiply

	public static void main(String[] args) {
		MultiplicationTable_for_1 mt = new MultiplicationTable_for_1();
				mt.multiply();
	}

}
