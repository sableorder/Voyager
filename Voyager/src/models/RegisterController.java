package models;
import javax.servlet.http.HttpServletRequest;


public class RegisterController {
private UserService userService;
	
	public RegisterController(UserService userService) {
		this.userService = userService;
		
	}
	
	public ModelAndView commitUserRegisterUsernWorkflow(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		RegisterUserModel model = new RegisterUserModel();
		
		if(!password.equals(confirmPassword)) {
			model.setErrorMessage("No");
			return new ModelAndView(model, "/WEB-INF/register.jsp");
		}

		try {
			User user = userService.createUser(username, password);
			model.setUser(user);
			
			return new ModelAndView(model, "/WEB-INF/account/profile.jsp");
		} catch(UsernameAlreadyExistsException e) {
			model.setErrorMessage("Incorrect Login");
			
			return new ModelAndView(model, "/WEB-INF/account/login.jsp");
		}
	}
}
