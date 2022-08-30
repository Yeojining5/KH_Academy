package com.web.entity;

import java.sql.Date;

public class Notice {
	private int id;
	private String title;
	private Date regdate;
	private String writerId;
	private String hit;
	private String files;
	private String content;
	
	// 기본생성자는 JVM이 자동생성해 주지 않으므로 수동 생성! (Ctrl+Shift)
	public Notice() {
		// TODO Auto-generated constructor stub
	}
	
	public Notice(int id, String title, Date regdate, String writerId, String hit, String files, String content) {
		this.id = id;
		this.title = title;
		this.regdate = regdate;
		this.writerId = writerId;
		this.hit = hit;
		this.files = files;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", regdate=" + regdate + ", writerId=" + writerId + ", hit="
				+ hit + ", files=" + files + ", content=" + content + "]";
	}

	
	
}
