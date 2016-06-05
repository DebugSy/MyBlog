package cn.symxl.action;

import com.opensymphony.xwork2.ActionSupport;
import cn.symxl.bean.User;
import cn.symxl.dao.SelectDao;

public class Login extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login() {
		System.out.println("’À∫≈"+user.getUsername());
		System.out.println("√‹¬Î"+user.getPassword());
		SelectDao selectDao = new SelectDao();
		
		User realuser = selectDao.select(user.getUsername());
		System.out.println("≤È—Ø"+realuser.getUsername());
		if (user.getUsername() != null
				&& user.getUsername().equals(realuser.getUsername())
				&& user.getPassword().equals(realuser.getPassword())) {
			return SUCCESS;
		}
		return ERROR;
	}
	
}
