package cart.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.register.model.User;

import cart.dao.CartDAO;
import cart.model.Cart;

/**
 * Servlet implementation class CartsServlet
 */
@WebServlet("/pages/CartsServlet")
public class CartsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartDAO cartDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartsServlet() {
        super();
        this.cartDAO = new CartDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Cart> cartProducts = cartDAO.getCart(user.getCartID());
		request.setAttribute("cartProducts", cartProducts);
		request.setAttribute("totalPrice", cartDAO.getTotalPrice(user.getCartID()));
		RequestDispatcher dispatcher = request.getRequestDispatcher("shopping-cart.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
