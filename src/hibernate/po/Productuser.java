package hibernate.po;

import java.util.HashSet;
import java.util.Set;

/**
 * Productuser entity. @author MyEclipse Persistence Tools
 */

public class Productuser implements java.io.Serializable {

	// Fields

	private Integer uid;
	private Set orders = new HashSet(0);
	private Set userproducts = new HashSet(0);
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
	private Integer delFlag;
	private String temp1;
	private String temp2;
	private String temp3;
	private String temp4;

	// Constructors

	/** default constructor */
	public Productuser() {
	}

	public Productuser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public Productuser(Set orders, Set userproducts, String username,
			String password, String companyname, String city, String job,
			String tel, String email, String country, String zip,
			String companyaddress, String superuser, String note,
			String fullname, String title, Integer delFlag) {
		super();
		this.orders = orders;
		this.userproducts = userproducts;
		this.username = username;
		this.password = password;
		this.companyname = companyname;
		this.city = city;
		this.job = job;
		this.tel = tel;
		this.email = email;
		this.country = country;
		this.zip = zip;
		this.companyaddress = companyaddress;
		this.superuser = superuser;
		this.note = note;
		this.fullname = fullname;
		this.title = title;
		this.delFlag = delFlag;
	}

	public Productuser(String username, String password, String companyname,
			String city, String job, String tel, String email, String country,
			String zip, String companyaddress, String superuser) {
		super();
		this.username = username;
		this.password = password;
		this.companyname = companyname;
		this.city = city;
		this.job = job;
		this.tel = tel;
		this.email = email;
		this.country = country;
		this.zip = zip;
		this.companyaddress = companyaddress;
		this.superuser = superuser;
		this.delFlag = 1;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public Set getOrders() {
		return orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public Set getUserproducts() {
		return userproducts;
	}

	public void setUserproducts(Set userproducts) {
		this.userproducts = userproducts;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCompanyaddress() {
		return this.companyaddress;
	}

	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}

	public String getSuperuser() {
		return this.superuser;
	}

	public void setSuperuser(String superuser) {
		this.superuser = superuser;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getTemp1() {
		return temp1;
	}

	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}

	public String getTemp2() {
		return temp2;
	}

	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}

	public String getTemp3() {
		return temp3;
	}

	public void setTemp3(String temp3) {
		this.temp3 = temp3;
	}

	public String getTemp4() {
		return temp4;
	}

	public void setTemp4(String temp4) {
		this.temp4 = temp4;
	}

}