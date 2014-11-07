package models;

public interface UserService
{
	public User createUser(String username, String password);
}

/*
	public User createUser(String un, String pw) {
		return new User(un, pw);
	}
	
	User u = us.createUser("bobs", "yeruncle");
	Assert.assertNotNull(u);

*/