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
		if (state.equals("all"))// ����ǲ�ѯ��Ʒ�������ѯҵ�񡣣�all��ʾ��ѯ���У�
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
			String dthtml = "����Ա��û�������ʼ�"; // ����Ա���仹û���ù����������������ò���
			ServletActionContext.getResponse().setContentType(
					"text/html; charset=gb2312");
			try {
				ServletActionContext.getResponse().getOutputStream().print(
						dthtml);
			} catch (IOException e) {
				e.printStackTrace();
			}// ����name�� ҳ�棻
		} else {
			String faddress = mail.getFromaddress();
			String taddress = mail.getToaddress();
			String dthtml = "������ַ��" + faddress + "<br>�ռ���ַ��" + taddress
					+ "<br>������޸ģ����������Ĳ���";
			ServletActionContext.getResponse().setContentType(
					"text/html; charset=gb2312");
			try {
				ServletActionContext.getResponse().getOutputStream().print(
						dthtml);
			} catch (IOException e) {
				e.printStackTrace();
			}// ����name�� ҳ�棻
		}
	}

	private void findMail() {

	}
}
