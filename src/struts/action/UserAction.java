package struts.action;

import hibernate.po.Productuser;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import spring.bo.UserManager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private String username;
	private String password;
	private String companyname;
	private String city;
	private String job;
	private String tel;
	private String email;
	private String country;
	private String zip;
	private String companyaddress;
	private String superuser;
	private String note;
	private String fullname;
	private String title;

	private UserManager um;

	public UserManager getUm() {
		return um;
	}

	public void setUm(UserManager um) {
		this.um = um;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCompanyaddress() {
		return companyaddress;
	}

	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}

	public String getSuperuser() {
		return superuser;
	}

	public void setSuperuser(String superuser) {
		this.superuser = superuser;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String execute() throws Exception {
		String loginstate = ServletActionContext.getRequest().getParameter("a");
		if (loginstate.equals("all"))// 为退出系统动作
		{
			return this.findAllUser();
		}
		if (loginstate.equals("regis"))// 为退出系统动作
		{
			return this.addUser();
		}
		if (loginstate.equals("finduser"))// 查找用户
		{
			return this.findProductUserbyid();
		}
		if (loginstate.equals("update"))// 更新用户信息
		{
			return this.updateProductUser();
		}
		if (loginstate.equals("updatesuper"))// 更新用户信息
		{
			return this.updateUserSuper();
		}
		if (loginstate.equals("delsuser"))// 更新用户信息
		{
			return this.delSoftUser();
		}
		return ERROR;
	}

	private String findAllUser() {
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		List allProductList = um.getAllProductUser();
		session.put("allproductlist", allProductList);
		return "all";
	}

	private String delSoftUser() {
		String userid = ServletActionContext.getRequest().getParameter("uid");
		String valuea = ServletActionContext.getRequest().getParameter("value");
		int a = Integer.valueOf(valuea);
		int uid = Integer.valueOf(userid);
		Productuser user = um.getProductUserByid(Integer.valueOf(uid));
		user.setDelFlag(a);
		um.updateProductuser(user);
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		List allProductList = um.getAllProductUser();
		session.put("allproductlist", allProductList);
		return "delsuser";
	}

	private String updateUserSuper() {
		String userid = ServletActionContext.getRequest().getParameter("uid");
		String supers = ServletActionContext.getRequest().getParameter(
				"superuser");
		int uid = Integer.valueOf(userid);
		Productuser user = um.getProductUserByid(Integer.valueOf(uid));
		user.setSuperuser(supers);
		um.updateProductuser(user);
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		List allProductList = um.getAllProductUser();
		session.put("allproductlist", allProductList);
		return "updatesuper";
	}

	private String updateProductUser() {
		String uid = ServletActionContext.getRequest().getParameter("uid");
		Productuser user = um.getProductUserByid(Integer.valueOf(uid));
		user.setCity(city);
		user.setUsername(username);
		user.setFullname(fullname);
		user.setTitle(title);
		user.setTel(tel);
		user.setPassword(password);
		user.setZip(zip);
		user.setJob(job);
		user.setEmail(email);
		user.setCountry(country);
		user.setCompanyname(companyname);
		user.setCompanyaddress(companyaddress);
		user.setNote(note);
		um.updateProductuser(user);
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		List allProductList = um.getAllProductUser();
		session.put("allproductlist", allProductList);
		return "update";
	}

	private String findProductUserbyid() {
		String userid = ServletActionContext.getRequest().getParameter("uid");
		int uid = Integer.valueOf(userid);
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		Productuser user = um.getProductUserByid(uid);
		session.put("UID_Productuser", user);
		return "finduser";
	}

	private String addUser() {
		Productuser user = um.findProductUserByusername(username);
		if (user != null) {
			this.addActionError("regist_tip.username.used");// "您使用的用户名已经被占用了，请重新注册"
		} else {
			user = new Productuser(username, password, companyname, city, job,
					tel, email, country, zip, companyaddress, "1");
			Integer id = um.addProductUser(user);
			if (id > 0) {
				return "regis";
			}
		}
		return ERROR;

	}
}
