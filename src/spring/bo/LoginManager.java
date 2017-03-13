package spring.bo;

import hibernate.po.Productuser;

import java.util.List;

public interface LoginManager {
	public Productuser login(String user, String password);
	public List getAllUser();
}
