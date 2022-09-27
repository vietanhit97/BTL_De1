package controller.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDaoImp;
import entity.Categories;

/**
 * Servlet implementation class PreUpdateCategory
 */
@WebServlet("/PreUpdateCategory")
public class PreUpdateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static CategoryDaoImp categoryDaoImp;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreUpdateCategory() {
        super();
        categoryDaoImp=new CategoryDaoImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Categories category = categoryDaoImp.getById(id);
		request.setAttribute("c", category);
		request.getRequestDispatcher("admin/category/updateCategory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
