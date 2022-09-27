package controller.category;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDaoImp;
import entity.Categories;

/**
 * Servlet implementation class ListCategory
 */
@WebServlet("/ListCategory")
public class ListCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDaoImp categoryDaoImp ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCategory() {
        categoryDaoImp = new CategoryDaoImp();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int index = Integer.parseInt(request.getParameter("index"));
		int count = categoryDaoImp.count();
		int pageSize = 4 ;
		int endPage = 0 ;
		endPage = count/pageSize;
		if(count % pageSize !=0) {
			endPage++;
		}
		List<Categories> dataListPaginate = categoryDaoImp.getPaginate(index);
		request.setAttribute("list",dataListPaginate );
		request.setAttribute("endPage", endPage);
		request.setAttribute("index", index);
		request.getRequestDispatcher("admin/category/categores.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
