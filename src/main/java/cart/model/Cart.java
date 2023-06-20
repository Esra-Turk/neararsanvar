package cart.model;

import product.model.Product;
import product.dao.*;

public class Cart {
	private String id;
	private Product product;
	private int itemAmount;

	public Cart(String id, int productId, int itemAmount) {
		super();
		this.id = id;
		this.product = new ProductDAO().getProductByID(productId);
		this.itemAmount = itemAmount;
	}

	public Cart(int productId, int itemAmount) {
		super();
		this.product = new ProductDAO().getProductByID(productId);
		this.itemAmount = itemAmount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getProductId() {
		return this.product.getId();
	}

	public void setProductId(int productId) {
		this.product.setId(productId);
	}
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(int itemAmount) {
		this.itemAmount = itemAmount;
	}

}
