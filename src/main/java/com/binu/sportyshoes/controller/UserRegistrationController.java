package com.binu.sportyshoes.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.binu.sportyshoes.dto.User;
import com.binu.sportyshoes.service.UserRegistrationServiceImpl;


@Controller
@RequestMapping("/user")
public class UserRegistrationController {

    @Autowired
    UserRegistrationServiceImpl userRegistrationService;

    @RequestMapping(value="/displayUserRegistrationPage", method = RequestMethod.GET)
    public String showUserRegistrationPage(Model model){
    	User user = new User();
    	model.addAttribute("user", user);
        return "user/user-registration-form";
    }
    
    @RequestMapping(value="/registerUser", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user, HttpServletRequest request) {
    	System.out.println(user);
    	// first check if username already exists in db
    	boolean alreadyExists = userRegistrationService.doesUserExistInDB(user.getUserName());
    	HttpSession session = request.getSession();
    	session.setAttribute("username", user.getUserName());
    	if (!alreadyExists) {
    		user = userRegistrationService.registerUser(user);
    		return "user/user-registration-success";
    	} else {
    		String msg = "Sorry, the user name " + user.getUserName() + " already exists.  Please register using a different user name.";
    		session.setAttribute("error", msg);
    		return "user/user-registration-failure";
    	}
 
    }


}
