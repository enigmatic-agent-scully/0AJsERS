package com.aj.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aj.model.User;
import com.aj.utils.DAOxUtil;

public class UserDAOImpl implements UserDAO {
	Connection connection = null;
	PreparedStatement stmt = null;
	List<User> users = new ArrayList<>();

	public boolean createNewUser(User user) {
		boolean success = false;
		try {
			connection = DAOxUtil.getConnection();

			String sql = "INSERT INTO users VALUES (null, ?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			
			//stmt.setNull(1, user.getU_id());
			stmt.setString(1, user.getFname());
			stmt.setString(2, user.getLname());
			stmt.setNString(3, user.getUname());
			stmt.setString(4, user.getPw());
			stmt.setString(5, user.getRole());

			if (stmt.executeUpdate() > 0) {
				System.out.println("YAY");
				success = true;
			}
			else {
				success = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	public List<User> selectAllUsers() {
		try {
			connection = DAOxUtil.getConnection();

			String sql = "SELECT * FROM users";

			stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setU_id(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setFname(rs.getString(3));
				user.setLname(rs.getString(4));
				user.setPw(rs.getString(5));
				user.setRole(rs.getString(6));

				users.add(user);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// for (User u : users) {
		// System.out.println(u);
		// }
		return users;
	}

	public User selectUserByUsername(String user, String pass) {

		try {
			connection = DAOxUtil.getConnection();
			String sql = "SELECT * FROM users WHERE Uname = ? AND pw = ?";

			stmt = connection.prepareStatement(sql);

			stmt.setString(1, user);
			stmt.setString(2, pass);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));

			} else {
				System.out.println("Not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
