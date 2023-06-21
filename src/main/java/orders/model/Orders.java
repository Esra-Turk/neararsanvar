package orders.model;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Orders {
	int orderID;
	int orderHolderID;
	int orderStoreID;
	List<HashMap> cartDetails;
	
	public Orders(int orderID, int orderHolderID, int orderStoreID, List<HashMap> cartDetails) {
		super();
		this.orderID = orderID;
		this.orderHolderID = orderHolderID;
		this.orderStoreID = orderStoreID;
		this.cartDetails = cartDetails;
	}
	


	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getOrderHolderID() {
		return orderHolderID;
	}

	public void setOrderHolderID(int orderHolderID) {
		this.orderHolderID = orderHolderID;
	}

	public int getOrderStoreID() {
		return orderStoreID;
	}

	public void setOrderStoreID(int orderStoreID) {
		this.orderStoreID = orderStoreID;
	}

	public List<HashMap> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(List<HashMap> cartDetails) {
		this.cartDetails = cartDetails;
	}
	

}
