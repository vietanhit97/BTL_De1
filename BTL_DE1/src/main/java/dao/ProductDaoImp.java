package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Product;
import util.JDBCUtil;

public class ProductDaoImp implements Dao<Product> {

	@Override
	public List<Product> getAll() {
		List<Product> dataList = new ArrayList<Product>();
		// TODO Auto-generated method stub
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pStatement = connection.prepareStatement("select * from product");
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				Product product = new Product();
				product.setId(rSet.getInt("id"));
				product.setName(rSet.getString("name"));
				product.setImage(rSet.getString("image"));
				product.setStatus(rSet.getInt("status"));
				product.setPrice(rSet.getFloat("price"));
				product.setQuantity(rSet.getInt("quantity"));
				product.setSale_price(rSet.getFloat("sale_price"));
				product.setDescription(rSet.getString("description"));
				product.setCreated_date(rSet.getDate("created_date"));
				product.setCategory_id(rSet.getInt("category_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtil.getConnection();
		Product product = new Product();
		try {
			PreparedStatement pStatement = connection.prepareStatement("select * from product where id=?");
			pStatement.setInt(1, id);
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				product.setId(rSet.getInt("id"));
				product.setName(rSet.getString("name"));
				product.setImage(rSet.getString("image"));
				product.setStatus(rSet.getInt("status"));
				product.setPrice(rSet.getFloat("price"));
				product.setQuantity(rSet.getInt("quantity"));
				product.setSale_price(rSet.getFloat("sale_price"));
				product.setDescription(rSet.getString("description"));
				product.setCreated_date(rSet.getDate("created_date"));
				product.setCategory_id(rSet.getInt("category_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public boolean add(Product t) {
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pStatement = connection.prepareStatement(
					"insert into product(name,image,status,price,quantity,sale_price,description,category_id) values (?,?,?,?,?,?,?,?)");
			pStatement.setString(1, t.getName());
			pStatement.setString(2, t.getImage());
			pStatement.setInt(3, t.getStatus());
			pStatement.setFloat(4, t.getPrice());
			pStatement.setInt(5, t.getQuantity());
			pStatement.setFloat(6, t.getSale_price());
			pStatement.setString(7, t.getDescription());
			pStatement.setInt(8, t.getCategory_id());
			int ketQua = pStatement.executeUpdate();
			if (ketQua > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean edit(Product t) {
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pStatement = connection.prepareStatement(
					"update product set name = ?,image=?,status=?, price=?,quantity=? , sale_price=?,description=?,category_id=? where id=?");
			pStatement.setString(1, t.getName());
			pStatement.setString(2, t.getImage());
			pStatement.setInt(3, t.getStatus());
			pStatement.setFloat(4, t.getPrice());
			pStatement.setInt(5, t.getQuantity());
			pStatement.setFloat(6, t.getSale_price());
			pStatement.setString(7, t.getDescription());
			pStatement.setInt(8, t.getCategory_id());
			pStatement.setInt(9, t.getId());
			int ketQua = pStatement.executeUpdate();
			if (ketQua > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean remote(int id) {
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pStatement = connection.prepareStatement("delete from product where id=?");
			pStatement.setInt(1, id);
			int ketQua = pStatement.executeUpdate();
			if (ketQua > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> getLikeName(String key) {
		List<Product> listData = new ArrayList<Product>();
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pStatement = connection.prepareStatement("select * from product where name like ?");
			pStatement.setString(1, "%" + key + "%");
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				Product product = new Product();
				product.setId(rSet.getInt("id"));
				product.setName(rSet.getString("name"));
				product.setImage(rSet.getString("image"));
				product.setStatus(rSet.getInt("status"));
				product.setPrice(rSet.getFloat("price"));
				product.setQuantity(rSet.getInt("quantity"));
				product.setSale_price(rSet.getFloat("sale_price"));
				product.setDescription(rSet.getString("description"));
				product.setCreated_date(rSet.getDate("created_date"));
				product.setCategory_id(rSet.getInt("category_id"));
				listData.add(product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}

	@Override
	public List<Product> getPaginate(int first) {
		List<Product> dataList = new ArrayList<Product>();
		// TODO Auto-generated method stub
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pStatement = connection
					.prepareStatement("with x as(select ROW_NUMBER() over (order by id asc) as c, * from product )"
							+ "select * from x where c between ?*4-3 and ?*4");
			pStatement.setInt(1, first);
			pStatement.setInt(2, first);
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				Product product = new Product();
				product.setId(rSet.getInt("id"));
				product.setName(rSet.getString("name"));
				product.setImage(rSet.getString("image"));
				product.setStatus(rSet.getInt("status"));
				product.setPrice(rSet.getFloat("price"));
				product.setQuantity(rSet.getInt("quantity"));
				product.setSale_price(rSet.getFloat("sale_price"));
				product.setDescription(rSet.getString("description"));
				product.setCreated_date(rSet.getDate("created_date"));
				product.setCategory_id(rSet.getInt("category_id"));
				dataList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	}

	@Override
	public int count() {
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pStatement = connection.prepareStatement("select COUNT(*) from product ");
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				return rSet.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
