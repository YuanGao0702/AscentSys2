package hibernate.daoimpl;

import hibernate.dao.OrderDao;
import hibernate.po.Orderitem;
import hibernate.po.Orders;
import hibernate.po.Product;
import hibernate.po.Productuser;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

	public List findOrdersByUid(Integer uid) {
		HibernateTemplate template = this.getHibernateTemplate();
		List orders = template
				.find(
						"from hibernate.po.Orders o where o.productuser.id=? and o.delsoft=1 order by o.orderid desc",
						new Object[] { uid });
		if (orders != null && orders.size() > 0) {
			return orders;
		}
		return null;
	}

	public void addOrders(Orders orders) {
		HibernateTemplate template = this.getHibernateTemplate();
		template.save(orders);
	}

	public void delOrders(Orders orders) {
		HibernateTemplate template = this.getHibernateTemplate();
		template.delete(orders);
	}

	public List findAllOrders() {
		HibernateTemplate template = this.getHibernateTemplate();
		List orders = (List) template.find("from hibernate.po.Orders");
		return orders;
	}

	public void updateOrders(Orders orders) {
		HibernateTemplate template = this.getHibernateTemplate();
		template.update(orders);
	}

	public Orders findOrdersById(Integer id) {
		HibernateTemplate template = this.getHibernateTemplate();
		List orders = template.find(
				"from hibernate.po.Orders o where o.orderid=?",
				new Object[] { id });
		if (orders != null && orders.size() > 0) {
			return (Orders) orders.get(0);
		}
		return null;
	}

	public void saveOrder(Collection con, Productuser pu) {
		Orders orders = new Orders();// 订单
		orders.setProductuser(pu); //
		// 已当前时间为保存订单的时间
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		orders.setDatetime(dateString);
		orders.setDelsoft("1");

		for (Iterator iterator = con.iterator(); iterator.hasNext();) {
			Orderitem oi = new Orderitem();
			Product pdt = (Product) iterator.next();
			oi.setProduct(pdt);
			oi.setQuantity(pdt.getQuantity());
			orders.getOrderitems().add(oi);
		}
		HibernateTemplate template = this.getHibernateTemplate();
		template.save(orders);

	}

}
