package hibernate.po;

import java.util.HashSet;
import java.util.Set;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer orderid;
	private Productuser productuser;
	private String temp1;
	private String temp2;
	private String temp3;
	private String temp4;
	private String datetime;
	private String delsoft;
	private Set orderitems = new HashSet(0);

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** full constructor */

	public Integer getOrderid() {
		return this.orderid;
	}

	public Orders(Productuser productuser, String datetime,
			String delsoft, Set orderitems) {
		super();
		this.productuser = productuser;
		this.datetime = datetime;
		this.delsoft = delsoft;
		this.orderitems = orderitems;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Productuser getProductuser() {
		return productuser;
	}

	public void setProductuser(Productuser productuser) {
		this.productuser = productuser;
	}

	public Set getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}

	public String getTemp1() {
		return this.temp1;
	}

	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}

	public String getTemp2() {
		return this.temp2;
	}

	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}

	public String getTemp3() {
		return this.temp3;
	}

	public void setTemp3(String temp3) {
		this.temp3 = temp3;
	}

	public String getTemp4() {
		return this.temp4;
	}

	public void setTemp4(String temp4) {
		this.temp4 = temp4;
	}

	public String getDatetime() {
		return this.datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getDelsoft() {
		return this.delsoft;
	}

	public void setDelsoft(String delsoft) {
		this.delsoft = delsoft;
	}

}