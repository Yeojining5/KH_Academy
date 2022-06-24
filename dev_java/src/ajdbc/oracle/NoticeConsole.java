package jdbc.oracle;

import java.util.List;
import java.util.Scanner;

public class NoticeConsole {

	private NoticeService service;
	private int page;
	
	public NoticeConsole() {
		service = new NoticeService();
		page = 1;
	}

	public void printNoticeList() {
		// 서비스가 제공하고 있는 리스트 목록을 얻어서 출력을 하려고 함
		// getList() 파라미터에 1을 주면 1page, 2를 주면 2page 출력.
		// NoticeService 메서드의 반환값을 int page로 주었기 때문
		List<Notice> list = service.getList(page); 
		
		System.out.println("──────────────────────────────────────────────────────");
		System.out.printf("<공지사항> 총 %d 게시글\n", 12);
		System.out.println("──────────────────────────────────────────────────────");
		// 반복해서 출력해야 하므로 for문 사용
		for(Notice n : list) {
			System.out.printf("%d. %s / %s / %s\n",
								n.getId(),
								n.getTitle(),
								n.getWriterId(),
								n.getRegDate());
		}
		//System.out.printf("%d. %s / %s / %s\n", 12, "안녕하세요", "newlec", "2020-10-09");
		
		System.out.println("──────────────────────────────────────────────────────");
		System.out.printf("                  %d/%d pages\n", 1,2);
	}

	public int inputNoticeMenu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("1.상세조회 / 2.이전 / 3.다음 / 4.글쓰기 / 5.종료 >");
		String menu_ = scan.nextLine();
		int menu = Integer.parseInt(menu_);
		
		return menu;
	}

	public void movePrevList() {
		if(page == 1) {
			System.out.println("이전 페이지가 없습니다.");
			return;
		}
		page--;
		
	}

	public void moveNextList() {
//		if(page == ?) {
//			System.out.println("이전 페이지가 없습니다.");
//			return;
//		} // 마지막 페이지를 구하는 로직이 필요함
		page++;
		
	}

}
