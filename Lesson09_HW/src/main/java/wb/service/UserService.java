package wb.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import wb.model.User;

public class UserService {
	private final String SELECT_USER = "SELECT NAME FROM `users_form` WHERE LOGIN = ? AND PASSWORD = ?;";
	private static String INSERT_USER = "INSERT INTO `users_form`(`LOGIN`, `PASSWORD`, `NAME`, `GENDER`, `ADDRESS`, `COMMENT`) VALUES (?,?,?,?,?,?)";
	public final static String SALT = ";'lkjuytf";

	private Connector connector;

	public UserService() {
		connector = new Connector();
	}

	public User getName(String login, String password) {
		User user = null;
		Connection con = connector.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SELECT_USER);) {
			ps.setString(1, login);
			ps.setString(2, hashPassword(password));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setName(rs.getString("NAME"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public void addNewUser(User user) {
		Connection con = connector.getConnection();

		try (PreparedStatement stmt = con.prepareStatement(INSERT_USER);) {
			stmt.setString(1, user.getLogin());
			stmt.setString(2, hashPassword(user.getPassword()));
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

	private String hashPassword(String password) throws SQLException {
		String hashPass = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(StandardCharsets.UTF_8.encode(password + SALT));
			hashPass = String.format("%032x", new BigInteger(md.digest()));
		} catch (NoSuchAlgorithmException e) {
			throw new SQLException();
		}
		return hashPass;
	}

}
