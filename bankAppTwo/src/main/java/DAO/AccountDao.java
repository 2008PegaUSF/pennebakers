package DAO;


import java.sql.Connection;
import java.util.List;


import beans.Account;
import beans.User;

public interface AccountDao {
	public List<Account> getAccounts();
	public Account getAccount(int id);
	public List<Account> getAccounts(int id, Account a);
	public int getNextId();
	public int updateAccountBalance(Account account);
	public int deleteAccountById(int id);
	public int createAccount(Account account, User user);
	public int addNewAccount(Account account, User user);

}
