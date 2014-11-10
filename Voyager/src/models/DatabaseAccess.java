package models;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;


public class DatabaseAccess {

	public Account login(String username, String password){
		Account account = null;
		Driver driver = new SQLServerDriver();
		String connectionUrl = "jdbc:sqlserver://n8bu1j6855.database.windows.net:1433;database=VoyagerDB;user=VoyageLogin@n8bu1j6855;password={GroupP@ssword};encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try {
			username.replace("'", "''");
			Connection con = driver.connect(connectionUrl, new Properties());
			PreparedStatement statement = con.prepareStatement("Select userPassword from UserTable where userName = '" + username + "'");
			ResultSet rs = statement.executeQuery();
			rs.next();
			String storedPass = rs.getString("userPassword");
			if(storedPass.equals(password)){
				System.out.println("Successfully logged in");
				account = new Account(rs.getString("userName"), rs.getString("userEmail"), "", Roles.valueOf(rs.getString("userRole")), rs.getString("userPassword"));
			}
			else{
				System.out.println("Failed login. Bad password/username combination");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return account;
	}
	
	public void registerUser(Account user){
		Driver driver = new SQLServerDriver();
		String connectionUrl = "jdbc:sqlserver://n8bu1j6855.database.windows.net:1433;database=VoyagerDB;user=VoyageLogin@n8bu1j6855;password={GroupP@ssword};encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try {
			user.getUsername().replace("'", "''");
			user.getPassword().replace("'", "''");
			Connection con = driver.connect(connectionUrl, new Properties());
			PreparedStatement statement = con.prepareStatement("Insert INTO UserTable (userName, userPassword, userEmail, userRole) "
					+ "VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getEmail() + "', '" + user.getRole().toString() + "');");
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void removeUser(Account user){
		Driver driver = new SQLServerDriver();
		String connectionUrl = "jdbc:sqlserver://n8bu1j6855.database.windows.net:1433;database=VoyagerDB;user=VoyageLogin@n8bu1j6855;password={GroupP@ssword};encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try {
			user.getUsername().replace("'", "''");
			user.getPassword().replace("'", "''");
			Connection con = driver.connect(connectionUrl, new Properties());
			PreparedStatement statement = con.prepareStatement("DELETE FROM UserTable WHERE userName='" + user.getUsername() + "'");
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void updateUser(Account user){
		Driver driver = new SQLServerDriver();
		String connectionUrl = "jdbc:sqlserver://n8bu1j6855.database.windows.net:1433;database=VoyagerDB;user=VoyageLogin@n8bu1j6855;password={GroupP@ssword};encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try {
			user.getUsername().replace("'", "''");
			user.getPassword().replace("'", "''");
			Connection con = driver.connect(connectionUrl, new Properties());
			PreparedStatement statement = con.prepareStatement("UPDATE UserTable "
					+ "SET userPassword='" + user.getPassword() + "', userEmail='" + user.getEmail() + "', userRole='" + user.getRole().toString() + "'"
					+ "WHERE userName='" + user.getUsername() + "'");
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
