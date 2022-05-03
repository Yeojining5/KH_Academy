package Javabara;

import java.util.Scanner;

public class ScanfEx1 {

	public static void main(String[] args) {
		//출력관련 객체는 사용후 닫아줘야 한다는 에러. but JVM에서 관리를 하기때문에 무시 해도됨
		Scanner scanner = new Scanner(System.in); 
		
		int num = scanner.nextInt(); // console창에 입력된 정수값을 변수 num에 저장
		int num2 = scanner.nextInt(); // console창에 입력된 정수값을 변수 num2에 저장
		
		System.out.println(num); // num에 저장된 값 출력
		System.out.println(num2); // num2에 저장된 값 출력
		
		//String input = scanner.nextLine(); // 라인단위로 입력 받기
		//int num = Integer.parseInt(input);  // 이렇게 두 문장을 10번으로 간소화 할 수 있음
		
		//System.out.println(num);

	}

}
