package cart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cart.model.Cart;

public class CartDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/neararsanvar?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456789";

	private static final String INSERT_CART_SQL = "INSERT INTO cart" + "  (cartID, productID, buyAmount) VALUES "
			+ " (?, ?, ? ,?);";

	private static final String SELECT_CART_BY_ID = "select * from cart where cartID =?";
	private static final String DELETE_PRODUCT_FROM_CART_SQL = "delete from cart where cartID = ? and productID = ?";
	private static final String UPDATE_CART_SQL = "update cart set buyAmount = ? where cartID = ? and productID = ?";

	public CartDAO() {
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

	public void insertProductIntoCart(Cart cart) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_CART_SQL)) {
			statement.setString(1, cart.getId());
			statement.setInt(2, cart.getProductId());
			statement.setInt(3, cart.getItemAmount());
			statement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public List<Cart> getCart(String cartId) {
		List<Cart> cartProducts = new ArrayList<Cart>();
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_CART_BY_ID);) {
			statement.setString(1, cartId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				String cardId = rs.getString("cartID");
				int productId = rs.getInt("productID");
				int itemAmount = rs.getInt("buyAmount");
				cartProducts.add(new Cart(cardId, productId, itemAmount));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return cartProducts;
	}

	public void deleteProductFromCart(String cardId, int productId) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_FROM_CART_SQL);) {
			statement.setString(1, cardId);
			statement.setInt(2, productId);
		}
	}

	public void updateCart(Cart product) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CART_SQL);) {
			statement.setInt(1, product.getItemAmount());
			statement.setString(2, product.getId());
			statement.setInt(3, product.getProductId());
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
