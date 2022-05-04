package Test;
// 더 큰타입은 더 작은 타입에 대입연산자를 통해서 재정의 할 수 없다.
// 대입연산자를 기준으로 오른쪽이 왼쪽보다 큰 타입이 올 수 없다.
// 전변은 인스턴스화 가능. 지변은 인스턴스화 불가능 

public class Exam1 {

	public static void main(String[] args) {
		int i = 5;
		double d = 1.5; // 지변이므로 초기화 필요
		i = (int)d;
		// 위와 같이 강제 형전환을 시키면 0.5는 버림된다.
		System.out.println(i);
		boolean isOk = false; // 지변이므로 초기화 필요
		if(isOk) {
			float f = 1.5f;
			// 조건을 만족하지 않으면 단 한번도 실행기회는 없다.
		}else {
			
		}
	}

}
