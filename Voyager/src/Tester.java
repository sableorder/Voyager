import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import models.Account;
import models.DatabaseAccess;
import models.Roles;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;


public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseAccess access = new DatabaseAccess();
		access.login("David", "Pass");
		Account testing = new Account("Billy", "Bob@gmail.com", "", Roles.Admin, "SuperSecret");
		access.registerUser(testing);
		
//		System.out.println("hello world");
//		Driver driver = new SQLServerDriver();
//		String connectionUrl = "jdbc:sqlserver://n8bu1j6855.database.windows.net:1433;database=VoyagerDB;user=VoyageLogin@n8bu1j6855;password={GroupP@ssword};encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
//		try {
//			Connection con = driver.connect(connectionUrl, new Properties());
//			PreparedStatement statement = con.prepareStatement("Insert INTO UserTable (userId, userName, userPassword) VALUES (12346, 'BobII', 'SuperSecret');");
//			statement.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

}