package category.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import category.dao.CategoryDAO;
import category.model.Category;




@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;
	
	
    public CategoryServlet() {
        super();
        this.categoryDAO = new CategoryDAO();
    }

	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/insert":
				insertCategory(request, response);
				break;
			case "/delete":
				deleteCategory(request, response);
				break;
			case "/update":
				updateCategory(request, response);
				break;
			case "/getCategoryByID":
				getCategoryByID(request, response);
				break;
			case "/openCategoriesPage":
				openCategoriesPage(request, response);
				break;
			default:
				getCategories(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void getCategories(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Category> categories = categoryDAO.getCategories();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("......jsp");
	}

	private void getCategoryByID(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		Category category = categoryDAO.getCategoryByID(categoryId);
		request.setAttribute("category", category);
		RequestDispatcher dispatcher = request.getRequestDispatcher("......jsp");
		dispatcher.forward(request, response);
	}

	private void openCategoriesPage(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Category> categories = categoryDAO.getCategories();
		request.setAttribute("categories", categories);
		RequestDispatcher dispatcher = request.getRequestDispatcher(".....jsp");
		dispatcher.forward(request, response);
	}

	private void insertCategory(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String categoryName = request.getParameter("categoryName");
		Category newCategory = new Category(categoryName);
		categoryDAO.insertCategory(newCategory);
		response.sendRedirect("getCategories");
	}

	private void updateCategory(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		String categoryName = request.getParameter("categoryName");
		Category category = new Category(categoryId, categoryName);
		categoryDAO.updateCategory(category);
		response.sendRedirect("getCategories");
	}

	private void deleteCategory(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		categoryDAO.deleteCategory(categoryId);
		response.sendRedirect("getCategories");

	}

}
