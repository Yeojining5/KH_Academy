<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	int x = 1;
	public String newsList(String news[]){
		StringBuilder sb = new StringBuilder();
		sb.append("<table width='500px' border='1'>");
		sb.append("<tr><td>"+news[0]+" > "+news[1]+"</td></tr>");
		sb.append("</table>");
		return sb.toString();
	}
%>    
<%
	String news1[] = {"연합뉴스","정부, 성장률 목표 2.4∼2.5%로 0.2%p 하향…고용 전망은 상"};
	String news2[] = {"연합뉴스","학교비정규직노조 총파업' 급식대란 현실화…4천600여개교 차질"};
	String news3[] = {"연합뉴스","징용보복에 日산업계 우려 확산…日공급망 파괴"};
	String news4[] = {"연합뉴스","정부 투자회생 올인…대기업 투자세액공제율 2배로↑"};
	String news5[] = {"연합뉴스","식약처, '인보사' 허가취소 확정…코오롱 소송 진행"};
	String datas = "";
	switch(x){
	case 1:
		datas = newsList(news1);
		x++;
		break;
	case 2:
		datas = newsList(news2);
		x++;
		break;
	case 3:
		datas = newsList(news3);
		x++;
		break;
	case 4:
		datas = newsList(news4);
		x++;
		break;
	case 5:
		datas = newsList(news5);//메소드 호출시 파라미터로 뉴스 정보 넘김.
		x=1;//기사 내보낸 후 다음 기사 정보를 가져오기 위해서 1씩 증가시킴.
		break;//case문을 탈출함. 다음 조건으로 넘어가면 안되니까
	}//////////////end of switch
	//이전요청에서 가지고 있던 정보 지우기
	//아래코드를 생략하면 이전 정보를 계속 유지하므로 새로운 기사 처리 안됨.
	out.clear();
	//새로 읽어들인 정보 출력하기
	out.print(datas);
%>