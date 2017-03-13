package spring.bo;

import hibernate.po.Productuser;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface OrderManager {
	public String saveOrder(Collection con, Productuser pu);

	// ����ע���û��Ķ���
	public List findOrderList(int uid);

	// �������ж���
	public List findOrderAllList();

	public List findOrderItem(int orderid);

	// ɾ�����������Ʒ��Ϣ
	public void delOrderItem(int pid, int orderid);

	// ɾ������(����ɾ��)
	public void delOrder(int orderid);

	// ɾ������(����ɾ��)
	public void delOrdersoft(int orderid);
}
