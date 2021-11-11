package com.binu.sportyshoes.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.binu.sportyshoes.dto.CustomerCart;
import com.binu.sportyshoes.dto.OrderItem;
import com.binu.sportyshoes.dto.Shoe;
import com.binu.sportyshoes.service.CustomerCartService;
import com.binu.sportyshoes.service.ShoeService;
import com.binu.sportyshoes.service.UserLoginService;


@Controller
@SessionAttributes({"user_name", "user_password", "customer_cart"})
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    UserLoginService userLoginService;
    
    @Autowired
    CustomerCartService customerCartService;
    
    @Autowired
    ShoeService shoeService;

    @RequestMapping(value="/displayUserLoginPage", method = RequestMethod.GET)
    public String showUserLoginPage(ModelMap model){
        return "user/user-login-page";
    }
    
    @RequestMapping(value="/displayLoggedInCustomerHomePage", method = RequestMethod.GET)
    public String displayLoggedInCustomerHomePage(ModelMap model){
        return "user/user-logged-in-home-page";
    }

    @RequestMapping(value="/validateUserLogin", method = RequestMethod.POST)
    public String validateUserLogin(ModelMap model, @RequestParam String userName, @RequestParam String userPwd){

        boolean isValidUser = userLoginService.validateUser(userName, userPwd);

        if (!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");
            model.put("user_name", "");
            model.put("user_id", "");
            return "user/user-login-error-page";
        }

        model.put("errorMessage", "");
        model.put("user_name", userName);
        model.put("user_password", userPwd);
        
        CustomerCart customerCart = new CustomerCart();
        customerCart.setCustomerUsername(userName);
        List<OrderItem> listOfOrderItems = new ArrayList<>();
        customerCart.setOrderItems(listOfOrderItems);
        CustomerCart saved_cart = customerCartService.addCart(customerCart);
        model.put("customer_cart", saved_cart);

        return "user/user-logged-in-home-page";
    }


    @RequestMapping(value="/listAllSportyShoes", method = RequestMethod.GET)
    public String listAllSportyShoes(ModelMap model){
    	List<Shoe> listShoes = shoeService.getAllShoes();
    	model.addAttribute("listShoes", listShoes);
        return "user/user-list-all-shoes-page";
    }

    @RequestMapping(value="/searchSportyShoesPage", method = RequestMethod.GET)
    public String searchSportyShoesPage(ModelMap model){
    	List<String> shoeTypeList = Arrays.asList("Sneaker", "Boot", "Shoe");
    	model.addAttribute("shoeTypeList", shoeTypeList);
        return "user/user-search-sporty-shoes-page";
    }
}
