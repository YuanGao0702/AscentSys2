package spring.boimpl;

import hibernate.dao.UserDao;
import hibernate.po.Productuser;

import java.util.List;

import spring.bo.LoginManager;

public class LoginManagerImpl implements LoginManager {

	private UserDao ud;

	public UserDao getUd() {
		return ud;
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	public List getAllUser() {
		List users = this.ud.findAllUser();
		return users;
	}

	public Productuser login(String username, String password) {
		Productuser user = this.ud.findUserByUsernameAndPassword(username,
				password);
		if (user != null && user.getUid() > 0) {
			return user;
		}
		return null;
	}

}
