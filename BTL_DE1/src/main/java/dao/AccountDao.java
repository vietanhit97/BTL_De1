package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Account;
import util.JDBCUtil;

public class AccountDao {
	public Account loginAccount(String email,String password) {
		Connection connection = JDBCUtil.getConnection();
		PreparedStatement pStatement;
		try {
			pStatement = connection.prepareStatement("select * from account where email = ? and password = ? ");
			pStatement.setString(1, email);
			pStatement.setString(2, password);
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				Account account = new Account();
				account.setName(resultSet.getString("name"));
				account.setEmail(resultSet.getString("email"));
				account.setPassword(resultSet.getString("password"));
				return account;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
