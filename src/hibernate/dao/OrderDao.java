package hibernate.dao;

import hibernate.po.Orders;
import hibernate.po.Product;
import hibernate.po.Productuser;

import java.util.Collection;
import java.util.List;

public interface OrderDao {
	
	public List findOrdersByUid(Integer uid);
	
	public Orders findOrdersById(Integer id);

	public List findAllOrders();

	public void delOrders(Orders orders);

	public void addOrders(Orders orders);

	public void updateOrders(Orders orders);

	public void saveOrder(Collection con, Productuser pu);
}
