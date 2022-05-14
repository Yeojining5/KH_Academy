package com.day18;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;
// 듣고 말하기, 들은 것을 말하기 > 모두 톡서버스레드에서 구현한다
// 서버가 대화내용을 정해서 말하지 않는다

public class TalkServerThread extends Thread {
	// 이 소켓은 null이지만 생성자를 통해서 가져올 수 있다.
	Socket client = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	String nickName = null;
	TalkServer ts = null;
	// 파라미터에 선언된 객체는 TalkServer객체 주소번지를 갖는다.
	public TalkServerThread(TalkServer ts) {
		this.ts = ts;
		this.client = ts.client;
		try {
			oos = new ObjectOutputStream (client.getOutputStream()); // 전변으로 해서  oos 앞에 생략 가능
			ois = new ObjectInputStream (client.getInputStream());
			//100#nickName) // 클라이언트에서 이렇게 넘어온다. (숫자는 정해진 역할이 있음)
			String msg = (String)ois.readObject();
			oos.writeObject(msg);
			StringTokenizer st = new StringTokenizer(msg, "#");
			st.nextToken(); // 100
			nickName = st.nextToken();
			ts.jta_log.append(nickName+"님이 입장하였습니다.\n");
			ts.globalList.add(this); //현재 동작하는 스레드 - this, 스레드를 상속받음  // 자료구조는 톡서버에 있음
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// 현재 입장해 있는 친구들 모두에게 메세지 전송하기 구현
	public void broadCasting(String msg) {
		// 개선된 for문
		for(TalkServerThread tst:ts.globalList) {
			tst.send(msg);
		}
	}
	public void send(String msg) {
		try {
			oos.writeObject(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
