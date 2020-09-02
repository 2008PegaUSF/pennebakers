package daoImplementations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Account;
import beans.User;
import connection.ConnFactory;

public class UserDaoImpl {
	public int createUser(User user) {
		int usersCreated = 0;
		String sql = "INSERT INTO USERS (USERID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME) VALUES (?, ?, ?, ?, ?)";
		try {Connection con = ConnFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFirstname());
			ps.setString(5, user.getLastname());
			usersCreated = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usersCreated;
	}
	
	public List<User> getUsers() throws SQLException {
		List<User> userList = new ArrayList<User>();
		Connection conn = ConnFactory.getConnection();
		String sql = "SELECT * FROM USERS";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		User u = null;
		while(rs.next()) {
			u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			userList.add(u);
		}

		return userList;
	}
	
	public int deleteUserById(int id) {
		int rowsDeleted = 0;
		String sql = "DELETE FROM USERS WHERE USERID = ? ";
		try {Connection con = ConnFactory.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql); 
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsDeleted;
	}
	
	public int updateUserName(String username, int id) {
		int usersUpdated = 0;
		String sql = "UPDATE USERS SET USERNAME = ? WHERE USERID = ?";
		
		try {Connection con = ConnFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
			con.setAutoCommit(false);
			ps.setString(1, username);
			ps.setInt(2, id);
			
			usersUpdated = ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return usersUpdated;
	}

	
	public int updatePassword(String password, int id) {
		int usersUpdated = 0;
		String sql = "UPDATE USERS SET PASSWORD = ? WHERE USERID = ?";
		
		try {Connection con = ConnFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
			con.setAutoCommit(false);
			ps.setString(1, password);
			ps.setInt(2, id);
			
			usersUpdated = ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return usersUpdated;
	}
	public int updateFirstName(String firstname, int id) {
		int usersUpdated = 0;
		String sql = "UPDATE USERS SET FIRSTNAME = ? WHERE USERID = ?";
		
		try {Connection con = ConnFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
			con.setAutoCommit(false);
			ps.setString(1, firstname);
			ps.setInt(2, id);
			
			usersUpdated = ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return usersUpdated;
	}

	
	public int updateLastName(String lastname, int id) {
		int usersUpdated = 0;
		String sql = "UPDATE USERS SET LASTNAME = ? WHERE USERID = ?";
		
		try {Connection con = ConnFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
			con.setAutoCommit(false);
			ps.setString(1, lastname);
			ps.setInt(2, id);
			
			usersUpdated = ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return usersUpdated;
	}
}
