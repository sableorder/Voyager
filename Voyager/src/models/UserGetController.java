package models;

public class UserGetController
{
	public UserService userService;
	
	public UserGetController(UserService us) {
		
		userService = us;
	}
	
	public ModelAndView beginRegisterUserWorkFlow() {
		return new ModelAndView(null, "/login.jsp");
		
	}
}
