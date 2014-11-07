package models;

public class User
{
	public static long counter = 0;
	private long id;
	private final String username;
	private final String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.id = ++counter;
	}

	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}
	
	public long getId() {
		return id;
	}
}


