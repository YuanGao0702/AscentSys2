package spring.bo;

import hibernate.po.Productuser;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface OrderManager {
	public String saveOrder(Collection con, Productuser pu);

	// 查找注册用户的订单
	public List findOrderList(int uid);

	// 查找所有订单
	public List findOrderAllList();

	public List findOrderItem(int orderid);

	// 删除订单里的商品信息
	public void delOrderItem(int pid, int orderid);

	// 删除订单(永久删除)
	public void delOrder(int orderid);

	// 删除订单(永久删除)
	public void delOrdersoft(int orderid);
}
