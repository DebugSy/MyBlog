package cn.symxl.action;

import com.sun.net.httpserver.Authenticator.Success;

import cn.symxl.bean.User;

public class LoginError {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String execute() {
		// TODO Auto-generated method stub
		return "success";
	}
}
