package com.harish.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	//http://localhost:8080/login?name=Hari
	@RequestMapping(value="/",method = RequestMethod.GET)
	//@ResponseBody
	public String gotoWelcomePage(ModelMap model) {
		//System.out.println("Requets param is " + name); //  Not recommended in Production code
		model.put("name", getLoggedinUsername());
		return "Welcome";
		
	}
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
		}
	
}