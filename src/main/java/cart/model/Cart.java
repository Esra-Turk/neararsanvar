package cart.model;

public class Cart {
	private String id;
	private int productId;
	private int itemAmount;

	public Cart(String id, int productId, int itemAmount) {
		super();
		this.id = id;
		this.productId = productId;
		this.itemAmount = itemAmount;
	}

	public Cart(int productId, int itemAmount) {
		super();
		this.productId = productId;
		this.itemAmount = itemAmount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(int itemAmount) {
		this.itemAmount = itemAmount;
	}

}
