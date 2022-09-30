package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Categories;
import util.JDBCUtil;

public class CategoryDaoImp implements Dao<Categories> {

	@Override
	public List<Categories> getAll() {
		List<Categories> dataList = new ArrayList<Categories>();
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pStatement = connection.prepareStatement("select * from category");
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				Categories categories = new Categories();
				categories.setId(rSet.getInt("id"));
				categories.setCatname(rSet.getString("name"));
				categories.setStatus(rSet.getInt("status"));
				categories.setParentld(rSet.getInt("parentId"));
				dataList.add(categories);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	}

	@Override
	public Categories getById(int id) {
		// TODO Auto-generated method stub
		Categories categories = new Categories();
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pStatement = connection.prepareStatement("select * from category where id = ?");
			pStatement.setInt(1, id);
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				categories.setId(rSet.getInt("id"));
				categories.setCatname(rSet.getString("name"));
				categories.setStatus(rSet.getInt("status"));
				categories.setParentld(rSet.getInt("parentId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public boolean add(Categories t) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pStatement = connection
					.prepareStatement("insert into category(name,status,parentId) values (?,?,?)");
			pStatement.setString(1, t.getCatname());
			pStatement.setInt(2, t.getStatus());
			pStatement.setInt(3, t.getParentld());
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
	public boolean edit(Categories t) {
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pStatement = connection
					.prepareStatement("update category set name=?, status=? ,parentId = ?  where id=?");
			pStatement.setString(1, t.getCatname());
			pStatement.setInt(2, t.getStatus());
			pStatement.setInt(3, t.getParentld());
			pStatement.setInt(4, t.getId());
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
		// TODO Auto-generated method stub
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pStatement = connection.prepareStatement("delete from category where id=?");
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
	public List<Categories> getLikeName(String key) {
		List<Categories> listData = new ArrayList<Categories>();
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pStatement = connection.prepareStatement("select * from category where name like ?");
			pStatement.setString(1, "%" + key + "%");
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				Categories categories = new Categories();
				categories.setId(resultSet.getInt("id"));
				categories.setCatname(resultSet.getString("name"));
				categories.setStatus(resultSet.getInt("status"));
				categories.setParentld(resultSet.getInt("parentId"));
				listData.add(categories);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listData;
	}

	@Override
	public List<Categories> getPaginate(int first) {
		List<Categories> dataList = new ArrayList<Categories>();
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pStatement = connection
					.prepareStatement("with x as(select ROW_NUMBER() over (order by id asc) as c, * from category )"
							+ "select * from x where c between ?*4-3 and ?*4");
			pStatement.setInt(1, first);
			pStatement.setInt(2, first);
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				Categories categories = new Categories();
				categories.setId(rSet.getInt("id"));
				categories.setCatname(rSet.getString("name"));
				categories.setStatus(rSet.getInt("status"));
				categories.setParentld(rSet.getInt("parentId"));
				dataList.add(categories);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	}

	@Override
	public int count() {
		Connection connection = JDBCUtil.getConnection();
		try {
			PreparedStatement pStatement = connection.prepareStatement("select COUNT(*) from category ");
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
