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
 * Servlet implementation class InsertCategory
 */
@WebServlet({"/InsertCategory","/them-danh-muc"})
public class InsertCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static CategoryDaoImp categoryDaoImp;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCategory() {
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
		String nameString = request.getParameter("catname");
		System.out.println(nameString);
		String status =request.getParameter("status");
		int statusInt = Integer.parseInt(status);
		int parentId = Integer.parseInt(request.getParameter("parentId"));
		Categories categories = new Categories();
		categories.setCatname(nameString);
		categories.setStatus(statusInt);
		categories.setParentld(parentId);
		boolean bl = categoryDaoImp.add(categories);
		if (bl) {
			response.sendRedirect("admin/category/index.jsp");
		}else {
			request.setAttribute("err", "Thêm mới không thành công ");
			response.sendRedirect("InsertCategory");
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
