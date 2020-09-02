package DAO;

import java.util.List;

import beans.User;

public interface UserDao {
	public int createUser(User user);
	public List<User> getUsers();
	public int deleteUserById(int id);
	public int updateUserName(String username, int id);
	public int updatePassword(String password, int id);
	public int updateFirstName(String firstname, int id);
	public int updateLastName(String lastname, int id);
}
