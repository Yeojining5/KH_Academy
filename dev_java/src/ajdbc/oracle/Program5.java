package jdbc.oracle;

public class Program5 {

	public static void main(String[] args) {
		NoticeConsole console = new NoticeConsole();
		//int page;
		
			// 종료 메뉴를 만나기 전까지 무한히 도는 loop
		EXIT:
		while(true) { ////////////////////////////////
			console.printNoticeList(); // 메소드를 먼저 정의(호출) 하고 우클릭하여 NoticeConsole에 create 시킴
			
			int menu = console.inputNoticeMenu();
			
			switch(menu) {
			case 1: // 상세조회
				break;
			case 2: // 이전
				console.movePrevList(); // page는 console 클래스에 정의해두었으므로 호출 > create 하기
				// page--;
				break;
			case 3: // 다음
				console.moveNextList();
				// page++;
				break;
			case 4: // 글쓰기
				break;
			case 5: // 종료
				System.out.println("Bye~~~");
				break EXIT; // while문까지 벗어남
			default:
				System.out.println("<<사용방법>> 메뉴는 1_4까지만 입력할 수 있습니다.");
				break;
			}
		} ////////////////////////////////////////// end of while
	}

}
