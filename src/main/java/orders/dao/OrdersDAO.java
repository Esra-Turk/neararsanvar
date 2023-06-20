package order.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import store.model.Store;

public class OrderDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/neararsanvar?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456789";

	private static final String INSERT_STORE_SQL = "INSERT INTO Store" + "  (storeName,username,password) VALUES " + " (?,?,?);";
	private static final String SELECT_STORES = "select * from Store";
	private static final String SELECT_STORE_BY_ID = "select * from store where storeID = ?";
	private static final String DELETE_STORE = "delete from store where storeID = ?";
	private static final String UPDATE_STORE = "update store set storeName = ?, username=?, password=? where storeID = ?";

	public StoreDAO() {
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

	public void insertStore(Store store) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_STORE_SQL)) {
			statement.setString(1, store.getStoreName());
			statement.setString(2, store.getUsername());
			statement.setString(3, store.getPassword());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public List<Store> getStores() {
		List<Store> stores = new ArrayList<Store>();
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_STORES);) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int storeID = rs.getInt("storeID");
				String storeName = rs.getString("storeName");
				String username = rs.getString("username");
				String password = rs.getString("password");
				stores.add(new Store(storeID,storeName,username,password));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return stores;
	}

	public Store getStoreByID(int storeId) {
		Store store = null;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_STORE_BY_ID);) {
			statement.setInt(1, storeId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int storeID = rs.getInt("storeID");
				String storeName = rs.getString("storeName");
				String username = rs.getString("username");
				String password = rs.getString("password");
				store = new Store(storeID,storeName,username,password);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return store;
	}

	public void deleteStore(int storeId) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_STORE);) {
			statement.setInt(1, storeId);
		}
	}

	public void updateStore(Store store) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_STORE);) {
			statement.setString(1, store.getStoreName());
			statement.setString(2, store.getUsername());
			statement.setString(3, store.getPassword());
			statement.setInt(4, store.getStoreID());
			
		}
	}

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
