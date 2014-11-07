package models;

import javax.servlet.http.HttpServletRequest;

public class UserPostController
{
	private UserService userService;
	
	public UserPostController(UserService userService) {
		this.userService = userService;
		
	}
	
//	public ModelAndView commitLoginWorkflow(HttpServletRequest request) {
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		
//		//what are the security concerns
//		try {
//			User user = userService.login(username, password); 
//			request.getSession().setAttribute("user", user); 
//			return new ModelAndView(null, request.getContextPath() + "/home");
//		} catch (BadPasswordException e) {
//			//return to error page
//		}
//		
//	}
	
	public ModelAndView commitUserRegisterUsernWorkflow(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		
		RegisterUserModel model = new RegisterUserModel();
		if(!password.equals(confirmPassword)) {
			model.setErrorMessage("No");
			return new ModelAndView(model, "/login.jsp");
		}
		
		try {
			User user = userService.createUser(username, password);
			model.setUser(user);
			
			return new ModelAndView(model, "/WEB-INF/success.jsp");
		} catch(UsernameAlreadyExistsException e) {
			model.setErrorMessage("Username already exists");
			
			return new ModelAndView(model, "/login.jsp");
		}
	}
}
