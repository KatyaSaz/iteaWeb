package user.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import user.model.User;


public class DBwork {
	private  final String SELECT_USER = "SELECT NAME FROM `users_form` WHERE LOGIN = ? AND PASSWORD = ?;"; 
	private static String INSERT_USER = "INSERT INTO `users_form`(`LOGIN`, `PASSWORD`, `NAME`, `GENDER`, `ADDRESS`, `COMMENT`) VALUES (?,?,?,?,?,?)";

	public DBwork() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test?" + "user=root&password=");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;
	}
	
	public User getName(String login, String password) {
		User user = null;
		Connection con = getConnection();
		try(PreparedStatement ps = con.prepareStatement(SELECT_USER);){
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setName(rs.getString("NAME"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public void addNewUser(User user) {
		Connection con = getConnection();
		
		try(PreparedStatement stmt = con.prepareStatement(INSERT_USER);) {
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getGender());
			stmt.setString(5, user.getAddress());
			stmt.setString(6, user.getComment());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
