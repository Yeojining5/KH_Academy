package com.mvc.step1;

public class ActionForward {
	private String path = null;
	private boolean isRedirect = false;//true: sendRedirect, false: forward
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
