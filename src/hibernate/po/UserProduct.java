package hibernate.po;

/**
 * UserProduct entity. @author MyEclipse Persistence Tools
 */

public class UserProduct implements java.io.Serializable {

	// Fields

	private Integer userProductId;
	private Productuser productuser;
	private Product product;

	// Constructors

	/** default constructor */
	public UserProduct() {
	}

	/** full constructor */
	public UserProduct(Productuser productuser, Product product) {
		super();
		this.productuser = productuser;
		this.product = product;
	}
	// Property accessors

	public Integer getUserProductId() {
		return this.userProductId;
	}

	public void setUserProductId(Integer userProductId) {
		this.userProductId = userProductId;
	}

	public Productuser getProductuser() {
		return productuser;
	}

	public void setProductuser(Productuser productuser) {
		this.productuser = productuser;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}