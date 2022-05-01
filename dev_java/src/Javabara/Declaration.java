package Javabara;

public class Declaration {
	// 메서드를 정의 = 선언부와 구현부를 작성하는 것, 메서드의 이름은 'add'처럼 동사인 경우가 多
	// 선언부 - 반환타입(출력, 없는 경우 void) 메서드이름(매개변수선언, 선언, ...)
	// 구현부 - 메서드 호출시 수행될 코드
	int add(int a, int b) {
		int result = a + b; // 두 개의 정수를 입력받아서, 두 값을 더한 결과(int타입의 값)를 반환한다.
		return result; // 호출한 메서드로 결과를 반환한다.
	}	
	// 매개변수 선언(Parameter Declaration) = **지역변수**
	// 매개변수는 메서드가 작업을 수행하는데 필요한 값들(입력)을 제공받기 위한 것
	// int a, int b 와 같이 타입이 같아도 생략할 수 없다
		
}
