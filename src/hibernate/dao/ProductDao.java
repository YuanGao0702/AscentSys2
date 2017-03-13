package hibernate.dao;

import hibernate.po.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {

	public List findAllProduct();

	public void delProduct(Product pdt);

	public void addProduct(Product pdt);

	public void updateProduct(Product pdt);

	public List searchProducts(String searchName, String searchValue);

	public Product findProcuctById(Integer pid);
}
