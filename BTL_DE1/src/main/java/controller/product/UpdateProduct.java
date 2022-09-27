package controller.product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ProductDaoImp;
import entity.Product;

/**
 * Servlet implementation class UpdateProduct
 */
@MultipartConfig
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			Part part = request.getPart("upload");
			String realPart = request.getServletContext().getRealPath("/images");
			String fileNameString = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if(!Files.exists(Path.of(realPart))) {
				Files.createDirectories(Path.of(realPart));
			}
			part.write(realPart+"/"+fileNameString);
			String dsc = request.getParameter("description");
			float price = Float.parseFloat(request.getParameter("price"));
			float salePrice = Float.parseFloat(request.getParameter("sale_price"));
			int status = Integer.parseInt(request.getParameter("status"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int categoryId = Integer.parseInt(request.getParameter("catId"));
			Product product = new Product();
			product.setId(id);
			product.setName(name);
			product.setImage(fileNameString);
			product.setDescription(dsc);
			product.setPrice(price);
			product.setSale_price(salePrice);
			product.setQuantity(quantity);
			product.setStatus(status);
			product.setCategory_id(categoryId);
			boolean bl = new ProductDaoImp().edit(product);
			if (bl) {
				response.sendRedirect("admin/product/index.jsp");
			}else {
				request.getRequestDispatcher("admin/product/updateProduct.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
