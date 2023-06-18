package product.model;

public class Product {
	private int id;
	private String productName;
	private String productPhoto;
	private double productPrice;
	private int stockAmount;
	private int categoryId;

	public Product(int id, String productName, String productPhoto, double productPrice, int stockAmount,
			int categoryId) {
		super();
		this.id = id;
		this.productName = productName;
		this.productPhoto = productPhoto;
		this.productPrice = productPrice;
		this.stockAmount = stockAmount;
		this.categoryId = categoryId;
	}

	// this constructor is used for inserting new product
	public Product(String productName, String productPhoto, double productPrice, int stockAmount, int categoryId) {
		super();
		this.productName = productName;
		this.productPhoto = productPhoto;
		this.productPrice = productPrice;
		this.stockAmount = stockAmount;
		this.categoryId = categoryId;
	}

	// this constructor is used for the update method
	public Product(int id, String productName, String productPhoto, double productPrice, int stockAmount) {
		super();
		this.id = id;
		this.productName = productName;
		this.productPhoto = productPhoto;
		this.productPrice = productPrice;
		this.stockAmount = stockAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPhoto() {
		return productPhoto;
	}

	public void setProductPhoto(String productPhoto) {
		this.productPhoto = productPhoto;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
