package com.ssafy.ws.step5;

import java.util.*;

public class UserManagerImpl implements IUserManager {

	private List<User> users = new ArrayList<>();
	private User loginUser;

	private static IUserManager instance = new UserManagerImpl();

	private UserManagerImpl() {
	}

	public static IUserManager getInstance() {
		return instance;
	}

	@Override
	public User getLoginUser() {
		return loginUser;
	}

	@Override
	public void signup(User user) throws UserIdDuplicateException {
		for (User u : users) {
			if (u.getUserId().equals(user.getUserId()))
				throw new UserIdDuplicateException(user.getUserId());
		}
		users.add(user);
	}

	@Override
	public User login(String id, String password) throws LoginException {
		for (User u : users) {
			if (u.getUserId().equals(id) && u.getPassword().equals(password)) {
				loginUser = u;
				return u;
			}
		}
		throw new LoginException();
	}

	@Override
	public void logout() {
		loginUser = null;
	}

	@Override
	public User getUser(int userSeq) {
		for (User u : users) {
			if (u.getUserSeq() == userSeq)
				return u;
		}
		return null;
	}

	@Override
	public User getUser(String nickName) {
		for (User u : users) {
			if (u.getNickName().equals(nickName))
				return u;
		}
		return null;
	}
}