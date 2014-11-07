package models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapUserService implements UserService
{
	private Map<Long, User> users = new HashMap<Long, User>();
	private Set<String> usernames = new HashSet<String>();
	
	@Override
	public User createUser(String username, String password)
	{
		User user = new User(username, password);
		if(!usernames.contains(username)) {
			users.put(user.getId(), user);
			usernames.add(user.getUsername());
			return user;
		}
		
		throw new UsernameAlreadyExistsException("That username is not unique!");
	}
}
