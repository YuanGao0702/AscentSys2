package spring.boimpl;

import java.sql.SQLException;
import java.util.List;

import hibernate.dao.ProductDao;
import hibernate.daoimpl.UserDaoImpl;
import hibernate.po.Orders;
import hibernate.po.Product;
import hibernate.po.Productuser;
import spring.bo.ProductManager;
import spring.bo.UserManager;

public class ProductManagerImpl implements ProductManager {

	private ProductDao pd;

	public ProductDao getPd() {
		return pd;
	}

	public void setPd(ProductDao pd) {
		this.pd = pd;
	}

	public void delProductByPid(int pid) {
		Product product = this.pd.findProcuctById(pid);
		this.pd.delProduct(product);
	}

	public List getAllProduct() {
		List products = this.pd.findAllProduct();
		return products;
	}

	public Product getProductByPid(int pid) {
		Product product = this.pd.findProcuctById(pid);
		return product;
	}

	public void saveProduct(Product pdt) {
		this.pd.addProduct(pdt);
	}

	public void updateProduct(Product pdt) {
		this.pd.updateProduct(pdt);
	}

	public List searchProcuct(String searchName, String searchValue) {
		return this.pd.searchProducts(searchName, searchValue);
	}

}
