package com.mvc.step1;

public class Pattern {

	public static void main(String[] args) {
		String uri = "/pay/payManager.gym";
		String uri2 = "/dev_web/pay/payManager.gym";
		String context = "";
		String context2 = "dev_web/";
		String command = uri.substring(context.length()+1);
		int end = command.lastIndexOf(".");
		command = command.substring(0, end);
		String upmu[] = null;
		upmu = command.split("/");
		for(String imsi:upmu) {
			System.out.println(imsi); // pay, payManager
		}
	}

}
