package com.day20;

import java.net.InetAddress;
import java.net.Socket;
// 2) 클라이언트가 접속을 시도한다 - new Socket(ip, port)
public class NetworkClient {
	public void client_connect() {
		int port = 3000;
		String serverIP = "127.0.0.1";
		try {
			serverIP = InetAddress.getLocalHost().getHostAddress();
			// 클라이언트측에서 아래 인스턴스화가 실행되면 ServerSocket 에 정보가 전달됨 - 접속이됨
			Socket socket = new Socket(serverIP, port); // 소켓 생성
			System.out.println("serverIP : "+serverIP);
			System.out.println("Networkclient socket : "+socket);
		} catch (Exception e) {
			System.out.println("Exception : "+ e.getMessage());
		}
	}
	public static void main(String[] args) {
		NetworkClient nc = new NetworkClient();
		nc.client_connect();

	}

}
