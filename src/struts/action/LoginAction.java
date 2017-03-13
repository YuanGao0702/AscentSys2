package struts.action;

import hibernate.po.Productuser;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import spring.bo.LoginManager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;

	private LoginManager lm;

	public LoginManager getLm() {
		return lm;
	}

	public void setLm(LoginManager lm) {
		this.lm = lm;
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

	public String execute() throws Exception {
		String loginstate = ServletActionContext.getRequest().getParameter("a");
		if (loginstate.equals("out")) {
			return this.loginOut();
		}
		if (loginstate.equals("login")) {
			return this.userLogin();
		}
		return ERROR;
	}

	private String loginOut() {
		ActionContext.getContext().getSession().clear();
		return this.INPUT;
	}

	public String userLogin() {
		Productuser user = this.lm.login(username, password);
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		session.put("productuser", user);
		session.put("info", "");
		if (user != null) {
			if (user.getDelFlag() == 0) {
				session.put("info", "用户已被删除");
				return INPUT;
			}
			if (user.getSuperuser().equals("1")) {
				return "user";
			} else if (user.getSuperuser().equals("3")) {// admin 因为第一次来此页面
				List allProductList = this.lm.getAllUser();
				session.put("allproductlist", allProductList);
				return "admin";
			}
		}
		session.put("info", "用户名或密码错误");
		return INPUT;
	}
}
