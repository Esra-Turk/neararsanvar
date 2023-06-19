package product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import product.model.Product;

public class ProductDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/neararsanvar?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456789";

	private static final String INSERT_PRODUCT_SQL = "INSERT INTO product"
			+ "  (productName, productPhoto, productPrice, stockAmount, categoryID) VALUES "
			+ " (?, ?, ? ,?, ?);";
	private static final String SELECT_PRODUCTS = "select * from product";
	private static final String SELECT_PRODUCT_BY_ID = "select * from product where productID = ?";
	private static final String DELETE_PRODUCT = "delete from product where productID = ?";
	private static final String UPDATE_PRODUCT = "update product set productName = ?, productPhoto = ?, productPrice = ?, stockAmount = ? where productID = ?";

	public ProductDAO() {
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

	public void insertProduct(Product product) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
			statement.setString(1, product.getProductName());
			statement.setString(2, product.getProductPhoto());
			statement.setDouble(3, product.getProductPrice());
			statement.setInt(4, product.getStockAmount());
			statement.setInt(5, product.getCategoryId());
			statement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCTS);) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int productID = rs.getInt("productID");
				String productName = rs.getString("productName");
				String productPhoto = rs.getString("productPhoto");
				double productPrice = rs.getDouble("productPrice");
				int stockAmount = rs.getInt("stockAmount");
				int categoryID = rs.getInt("categoryID");
				products.add(new Product(productID, productName, productPhoto, productPrice, stockAmount, categoryID));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return products;
	}

	public Product getProductByID(int productId) {
		Product product = null;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
			statement.setInt(1, productId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int productID = rs.getInt("productID");
				String productName = rs.getString("productName");
				String productPhoto = rs.getString("productPhoto");
				double productPrice = rs.getDouble("productPrice");
				int stockAmount = rs.getInt("stockAmount");
				int categoryID = rs.getInt("categoryID");
				product = new Product(productID, productName, productPhoto, productPrice, stockAmount, categoryID);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return product;
	}

	public void deleteProduct(int productId) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT);) {
			statement.setInt(1, productId);
		}
	}

	public void updateProduct(Product product) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT);) {
			statement.setString(1, product.getProductName());
			statement.setString(2, product.getProductPhoto());
			statement.setDouble(3, product.getProductPrice());
			statement.setInt(4, product.getStockAmount());
			statement.setInt(5, product.getId());
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
