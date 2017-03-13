package spring.boimpl;

import hibernate.dao.OrderDao;
import hibernate.dao.OrderitemDao;
import hibernate.dao.ProductDao;
import hibernate.po.Orders;
import hibernate.po.Product;
import hibernate.po.Productuser;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import spring.bo.OrderManager;

public class OrderManagerImpl implements OrderManager {

	private OrderDao od;
	private OrderitemDao oid;
	private ProductDao pd;

	public ProductDao getPd() {
		return pd;
	}

	public void setPd(ProductDao pd) {
		this.pd = pd;
	}

	public OrderitemDao getOid() {
		return oid;
	}

	public void setOid(OrderitemDao oid) {
		this.oid = oid;
	}

	public OrderDao getOd() {
		return od;
	}

	public void setOd(OrderDao od) {
		this.od = od;
	}

	public void delOrder(int orderid) {
		Orders order = this.od.findOrdersById(orderid);
		this.od.delOrders(order);

	}

	public void delOrderItem(int pid, int orderid) {
		this.oid.delOrderItem(pid, orderid);
	}

	public void delOrdersoft(int orderid) {

	}

	public List findOrderAllList() {
		List orders = (List) this.od.findAllOrders();
		return orders;
	}

	public List findOrderItem(int orderid) {
		return this.oid.findOrderitem(orderid);
	}

	public List findOrderList(int uid) {
		return this.od.findOrdersByUid(uid);
	}

	public String saveOrder(Collection con, Productuser pu) {
		this.od.saveOrder(con, pu);
		for (Iterator iterator = con.iterator(); iterator.hasNext();) {
			Product p = (Product) iterator.next();
//			System.out.println(p.getCatalogno()+":"+p.getRealstock()+":"+p.getQuantity());
			int newRealStock = Integer.parseInt(p.getRealstock())-Integer.parseInt(p.getQuantity());
			p.setRealstock(""+newRealStock);
			pd.updateProduct(p);
		}
		return "s";
	}

}
