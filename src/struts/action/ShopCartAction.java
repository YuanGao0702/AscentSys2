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
		if (state.equals("add"))// 向购物车添加产品动作
		{
			return this.addtoShopCart();
		}
		if (state.equals("find"))// 查找购物车添加产品动作
		{
			return this.findShopCart();
		}
		if (state.equals("checkout"))// 结帐
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
		boolean bl = ShopCart.checkHashMapid(pid);// 判断购物车是否已经添加
		System.out.println(bl + " --------------");
		String dthtml;
		if (bl)// 该产品已经添加
		{
			// Ajax返回该商品已经添加过的提示
			dthtml = "该产品已经保存在购物车里";// "该商品已经添加过";
		} else// 没有添加
		{
			Product product = this.pm.getProductByPid(ppid);
			product.setQuantity("5");
			ShopCart.addProduct(pid, product);
			dthtml = "药品添加成功";// "该商品已经添加过";
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
			dthtml = "库存不足！";
		} else {
			dthtml = "该产数量品已经修改";
		}
		// Ajax返回该商品已经添加过的提示
		// String dthtml = "该产品已经修改";// "该商品已经添加过";
		// response.setContentType("text/html;charset=gb2312");
		
		System.out.println(dthtml);
		try {
			ServletActionContext.getResponse().setContentType(
					"text/html;charset=gb2312");
			ServletActionContext.getResponse().getWriter().write(dthtml);
		} catch (IOException e) {
			e.printStackTrace();
		}// 返回页面
		return null;
	}

	private String delShopCartProduct() {
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		ShopCart ShopCart = (ShopCart) session.get("shopcart");
		String pid = ServletActionContext.getRequest().getParameter("pid");
		ShopCart.removeHashMap(pid);
		Collection ShopCartlist = ShopCart.getHashmap().values();// 返回购物车里value的视图（collection）
		session.put("shopcartlist", ShopCartlist);
		return "move";
	}

	private String checkout() {
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		ShopCart ShopCart = (ShopCart) session.get("shopcart");
		Collection ShopCartlist = ShopCart.getHashmap().values();// 返回购物车里value的视图（collection）
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
		Collection ShopCartlist = ShopCart.getHashmap().values();// 返回购物车里value的视图（collection）
		session.put("shopcartlist", ShopCartlist);
		return "find";
	}
}
