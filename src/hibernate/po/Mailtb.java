package hibernate.po;

/**
 * Mailtb entity. @author MyEclipse Persistence Tools
 */

public class Mailtb implements java.io.Serializable {

	// Fields

	private Integer mid;
	private String fromaddress;
	private String frompassword;
	private String toaddress;
	private String temp1;
	private String temp2;
	private String temp3;
	private String temp4;

	// Constructors

	/** default constructor */
	public Mailtb() {
	}

	/** full constructor */
	public Mailtb(String fromaddress, String frompassword, String toaddress,
			String temp1, String temp2, String temp3, String temp4) {
		this.fromaddress = fromaddress;
		this.frompassword = frompassword;
		this.toaddress = toaddress;
		this.temp1 = temp1;
		this.temp2 = temp2;
		this.temp3 = temp3;
		this.temp4 = temp4;
	}

	public Mailtb(String fromaddress, String frompassword,
			String toaddress) {
		super();
		this.fromaddress = fromaddress;
		this.frompassword = frompassword;
		this.toaddress = toaddress;
	}

	// Property accessors

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getFromaddress() {
		return this.fromaddress;
	}

	public void setFromaddress(String fromaddress) {
		this.fromaddress = fromaddress;
	}

	public String getFrompassword() {
		return this.frompassword;
	}

	public void setFrompassword(String frompassword) {
		this.frompassword = frompassword;
	}

	public String getToaddress() {
		return this.toaddress;
	}

	public void setToaddress(String toaddress) {
		this.toaddress = toaddress;
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