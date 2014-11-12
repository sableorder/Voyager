package Controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.UsernameAlreadyExistsException;
import model.DataLocator;
import models.Account;
import models.DataService;
import models.ModelAndView;
import models.RegisterUserModel;
import models.Roles;


public class RegisterController {
	
	private DataService dataService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String filePath;
	
	public RegisterController(HttpServletRequest request, HttpServletResponse response, DataService dataService, String FilePath) {
		this.request = request;
		this.response = response;
		this.dataService = dataService;
	}
	
	public ModelAndView commitUserRegisterUser() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String email = request.getParameter("email");
		String confirmEmail = request.getParameter("confirmEmail");
		String avatarPath = FileUploadController.processRequest(request, response, filePath);
		
		
		RegisterUserModel model = new RegisterUserModel();
		
		if(!password.equals(confirmPassword)) {
			model.setErrorMessage("Bad username/password.");
			return new ModelAndView(model, "/WEB-INF/register.jsp");
		}

		try {
			Account user = new Account(username, email, avatarPath, Roles.User, password);
			dataService.registerUser(user);
			model.setUser(user);
			return new ModelAndView(model, "/WEB-INF/account/profile.jsp");
		} catch(UsernameAlreadyExistsException e) {
			model.setErrorMessage("Incorrect Login");
			
			return new ModelAndView(model, "/WEB-INF/account/login.jsp");
		}
	}
}
