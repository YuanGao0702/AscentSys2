package hibernate.po;

import java.util.HashSet;
import java.util.Set;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private Integer pid;
	private String productId;
	private Set orderitems = new HashSet(0);
	private Set userproducts = new HashSet(0);
	private String catalogno;
	private String cas;
	private String productname;
	private String structure;
	private String mdlnumber;
	private String formula;
	private String mw;
	private String price1;
	private String price2;
	private String stock;
	private String realstock;
	private String newproduct;
	private String category;
	private String note;
	private Integer delFlag;
	private String temp1;
	private String temp2;
	private String temp3;
	private String temp4;

	// 临时加质量字段
	private String quantity;

	// Constructors

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** full constructor */
	public Product(String productId, Set orderitems, Set userproducts,
			String catalogno, String cas, String productname, String structure,
			String mdlnumber, String formula, String mw, String price1,
			String price2, String stock, String realstock, String newproduct,
			String category, String note, Integer delFlag) {
		super();
		this.productId = productId;
		this.orderitems = orderitems;
		this.userproducts = userproducts;
		this.catalogno = catalogno;
		this.cas = cas;
		this.productname = productname;
		this.structure = structure;
		this.mdlnumber = mdlnumber;
		this.formula = formula;
		this.mw = mw;
		this.price1 = price1;
		this.price2 = price2;
		this.stock = stock;
		this.realstock = realstock;
		this.newproduct = newproduct;
		this.category = category;
		this.note = note;
		this.delFlag = delFlag;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCatalogno() {
		return this.catalogno;
	}

	public void setCatalogno(String catalogno) {
		this.catalogno = catalogno;
	}

	public String getCas() {
		return this.cas;
	}

	public void setCas(String cas) {
		this.cas = cas;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getStructure() {
		return this.structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getMdlnumber() {
		return this.mdlnumber;
	}

	public void setMdlnumber(String mdlnumber) {
		this.mdlnumber = mdlnumber;
	}

	public String getFormula() {
		return this.formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getMw() {
		return this.mw;
	}

	public void setMw(String mw) {
		this.mw = mw;
	}

	public String getPrice1() {
		return this.price1;
	}

	public void setPrice1(String price1) {
		this.price1 = price1;
	}

	public String getPrice2() {
		return this.price2;
	}

	public void setPrice2(String price2) {
		this.price2 = price2;
	}

	public String getStock() {
		return this.stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getRealstock() {
		return this.realstock;
	}

	public void setRealstock(String realstock) {
		this.realstock = realstock;
	}

	public String getNewproduct() {
		return this.newproduct;
	}

	public void setNewproduct(String newproduct) {
		this.newproduct = newproduct;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
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

	public Set getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}

	public Set getUserproducts() {
		return userproducts;
	}

	public void setUserproducts(Set userproducts) {
		this.userproducts = userproducts;
	}

}