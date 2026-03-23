package com.ssafy.ws.step5;

public class User {
	private int userSeq;
	private String userId;
	private String password;
	private String userName;
	private String nickName;
	private String email;

	public User(int userSeq, String userId, String password, String userName, String nickName, String email) {
		this.userSeq = userSeq;
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.nickName = nickName;
		this.email = email;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getNickName() {
		return nickName;
	}

	@Override
	public String toString() {
		return userSeq + " | " + userId + " | " + nickName;
	}
}