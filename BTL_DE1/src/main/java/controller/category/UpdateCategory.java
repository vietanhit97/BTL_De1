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
 * Servlet implementation class UpdateCategory
 */
@WebServlet("/UpdateCategory")
public class UpdateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static CategoryDaoImp categoryDaoImp;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCategory() {
        super();
        categoryDaoImp = new CategoryDaoImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String nameString = request.getParameter("catname");
		int status = Integer.parseInt(request.getParameter("status")); 
		int parentid = Integer.parseInt(request.getParameter("parentid")); 
		Categories  categories = new Categories();
		categories.setId(id);
		categories.setCatname(nameString);
		categories.setStatus(status);
		categories.setParentld(parentid);
		boolean bl = categoryDaoImp.edit(categories);
		if (bl) {
			response.sendRedirect("admin/category/index.jsp");
		}else {
			request.setAttribute("err", "Cập nhật không thành công");
			request.getRequestDispatcher("admin/category/updateCategory.jsp").forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
