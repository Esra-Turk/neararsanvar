package cart.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cart.dao.CartDAO;
import cart.model.Cart;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartDAO cartDAO;

	public CartServlet() {
		super();
		this.cartDAO = new CartDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/insert":
				insertProductIntoCart(request, response);
				break;
			case "/delete":
				deleteProductFromCart(request, response);
				break;
			case "/update":
				updateCart(request, response);
				break;
			case "/getCart":
				getCart(request, response);
				break;
			default:
				openCart(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void getCart(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String cartId = request.getParameter("id");
		List<Cart> cartProducts = cartDAO.getCart(cartId);
		request.setAttribute("cartProducts", cartProducts);
		request.getRequestDispatcher("shopping-cart.jsp");
	}

	private void openCart(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String cartId = request.getParameter("id");
		List<Cart> cartProducts = cartDAO.getCart(cartId);
		request.setAttribute("cartProducts", cartProducts);
		RequestDispatcher dispatcher = request.getRequestDispatcher("shopping-cart.jsp");
		dispatcher.forward(request, response);
	}

	private void insertProductIntoCart(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String cardID = request.getParameter("cardID");
		int productID = Integer.parseInt(request.getParameter("productID"));
		int itemAmount = Integer.parseInt(request.getParameter("itemAmount"));
		Cart newCart = new Cart(cardID, productID, itemAmount);
		cartDAO.insertProductIntoCart(newCart);
		response.sendRedirect("getCart");
	}

	private void updateCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		String cardID = request.getParameter("cardID");
		int productID = Integer.parseInt(request.getParameter("productID"));
		int itemAmount = Integer.parseInt(request.getParameter("itemAmount"));

		Cart cart = new Cart(cardID, productID, itemAmount);
		cartDAO.updateCart(cart);
		response.sendRedirect("getCart");
	}

	private void deleteProductFromCart(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String cardID = request.getParameter("cardID");
		int productID = Integer.parseInt(request.getParameter("productID"));
		cartDAO.deleteProductFromCart(cardID, productID);
		response.sendRedirect("getCart");

	}

}
