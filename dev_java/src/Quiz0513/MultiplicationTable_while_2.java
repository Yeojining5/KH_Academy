package Quiz0513;
//구구단 중에서 시작단과 끝단을 입력받아서  출력하는 프로그램을 작성하시오.
//생성자 호출 활용
import java.util.Scanner;

public class MultiplicationTable_while_2 {

	Scanner scan = new Scanner(System.in);
	int num1, num2; // 시작단과 끝단을 담을 변수 선언
	
	
	public MultiplicationTable_while_2() {
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
		new MultiplicationTable_while_2 ();

	}
}