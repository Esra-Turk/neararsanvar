package store.model;

public class Store {
	int storeID;
	String storeName;
	String username;
	String password;
	
	public Store(int storeID, String storeName, String username, String password) {
		super();
		this.storeID = storeID;
		this.storeName = storeName;
		this.username = username;
		this.password = password;
	}
	
	
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
