package hibernate.po;

import java.util.HashSet;
import java.util.Set;

/**
 * Orderitem entity. @author MyEclipse Persistence Tools
 */

public class Orderitem implements java.io.Serializable {

	// Fields

	private Integer id;
	private Orders orders;
	private Product product;
	private String quantity;
	private String temp1;
	private String temp2;
	private String temp3;
	private String temp4;

	// Constructors

	/** default constructor */
	public Orderitem() {
	}

	/** full constructor */

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public Orderitem(Orders orders, Product product, String quantity) {
		super();
		this.orders = orders;
		this.product = product;
		this.quantity = quantity;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
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

}