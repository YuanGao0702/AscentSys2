package spring.bo;

import hibernate.po.Productuser;

import java.util.List;

public interface UserManager {

	public Productuser getProductUserByid(int uid);

	public Productuser findProductUserByusername(String username);

	public Integer addProductUser(Productuser user);

	public void updateProductuser(Productuser user);

	public void delSoftuser(int uid, int a);

	public List getAllProductUser();
}
