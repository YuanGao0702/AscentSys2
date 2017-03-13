package hibernate.daoimpl;

import hibernate.dao.OrderitemDao;
import hibernate.po.Orderitem;
import hibernate.po.Orders;
import hibernate.po.Product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class OrderitemDaoImpl extends HibernateDaoSupport implements
		OrderitemDao {

	public List findOrderitem(Integer orderid) {
		List orderitems = new ArrayList();
		HibernateTemplate template = this.getHibernateTemplate();
		try {
			orderitems = template
					.find(
							"from hibernate.po.Orderitem item where item.orders.orderid=?",
							new Object[] { orderid });
		} catch (Exception e) {
			System.out.println("null!!!!!!!!!!");
		}
		return orderitems;
	}

	public void delOrderItem(int pid, int orderid) {
		HibernateTemplate template = this.getHibernateTemplate();
		List orderitems = template
				.find(
						"from hibernate.po.Orderitem item where item.orders.orderid=? and item.product.pid=?",
						new Object[] { orderid, pid });
		if (orderitems != null && orderitems.size() > 0) {
			Orderitem item = (Orderitem) orderitems.get(0);
			template.delete(item);
		}

	}

}
