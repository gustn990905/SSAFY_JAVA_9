package com.ssafy.ws.step5;

public interface IUserManager {

	User getLoginUser();

	void signup(User user) throws UserIdDuplicateException;

	User login(String id, String password) throws LoginException;

	void logout();

	User getUser(int userSeq);

	User getUser(String nickName);
}