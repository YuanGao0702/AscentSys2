package struts.action;

import hibernate.po.Mailtb;
import hibernate.po.Productuser;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import spring.bo.MailManager;
import spring.bo.OrderManager;
import spring.bo.UserManager;
import util.SendMail;
import util.ShopCart;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {

	private OrderManager om;
	private UserManager um;
	private MailManager mm;

	private String username;
	private String tel;
	private String email;
	private String companyname;
	private String companyaddress;

	public MailManager getMm() {
		return mm;
	}

	public void setMm(MailManager mm) {
		this.mm = mm;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCompanyaddress() {
		return companyaddress;
	}

	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}

	public UserManager getUm() {
		return um;
	}

	public void setUm(UserManager um) {
		this.um = um;
	}

	public OrderManager getOm() {
		return om;
	}

	public void setOm(OrderManager om) {
		this.om = om;
	}

	@Override
	public String execute() throws Exception {
		String state = ServletActionContext.getRequest().getParameter("a");
		if (state.equals("checkout"))// ���ʵ�����
		{
			return this.saveOrders();
		}
		if (state.equals("all"))// ��ѯ���ж��������󣨹���Ա�û��鿴���ж�����
		{
			return this.findOrderAll();
		}
		if (state.equals("finditem"))// ���û����Ҷ�������ͨ�û��鿴�Լ��Ķ�����
		{
			return this.findOrderitem();
		}
		if (state.equals("delitem"))// ɾ��������Ĳ�Ʒ
		{
			return this.delOrderitem();
		}
		if (state.equals("delorder"))// ɾ������
		{
			return this.delOrder();
		}
		if (state.equals("lookuse"))// �鿴�û���Ϣ
		{
			return this.lookUser();
		}
		return this.ERROR;
	}

	private String saveOrders() {
		String content = "";// ��Ʒ����
		String message = "";// ���շ���message
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		Productuser pu = (Productuser) session.get("productuser");
		Collection con = (Collection) session.get("shopcartlist");// ��ȡ���ﳵ����
		if (pu == null)// Ϊ�ο�
		{
			pu = new Productuser();
			pu.setUid(0);
			pu.setUsername(username);
			pu.setTel(tel);
			pu.setEmail(email);
			pu.setCompanyname(companyname);
			pu.setCompanyaddress(companyaddress);
			content = this.om.saveOrder(con, pu);
			ServletActionContext.getRequest().setAttribute("error",
					"��Ķ����Ѿ����͵�����Ա����");
			return "checkout";
		} else if (pu != null)// Ϊע���û�
		{
			// ����û���ҳ�������޸ģ����޸���ϢΪ׼
			pu.setFullname(username);
			pu.setTel(tel);
			pu.setEmail(email);
			pu.setCompanyname(companyname);
			pu.setCompanyaddress(companyaddress);
			content = this.om.saveOrder(con, pu);// ���涩����Ϣ
			ServletActionContext.getRequest().setAttribute("error",
					"��Ķ����Ѿ����͵�����Ա����");
			return "checkout";
		}
		message = "<html xmlns='http://www.w3.org/1999/xhtml'> <head><meta http-equiv='Content-Type' content='text/html; charset=gb2312'/><style type='text/css'> <!-- <br> .table_cc {color:#FFFFFF; font-weight:bold; font-size:12px;} <br> .table_hei {font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#000000;} <br> .table_hui {font-family:Arial, Helvetica, sans-serif; font-size:12px; font-weight:bold; color:#666666;} --></style></head> <br> <body><table width='550' border='0' cellspacing='0'><tr> <td height='18' colspan='7' bgcolor='#1B83D8'><div align='center' class='table_cc'><div align='left'>��Ʒ��Ϣ</div> </div></td></tr> <tr> <td width='71' height='26' bgcolor='#FFFFFF' class='table_hui'>��catalogno </td> <td width='100' bgcolor='#FFFFFF' class='table_hui'>���� </td><td width='107' bgcolor='#FFFFFF' class='table_hui'> cas </td><td width='64' bgcolor='#FFFFFF' class='table_hui'>formula</td><td width='82' bgcolor='#FFFFFF' class='table_hui'>�۸�</td><td width='59' height='26' bgcolor='#FFFFFF' class='table_hui'>���� </td></tr><br>"
				+ content
				+ " </table>     <table width='550' border='0'><tr> <td height='1' colspan='4' bgcolor='#8CC6FF'></td></tr><tr> <td height='17' colspan='4'  bgcolor='#1B83D8' class='table_cc'>�û���Ϣ </td></tr><tr><td width='78' height='30' bgcolor='#FFFFFF' class='table_hui'>&nbsp;</td><td width='91'class='table_hui'>�û����� </td><td width='365' bgcolor='#FFFFFF' class='table_hui'>"
				+ pu.getUsername()
				+ "</td></tr><tr><td width='78' height='23' bgcolor='#FFFFFF' class='table_hui'>&nbsp;</td>  <td width='91' height='23' class='table_hui'>�绰��</td><td width='365' bgcolor='#FFFFFF' class='table_hui'>"
				+ pu.getTel()
				+ "</td></tr><tr><td width='78' height='23' bgcolor='#FFFFFF' class='table_hui'>&nbsp;</td> <td width='91' height='23' class='table_hui'>Email:</td> <td width='365' class='table_hui'>"
				+ pu.getEmail()
				+ "</td></tr><tr> <td width='78' height='23' bgcolor='#FFFFFF' class='table_hui'>&nbsp;</td> <td width='91' height='23' class='table_hui'>��˾����:</td> <td width='365' class='table_hui'>"
				+ pu.getCompanyname()
				+ "</td></tr></table>  </div></div></body></html>";
		Mailtb mailtb = new Mailtb();
		mailtb = mm.findMail();
		if (mailtb != null) {
			String usrename = mailtb.getFromaddress().substring(0,
					mailtb.getFromaddress().indexOf("@"));
			SendMail sm = new SendMail();
			sm.sendMessage(mailtb.getFromaddress(), usrename, mailtb
					.getFrompassword(), mailtb.getToaddress(), email, message);
			ServletActionContext.getRequest().setAttribute("error",
					"��Ķ����Ѿ����͵�����Ա����");
		} else {
			// this.doError(request, response, "�ʼ�û������,�������Ա��ϵ");
		}
		// ������ﳵ
		ShopCart shopCart = (ShopCart) session.get("shopcart");
		shopCart.emptyCart();
		return ERROR;
	}

	private String delOrderitem() {
		String orderid = ServletActionContext.getRequest().getParameter("oid");
		String productid = ServletActionContext.getRequest()
				.getParameter("pid");
		int oid = Integer.valueOf(orderid);
		int pid = Integer.valueOf(productid);
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		this.om.delOrderItem(pid, oid);
		List productlist = this.om.findOrderItem(oid);
		session.put("orderitemlist", productlist);
		session.put("orderid", orderid);
		return "delitem";
	}

	private String lookUser() {
		String userid = ServletActionContext.getRequest().getParameter("uid");
		int uid = Integer.valueOf(userid);
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		Productuser ProductUser = this.um.getProductUserByid(uid);
		session.put("Orderuser", ProductUser);
		return "lookuse";
	}

	private String delOrder() {
		String orderid = ServletActionContext.getRequest().getParameter("oid");
		int oid = Integer.valueOf(orderid);
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		this.om.delOrder(oid);
		List orderlist = this.om.findOrderAllList();
		session.put("orderlist", orderlist);
		return "delorder";
	}

	private String findOrderitem() {
		String orderid = ServletActionContext.getRequest().getParameter("oid");
		int oid = Integer.valueOf(orderid);
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		List productlist = this.om.findOrderItem(oid);
		session.put("orderitemlist", productlist);
		session.put("orderid", orderid);
		return "finditem";
	}

	private String findOrderAll() {
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		Productuser pu = (Productuser) session.get("productuser");
		List orderlist = null;
		if (pu.getSuperuser().equals("3")) {
			orderlist = om.findOrderAllList();
			session.put("orderlist", orderlist);
			return "admin_all";
		} else {
			orderlist = om.findOrderList(pu.getUid());
			session.put("orderlist", orderlist);
			return "user_all";
		}
	}
}
