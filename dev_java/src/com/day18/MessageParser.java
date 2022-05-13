package com.day18;

import java.util.StringTokenizer;

public class MessageParser {

	public static void main(String[] args) {
		String msg = "200#tomato#banana#오늘 스터디할까?";
		//String msg = "100#tomato"; //  클라이언트에서 이렇게 메세지가 넘어옴. 토마토가 입장함
		StringTokenizer st = new StringTokenizer(msg, "#");
			//String protocol = st.nextToken();
			//String nickName = st.nextToken();
			//String toName = st.nextToken();
			//String message = st.nextToken();
			//System.out.println(protocol);
			//System.out.println(nickName);
		/////////////위 주석들이 아래 while문으로 간단하게 끝이난다!!
		while(st.hasMoreTokens()) {
			String imsi = st.nextToken();
			System.out.println(imsi);
		}
	}

}
