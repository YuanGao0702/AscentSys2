package spring.boimpl;

import java.util.List;

import hibernate.dao.UserDao;
import hibernate.po.Productuser;
import spring.bo.UserManager;

public class UserManagerImpl implements UserManager {

	private UserDao ud;

	public UserDao getUd() {
		return ud;
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	public Integer addProductUser(Productuser user) {
		return this.ud.addUser(user);
		
	}

	public void delSoftuser(int uid, int a) {
		// TODO Auto-generated method stub
		
	}

	public Productuser findProductUserByusername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getAllProductUser() {
		return this.ud.findAllUser();
	}

	public Productuser getProductUserByid(int uid) {
		return this.ud.findUserById(uid);
	}

	public void updateProductuser(Productuser pu) {
		this.ud.updateUser(pu);
	}

}
