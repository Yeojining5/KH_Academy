package com.day20;

import java.net.ServerSocket;
import java.net.Socket;
// 1) 서버가 먼저 기동되어야 한다 - new ServerSocket(포트번호) 생성하기
// 3) 서버는 accept() 한다 - 서버에 접속한 소켓의 정보를 받는다.
public class NetworkServer {
	public void serverUp() {
		int port = 3000;
		ServerSocket server = null;
		try {
			server = new ServerSocket(port); // 서버소켓 생성, 포트번호를 열어둠(대문을 연다)
			// 서버소켓은 접대를 하는 역할 / 소켓은 그냥 일을 하는 역할
			System.out.println("server : "+server);
			while(true) { // while문을 통해 대기
				// accept 메소드를 통해서 서버쪽에 들어온 클라이언트 정보를 받을 수 있음
				Socket client = server.accept(); // 클라이언트 소켓 정보를 받는다
				System.out.println("client socket : "+client);
			}
		} catch (Exception e) {
			e.printStackTrace(); // 라인번호와 함께 메시지 출력 (디버깅 필수 메소드)
		}
	}
	public static void main(String[] args) {
		NetworkServer ns = new NetworkServer();
		ns.serverUp();
	}
}
// 출력
// server : ServerSocket[addr=0.0.0.0/0.0.0.0,localport=3000]
// client socket : Socket[addr=/192.168.0.4,port=54934,localport=3000]