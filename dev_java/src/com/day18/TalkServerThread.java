package com.day18;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class TalkServerThread extends Thread {
	// 이 소켓은 null이지만 생성자를 통해서 가져올 수 있다.
	Socket client = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	String nickName = null;
	// 파라미터에 선언된 객체는 TalkServer객체 주소번지를 갖는다.
	public TalkServerThread(TalkServer ts) {
		this.client = ts.client;
		try {
			oos = new ObjectOutputStream (client.getOutputStream()); // 전변으로 해서  oos 앞에 생략 가능
			ois = new ObjectInputStream (client.getInputStream());
			//100#nickName) // 클라이언트에서 이렇게 넘어온다. (숫자는 정해진 역할이 있음)
			String msg = (String)ois.readObject();
			StringTokenizer st = new StringTokenizer(msg, "#");
			st.nextToken(); // 100
			nickName = st.nextToken();
			ts.jta_log.append(nickName+"님이 입장하였습니다.\n");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
}
