package orders.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cart.model.Cart;
import orders.model.Orders;

public class OrdersDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/neararsanvar?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456789";

	private static final String INSERT_ORDERS_SQL = "INSERT INTO Orders" + "  (orderHolderID, orderStoreID,cartDetails) VALUES " + " (?,?,?);";
	private static final String SELECT_ORDERS = "select * from Orders";
	private static final String SELECT_ORDERS_BY_ID = "select * from orders where orderID = ?";
	private static final String DELETE_ORDERS = "delete from orders where orderID = ?";
	private static final String UPDATE_ORDERS = "update orders set orderHolderID=?, orderStoreID=?, cartDetails=? where orderID = ?";

	public OrdersDAO() {
		super();
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	

	public void insertOrder(Orders orders) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_ORDERS_SQL)) {
			statement.setInt(1, orders.getOrderHolderID());
			statement.setInt(2, orders.getOrderID());
			statement.setString(3, parseDetails(orders.getCartDetails()));
			
			statement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public List<Orders> getOrders() {
		List<Orders> orders = new ArrayList<Orders>();
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_ORDERS);) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int orderID = rs.getInt("orderID");
				int orderHolderID = rs.getInt("orderHolderID");
				int orderStoreID = rs.getInt("orderStoreID");
				//String cartDetails = rs.getString("cartDetails");
				List<HashMap> cartDetails = new ArrayList<HashMap>();
				orders.add(new Orders(orderID,orderHolderID,orderStoreID,cartDetails));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return orders;
	}

	public Orders getOrderByID(int orderId) {
		Orders order = null;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_ORDERS_BY_ID);) {
			statement.setInt(1, orderId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int orderID = rs.getInt("orderID");
				int orderHolderID = rs.getInt("orderHolderID");
				int orderStoreID = rs.getInt("orderStoreID");
				//String cartDetails = rs.getString("cartDetails");
				List<HashMap> cartDetails = new ArrayList<HashMap>();
				order = new Orders(orderID,orderHolderID,orderStoreID,cartDetails);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return order;
	}

	public void deleteOrder(int orderId) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ORDERS);) {
			statement.setInt(1, orderId);
		}
	}
	
	public void updateOrder(Orders order) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ORDERS);) {
			statement.setInt(1, order.getOrderID());
			statement.setInt(2, order.getOrderHolderID());
			statement.setInt(3, order.getOrderStoreID());
			statement.setString(4, "order.getCartDetails()");
			
		}
	}
	public String parseDetails(List<HashMap> cartDetails) {
		ArrayList<String> list = new ArrayList<String>();
		for(HashMap h: cartDetails) {
			list.add(convertWithIteration(h));	
		}
		
		return list.toString();
	}
	public String convertWithIteration(Map<Integer, ?> map) {
	    StringBuilder mapAsString = new StringBuilder("{");
	    for (Integer key : map.keySet()) {
	        mapAsString.append(key + ":" + map.get(key) + ", ");
	    }
	    mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
	    return mapAsString.toString();
	}
	
//    public List<HashMap> getCartDetail(List<Cart> cart) {
//    	ArrayList<HashMap> list = new ArrayList<>();
//    	
//    	for(Cart c: cart) {
//    		HashMap<String, Integer> map = new HashMap<String, Integer>();
//    		map.put("productID", c.getProductId());
//    		map.put("itemAmount", c.getItemAmount());
//    		list.add(map);
//    		
//    	}
//    	
//    	return list;
//    }
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
