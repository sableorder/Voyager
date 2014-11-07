package models;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;


public class DatabaseAccess {

	public void login(String username, String password){
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
			}
			else{
				System.out.println("Failed login. Bad password/username combination");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
	}
}
