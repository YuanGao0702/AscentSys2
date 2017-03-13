package struts.action;

import java.io.IOException;

import hibernate.po.Mailtb;

import org.apache.struts2.ServletActionContext;

import spring.bo.MailManager;

import com.opensymphony.xwork2.ActionSupport;

public class MailAction extends ActionSupport {

	private MailManager mm;

	private String fromaddress;
	private String frompassword;
	private String toaddress;

	public MailManager getMm() {
		return mm;
	}

	public void setMm(MailManager mm) {
		this.mm = mm;
	}

	@Override
	public String execute() throws Exception {
		String state = ServletActionContext.getRequest().getParameter("a");
		if (state.equals("all"))// 如果是查询产品，处理查询业务。（all表示查询所有）
		{
			this.findMail();
		}
		if (state.equals("save")) {
			this.saveMail();

		}
		return ERROR;
	}

	private void saveMail() {
		Mailtb mail = this.mm.findMail();
		if (mail == null) {
			String dthtml = "管理员还没有设置邮件"; // 管理员邮箱还没设置过，请进行下面的设置操作
			ServletActionContext.getResponse().setContentType(
					"text/html; charset=gb2312");
			try {
				ServletActionContext.getResponse().getOutputStream().print(
						dthtml);
			} catch (IOException e) {
				e.printStackTrace();
			}// 返回name到 页面；
		} else {
			String faddress = mail.getFromaddress();
			String taddress = mail.getToaddress();
			String dthtml = "发件地址：" + faddress + "<br>收件地址：" + taddress
					+ "<br>如果想修改，请进行下面的操作";
			ServletActionContext.getResponse().setContentType(
					"text/html; charset=gb2312");
			try {
				ServletActionContext.getResponse().getOutputStream().print(
						dthtml);
			} catch (IOException e) {
				e.printStackTrace();
			}// 返回name到 页面；
		}
	}

	private void findMail() {

	}
}
