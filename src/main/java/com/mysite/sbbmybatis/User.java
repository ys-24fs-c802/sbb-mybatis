package com.mysite.sbbmybatis;

import java.time.LocalDateTime;

public class User {
	private Integer id;
	private String username;
	private String psw;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	// 생성자
	public User() {}
	public User(String username) {
		super();
		this.username = username;
	}
	public User(String username, String psw) {
		super();
		this.username = username;
		this.psw = psw;
	}
}
