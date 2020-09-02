package daoImplementations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.AccountDao;
import beans.Account;
import beans.User;
import connection.ConnFactory;

public class AccountDaoImpl implements AccountDao {
	
	ConnFactory cf = ConnFactory.getInstance();
	
	public List<Account> getAccounts() {
		
		List<Account> accountList = new ArrayList<Account>();
		String sql = "SELECT * FROM ACCOUNTS";
		
		try { Connection con = cf.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql); 
			while (rs.next()) {
				int userid = rs.getInt("USERID");
				int accid = rs.getInt("ACCOUNTID");
				double balance = rs.getDouble("BALANCE"); 
				
				
				accountList.add(new Account(accid, userid, balance));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountList;
	}
	
	public Account getAccount(int id) {
		Account a = null;
		
		String sql = "SELECT * FROM ACCOUNTS WHERE ACCOUNTID = ?";
		
		ResultSet rs = null;
		
		try {Connection con = ConnFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int accountId = rs.getInt("ACCOUNTID");
				int userId = rs.getInt("USERID");
				double balance = rs.getDouble("BALANCE");
				
				a = new Account(accountId, userId, balance);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return a;
	}
	
	public List<Account> getAccounts(int id, Account a) {
		List<Account> accounts = new ArrayList<Account>();
		String sql = "SELECT * FROM ACCOUNTS WHERE USERID = ?";
		ResultSet rs = null;
		try {Connection con = ConnFactory.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				int userid = rs.getInt("USERID");
				int accid = rs.getInt("ACCOUNTID");
				double balance = rs.getDouble("BALANCE"); 
				
				
				accounts.add(new Account(accid, userid, balance));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return accounts;
	}
	
	
	public int getNextId() {
		int accountId = -1;
		
		if (getAccounts().size()==0) {
			return 0;
		}
		
		String sql = "SELECT MAX(ACCOUNTID) AS MAX_ACCT_ID FROM ACCOUNTS";
		try {Connection con = ConnFactory.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				accountId = rs.getInt("MAX_ACCT_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountId + 1;
	}


		public int updateAccountBalance(Account account) {
			int usersUpdated = 0;
			String sql = "UPDATE ACCOUNTS SET BALANCE = ? WHERE ACCOUNTID = ?";
			
			try {Connection con = ConnFactory.getConnection();
					PreparedStatement ps = con.prepareStatement(sql);
				con.setAutoCommit(false);
				//ps.setInt(1, account.getUserId());
				ps.setDouble(1, account.getBalance());
				ps.setInt(2, account.getUserId());
				
				
				usersUpdated = ps.executeUpdate();
				con.commit();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return usersUpdated;
		}


	
	public int deleteAccountById(int id) {
		int rowsDeleted = 0;
		String sql = "DELETE FROM ACCOUNTS WHERE ACCOUNTID = ?";
		try {Connection con = ConnFactory.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rowsDeleted;
	}
	
	public int createAccount(Account account, User user) {
		int accountsCreated = 0;
		int id = getNextId();
		String sql = "INSERT INTO ACCOUNTS (accountid, userid, balance) VALUES (?, ?, ?)";
		try {Connection con = cf.getConnection();
				PreparedStatement ps = con.prepareStatement(sql); 
			ps.setInt(1, id);
			ps.setInt(2, id);
			ps.setDouble(3, account.getBalance());;
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountsCreated;
	}
	
	public int addNewAccount(Account account, User user) {
		int accountsCreated = 0;
		int nextid = getNextId();
		int userid = user.getUserId();
		double balance = 0;
		String sql = "INSERT INTO ACCOUNTS (accountid, userid, balance) VALUES (?, ?, ?)";
		try {Connection con = cf.getConnection();
				PreparedStatement ps = con.prepareStatement(sql); 
			ps.setInt(1, nextid);
			ps.setInt(2, userid);
			ps.setDouble(3, balance);;
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountsCreated;
	}

}
