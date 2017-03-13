package spring.bo;

import hibernate.po.Product;
import hibernate.po.Productuser;

import java.sql.SQLException;
import java.util.List;

public interface ProductManager {

	public List getAllProduct();

	public Product getProductByPid(int pid);

	public void delProductByPid(int pid);

	public void saveProduct(Product pdt);

	public void updateProduct(Product pdt);

	public List searchProcuct(String searchNames, String searchValues);
}
