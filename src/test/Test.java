package test;

import hibernate.daoimpl.OrderDaoImpl;
import hibernate.po.Orders;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {

		String[] xmls = new String[] { "action.xml", "bo.xml", "dao.xml",
				"sessionfactory.xml" };
		ApplicationContext ac = new ClassPathXmlApplicationContext(xmls);
		OrderDaoImpl od = (OrderDaoImpl) ac.getBean("orderdao");
		Orders o = od.findOrdersById(new Integer(15));
		od.delOrders(o);
	}
}
