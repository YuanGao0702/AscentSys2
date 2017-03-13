package hibernate.dao;

import hibernate.po.Productuser;

import java.util.List;

public interface UserDao {
	
	public Integer addUser(Productuser user);
	
	public void updateUser(Productuser user);
	
	public Productuser findUserByUsername(String username);
	
	public Productuser findUserById(Integer id);
	
	public Productuser findUserByUsernameAndPassword(String username,String password);
	
	public List findAllUser();
	
}
