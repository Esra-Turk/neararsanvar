package product.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import product.dao.ProductDAO;
import product.model.Product;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;

	public ProductServlet() {
		super();
		this.productDAO = new ProductDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/insert":
				insertProduct(request, response);
				break;
			case "/delete":
				deleteProduct(request, response);
				break;
			case "/update":
				updateProduct(request, response);
				break;
			case "/getProductByID":
				getProductByID(request, response);
				break;
			case "/openProductsPage":
				openProductsPage(request, response);
				break;
			default:
				getProducts(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void getProducts(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Product> products = productDAO.getProducts();
		request.setAttribute("products", products);
		request.getRequestDispatcher("products.jsp");
	}

	private void getProductByID(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int productId = Integer.parseInt(request.getParameter("id"));
		Product product = productDAO.getProductByID(productId);
		request.setAttribute("product", product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product_details.jsp");
		dispatcher.forward(request, response);
	}

	private void openProductsPage(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Product> products = productDAO.getProducts();
		request.setAttribute("products", products);
		RequestDispatcher dispatcher = request.getRequestDispatcher("products.jsp");
		dispatcher.forward(request, response);
	}

	private void insertProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String productName = request.getParameter("productName");
		String productPhoto = request.getParameter("productPhoto");
		double productPrice = Double.parseDouble(request.getParameter("productPrice"));
		int stockAmount = Integer.parseInt(request.getParameter("stockAmount"));
		int categoryID = Integer.parseInt(request.getParameter("categoryID"));

		Product newProduct = new Product(productName, productPhoto, productPrice, stockAmount, categoryID);
		productDAO.insertProduct(newProduct);
		response.sendRedirect("getProducts");
	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
		String productName = request.getParameter("productName");
		String productPhoto = request.getParameter("productPhoto");
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		int stockAmount = Integer.parseInt(request.getParameter("stockAmount"));
		Product product = new Product(productId, productName, productPhoto, productPrice, stockAmount);
		productDAO.updateProduct(product);
		response.sendRedirect("getProducts");
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
		productDAO.deleteProduct(productId);
		response.sendRedirect("getProducts");

	}

}
