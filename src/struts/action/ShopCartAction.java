package struts.action;

import hibernate.po.Product;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import spring.bo.ProductManager;
import util.ShopCart;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShopCartAction extends ActionSupport {

	private ProductManager pm;

	public ProductManager getPm() {
		return pm;
	}

	public void setPm(ProductManager pm) {
		this.pm = pm;
	}

	@Override
	public String execute() throws Exception {
		String state = ServletActionContext.getRequest().getParameter("a");
		if (state.equals("add"))// ���ﳵ��Ӳ�Ʒ����
		{
			return this.addtoShopCart();
		}
		if (state.equals("find"))// ���ҹ��ﳵ��Ӳ�Ʒ����
		{
			return this.findShopCart();
		}
		if (state.equals("checkout"))// ����
		{
			return this.checkout();
		}
		if (state.equals("move")) {
			return this.delShopCartProduct();
		}
		if (state.equals("updateNum")) {
			return this.updateCartProductNum();
		}

		return this.ERROR;
	}

	private String addtoShopCart() {
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		ShopCart ShopCart = (ShopCart) session.get("shopcart");
		if (ShopCart == null) {
			ShopCart = new ShopCart();
		}
		String pid = ServletActionContext.getRequest().getParameter("pid");
		int ppid = Integer.parseInt(pid);
		boolean bl = ShopCart.checkHashMapid(pid);// �жϹ��ﳵ�Ƿ��Ѿ����
		System.out.println(bl + " --------------");
		String dthtml;
		if (bl)// �ò�Ʒ�Ѿ����
		{
			// Ajax���ظ���Ʒ�Ѿ���ӹ�����ʾ
			dthtml = "�ò�Ʒ�Ѿ������ڹ��ﳵ��";// "����Ʒ�Ѿ���ӹ�";
		} else// û�����
		{
			Product product = this.pm.getProductByPid(ppid);
			product.setQuantity("5");
			ShopCart.addProduct(pid, product);
			dthtml = "ҩƷ��ӳɹ�";// "����Ʒ�Ѿ���ӹ�";
		}
		try {
			ServletActionContext.getResponse().setContentType(
					"text/html;charset=gb2312");
			ServletActionContext.getResponse().getWriter().write(dthtml);
		} catch (IOException e) {
			e.printStackTrace();
		}
		session.put("shopcart", ShopCart);
		return null;
	}

	private String updateCartProductNum() {
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		ShopCart ShopCart = (ShopCart) session.get("shopcart");
		String pid = ServletActionContext.getRequest().getParameter("pid");
		String number = ServletActionContext.getRequest().getParameter(
				"quantity");
		String realstock = ServletActionContext.getRequest().getParameter(
				"realstock");
		System.out.println("realstock"+realstock);

		int number1 = Integer.parseInt(number);
		int sum = Integer.parseInt(realstock);
		ShopCart.updateProductNumbedr(pid, number);
		String dthtml = "";
		if (number1 > sum) {
			dthtml = "��治�㣡";
		} else {
			dthtml = "�ò�����Ʒ�Ѿ��޸�";
		}
		// Ajax���ظ���Ʒ�Ѿ���ӹ�����ʾ
		// String dthtml = "�ò�Ʒ�Ѿ��޸�";// "����Ʒ�Ѿ���ӹ�";
		// response.setContentType("text/html;charset=gb2312");
		
		System.out.println(dthtml);
		try {
			ServletActionContext.getResponse().setContentType(
					"text/html;charset=gb2312");
			ServletActionContext.getResponse().getWriter().write(dthtml);
		} catch (IOException e) {
			e.printStackTrace();
		}// ����ҳ��
		return null;
	}

	private String delShopCartProduct() {
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		ShopCart ShopCart = (ShopCart) session.get("shopcart");
		String pid = ServletActionContext.getRequest().getParameter("pid");
		ShopCart.removeHashMap(pid);
		Collection ShopCartlist = ShopCart.getHashmap().values();// ���ع��ﳵ��value����ͼ��collection��
		session.put("shopcartlist", ShopCartlist);
		return "move";
	}

	private String checkout() {
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		ShopCart ShopCart = (ShopCart) session.get("shopcart");
		Collection ShopCartlist = ShopCart.getHashmap().values();// ���ع��ﳵ��value����ͼ��collection��
		session.put("shopcartlist", ShopCartlist);
		return "checkout";
	}

	private String findShopCart() {
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		ShopCart ShopCart = (ShopCart) session.get("shopcart");
		if (ShopCart == null) {
			ShopCart = new ShopCart();
		}
		Collection ShopCartlist = ShopCart.getHashmap().values();// ���ع��ﳵ��value����ͼ��collection��
		session.put("shopcartlist", ShopCartlist);
		return "find";
	}
}
