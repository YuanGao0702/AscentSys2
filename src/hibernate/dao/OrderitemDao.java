package hibernate.dao;

import java.util.List;

public interface OrderitemDao {
	
	public List findOrderitem(Integer orderid);

	public void delOrderItem(int pid, int orderid);
	
}
