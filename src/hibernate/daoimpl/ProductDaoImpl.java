package hibernate.daoimpl;

import hibernate.dao.ProductDao;
import hibernate.po.Product;
import hibernate.po.Productuser;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {

	public void addProduct(Product pdt) {
		HibernateTemplate template = this.getHibernateTemplate();
		template.save(pdt);
	}

	public List findAllProduct() {
		HibernateTemplate template = this.getHibernateTemplate();
		List products = template
				.find("from hibernate.po.Product p where p.delFlag=1");
		return products;
	}

	public void updateProduct(Product pdt) {
		HibernateTemplate template = this.getHibernateTemplate();
		template.update(pdt);
	}

	public void delProduct(Product pdt) {
		HibernateTemplate template = this.getHibernateTemplate();
		pdt.setDelFlag(0);
		template.update(pdt);
	}

	public Product findProcuctById(Integer pid) {
		HibernateTemplate template = this.getHibernateTemplate();
		List products = template.find(
				"from hibernate.po.Product p where p.pid=?",
				new Object[] { pid });
		if (products != null && products.size() > 0) {
			return (Product) products.get(0);
		}
		return null;
	}

	public List searchProducts(String searchName, String searchValue) {
		HibernateTemplate template = this.getHibernateTemplate();
		List products = template.find("from hibernate.po.Product p where p."
				+ searchName + " like '%" + searchValue + "%' and p.delFlag=1");
		products.get(100);
		return products;
	}
}
