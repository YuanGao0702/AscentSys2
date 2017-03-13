package struts.action;

import hibernate.po.Product;
import hibernate.po.Productuser;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;

import org.apache.struts2.ServletActionContext;

import spring.bo.ProductManager;

import com.jspsmart.upload.SmartUpload;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {

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

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public String getCatalogno() {
		return catalogno;
	}

	public void setCatalogno(String catalogno) {
		this.catalogno = catalogno;
	}

	public String getCas() {
		return cas;
	}

	public void setCas(String cas) {
		this.cas = cas;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getMdlnumber() {
		return mdlnumber;
	}

	public void setMdlnumber(String mdlnumber) {
		this.mdlnumber = mdlnumber;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getMw() {
		return mw;
	}

	public void setMw(String mw) {
		this.mw = mw;
	}

	public String getPrice1() {
		return price1;
	}

	public void setPrice1(String price1) {
		this.price1 = price1;
	}

	public String getPrice2() {
		return price2;
	}

	public void setPrice2(String price2) {
		this.price2 = price2;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getRealstock() {
		return realstock;
	}

	public void setRealstock(String realstock) {
		this.realstock = realstock;
	}

	public String getNewproduct() {
		return newproduct;
	}

	public void setNewproduct(String newproduct) {
		this.newproduct = newproduct;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	private ProductManager pm;

	public ProductManager getPm() {
		return pm;
	}

	public void setPm(ProductManager pm) {
		this.pm = pm;
	}

	@Override
	public String execute() throws Exception {
		String state = ServletActionContext.getRequest().getParameter("a");
		if (state.equals("all"))// 如果是查询产品，处理查询业务。（all表示查询所有）
		{
			return this.findProduceAll();
		}
		if (state.equals("save")) {
			return this.addProduct();
		}
		if (state.equals("search")) {
			return this.serachProduct();
		}
		if (state.equals("updateProduct"))// 执行更新的查询
		{
			return this.productSerachbyid();
		}
		if (state.equals("update"))// 保存更新信息
		{
			return this.updateProduct();
		}
		if (state.equals("del"))// 保存更新信息
		{
			return this.deleteProduct();
		}
		return ERROR;
	}

	private String serachProduct() {
		String searchNames = ServletActionContext.getRequest().getParameter(
				"searchName");
		String searchValues = ServletActionContext.getRequest().getParameter(
				"searchValue");
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		List ProductList = this.pm.searchProcuct(searchNames, searchValues);
		session.put("searchproductlist", ProductList);
		return "search";
	}

	private String deleteProduct() {
		String productid = ServletActionContext.getRequest()
				.getParameter("pid");
		int pid = Integer.valueOf(productid);
		this.pm.delProductByPid(pid);
		List ProcuctList = this.pm.getAllProduct();
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		session.put("productlist", ProcuctList);
		return "del";
	}

	private String addProduct() {
		Product pdt = new Product();
		pdt.setProductId(productId);
		pdt.setProductname(productname);
		pdt.setCatalogno(catalogno);
		pdt.setCas(cas);
		pdt.setMdlnumber(mdlnumber);
		pdt.setNewproduct(newproduct);
		pdt.setFormula(formula);
		pdt.setMw(mw);
		pdt.setCategory(category);
		pdt.setStock(stock);
		pdt.setRealstock(realstock);
		pdt.setPrice1(price1);
		pdt.setPrice2(price2);
		pdt.setNote(note);
		pdt.setDelFlag(1);
		this.pm.saveProduct(pdt);
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		List ProcuctList = this.pm.getAllProduct();
		session.put("productlist", ProcuctList);
		return "save";
	}

	private String productSerachbyid() {

		String productid = ServletActionContext.getRequest()
				.getParameter("pid");
		int pid = Integer.valueOf(productid);

		Product product = this.pm.getProductByPid(pid);

		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		session.put("pid_product", product);
		return "updateProduct";
	}

	private String updateProduct() {
		String productid = ServletActionContext.getRequest()
				.getParameter("pid");
		int pid = Integer.valueOf(productid);
		Product pdt = this.pm.getProductByPid(pid);
		pdt.setProductname(productname);
		pdt.setCatalogno(catalogno);
		pdt.setCas(cas);
		pdt.setMdlnumber(mdlnumber);
		pdt.setNewproduct(newproduct);
		pdt.setFormula(formula);
		pdt.setMw(mw);
		pdt.setCategory(category);
		pdt.setStock(stock);
		pdt.setRealstock(realstock);
		pdt.setPrice1(price1);
		pdt.setPrice2(price2);
		pdt.setNote(note);
		this.pm.updateProduct(pdt);
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		List ProcuctList = this.pm.getAllProduct();
		session.put("productlist", ProcuctList);
		return "update";
	}

	private String findProduceAll() {
		List ProcuctList = this.pm.getAllProduct();
		if (ProcuctList != null) {
			ActionContext ctx = ActionContext.getContext();
			Map session = ctx.getSession();
			Productuser pu = (Productuser) session.get("productuser");
			session.put("productlist", ProcuctList);
			if (pu == null)// 如果是游客
			{
				return "visitor_all";
			} else// 如果是注册用户
			{
				if (pu.getSuperuser().equals("3"))// 判断是否管理员浏览产品页（分为管理员和非管理员浏览产品）
				{
					return "admin_all";
				} else {
					return "user_all";
				}
			}
		}
		return ERROR;
	}
}
