package category.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import category.model.Category;

public class CategoryDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/neararsanvar?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456789";

	private static final String INSERT_CATEGORY_SQL = "INSERT INTO category" + "  (categoryName) VALUES " + " (?);";
	private static final String SELECT_CATEGORIES = "select * from category";
	private static final String SELECT_CATEGORY_BY_ID = "select * from category where categoryID = ?";
	private static final String DELETE_CATEGORY = "delete from category where categoryID = ?";
	private static final String UPDATE_CATEGORY = "update category set categoryName = ? where categoryID = ?";

	public CategoryDAO() {
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

	public void insertCategory(Category category) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_CATEGORY_SQL)) {
			statement.setString(1, category.getCategoryName());
			statement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<Category>();
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_CATEGORIES);) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int categoryID = rs.getInt("categoryID");
				String categoryName = rs.getString("categoryName");
				categories.add(new Category(categoryID, categoryName));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return categories;
	}

	public Category getCategoryByID(int categoryId) {
		Category category = null;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);) {
			statement.setInt(1, categoryId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int categoryID = rs.getInt("categoryID");
				String categoryName = rs.getString("categoryName");
				category = new Category(categoryID, categoryName);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return category;
	}

	public void deleteCategory(int categoryId) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY);) {
			statement.setInt(1, categoryId);
		}
	}

	public void updateCategory(Category category) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY);) {
			statement.setString(1, category.getCategoryName());
			statement.setInt(2, category.getId());
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
