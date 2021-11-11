package com.binu.sportyshoes.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.binu.sportyshoes.dto.Admin;
import com.binu.sportyshoes.dto.OrderItem;
import com.binu.sportyshoes.dto.SearchShoeOrderItem;
import com.binu.sportyshoes.dto.SearchShoeOrdersChoice;
import com.binu.sportyshoes.dto.SearchUserChoice;
import com.binu.sportyshoes.dto.ShoeOrder;
import com.binu.sportyshoes.dto.User;
import com.binu.sportyshoes.service.AdminLoginService;
import com.binu.sportyshoes.service.AdminService;
import com.binu.sportyshoes.service.ShoeOrderService;
import com.binu.sportyshoes.service.UserService;


@Controller
@SessionAttributes({"admin_user","adminusername","adminpassword"})
@RequestMapping(value="/admin")
public class AdminController {

    @Autowired
    AdminLoginService adminLoginService;
    
    @Autowired
    AdminService adminService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    ShoeOrderService shoeOrderService;

    @RequestMapping(value="/displayAdminLoginPage", method = RequestMethod.GET)
    public String showAdminLoginPage(ModelMap model){
        return "admin/admin-login-page";
    }

    @RequestMapping(value="/validateAdminLogin", method = RequestMethod.POST)
    public String validateAdminLogin(ModelMap model, @RequestParam String adminUserName, @RequestParam String adminPwd, HttpServletRequest request){

    	System.out.println("In AdminController: validateAdminLogin()    adminUserName=" + adminUserName + "     adminPwd=" + adminPwd);
        boolean isValidAdminUser = adminLoginService.validateAdminUser(adminUserName, adminPwd);
        
       	HttpSession session = request.getSession();
       	

        if (!isValidAdminUser) {
            model.put("errorMessage", "Invalid Credentials");
            model.put("admin_user", "false");
            
           	String msg = "Invalid credentials.  Either admin user " + adminUserName + " does not exist or the username/password is incorrect.";
        	session.setAttribute("adminerror", msg);
        	System.out.println("In AdminController: validateAdminLogin()    adminerror=" + session.getAttribute("adminerror"));
            return "admin/admin-login-error-page";
        }

        model.put("admin_user", "true");
        model.put("adminusername", adminUserName);
        model.put("adminpassword", adminPwd);

        return "admin/admin-logged-in-home-page";
    }

    @RequestMapping(value="/displayAdminHomePage", method = RequestMethod.GET)
    public String showAdminHomePage(ModelMap model, HttpServletRequest request){
    	
    	HttpSession session = request.getSession();
    	System.out.println("In AdminController:1 showAdminHomePage()   session=" + session);
    	if (session == null || session.getAttribute("admin_user") == null || !session.getAttribute("admin_user").equals("true")) {
    		session.setAttribute("usererror", "Sorry, you are not authorized to access this page.");
    		return "user/user-unauthorized-access-page";
    	}
    	
        return "admin/admin-logged-in-home-page";
    }
    

    @RequestMapping(value="/displayAdminUpdatePasswordPage", method = RequestMethod.GET)
    public String displayAdminUpdatePasswordPage(ModelMap model, HttpServletRequest request){
    	
    	HttpSession session = request.getSession();
    	System.out.println("In AdminController:1  displayAdminUpdatePasswordPage()   session=" + session + "   session.getAttribute(\"adminusername\")=" + session.getAttribute("adminusername"));
    	if (session == null || session.getAttribute("admin_user") == null || !session.getAttribute("admin_user").equals("true")) {
    		session.setAttribute("usererror", "Sorry, you are not authorized to access this page.");
    		return "user/user-unauthorized-access-page";
    	}
    	
    	Admin admin = new Admin();
    	admin.setAdminUserName((String)session.getAttribute("adminusername"));
    	admin.setAdminPassword((String)session.getAttribute("adminpassword"));
    	
        return "admin/admin-update-password-page";
    }
   
    @RequestMapping(value="/updateAdminPassword", method = RequestMethod.POST)
    public String updateAdminPassword(ModelMap model, @RequestParam String adminUserName, @RequestParam String adminPwd, HttpServletRequest request) {
    	System.out.println("In AdminController:1 updateAdminPassword() ");
    	System.out.println("In AdminController:2 updateAdminPassword()   adminUserName=" + adminUserName + "    adminPwd=" + adminPwd);
    	HttpSession session = request.getSession();
    	String oldpassword = (String) session.getAttribute("adminpassword");
    	Admin newAdminRec = adminService.updateAdminPassword(adminUserName, adminPwd);
    	
    	if (newAdminRec.getAdminPassword().equals(oldpassword)) {
    		return "admin/admin-update-password-failure-page";
    	} else {
    		return "admin/admin-update-password-success-page";
    	}
    }
    

    @RequestMapping(value="/displaySignedUpUsersPage", method = RequestMethod.GET)
    public String displaySignedUpUsersPage(ModelMap model){
       	List<User> listSignedUpUsers = userService.getAllUsers();
    	model.addAttribute("listSignedUpUsers", listSignedUpUsers);
        return "admin/admin-signed-up-users-page";
    }
    
    @RequestMapping(value="/displaySearchUsersPage", method = RequestMethod.GET)
    public String displaySearchUsersPage(ModelMap model){
    	List<String> genderTypeList = Arrays.asList("All", "Male", "Female", "Other");
    	model.addAttribute("genderTypeList", genderTypeList);
    	List<String> ageTypeList = Arrays.asList("All", "< 20", "20-29", "30-39", "40-49", "50-59", "> 59");
    	model.addAttribute("ageTypeList", ageTypeList);
    	SearchUserChoice searchUserChoice = new SearchUserChoice();
    	model.addAttribute("searchUserChoice", searchUserChoice);
        return "admin/admin-search-users-page";
    }
    
    
    @RequestMapping(value="/searchUsers", method = RequestMethod.POST)
    public String searchUsers(@ModelAttribute("searchUserChoice") SearchUserChoice searchUserChoice, ModelMap model, @RequestParam String genderType, @RequestParam String ageType) {
    	System.out.println("In AdminController:1 searchUsers() ");
    	System.out.println("In AdminController:2 searchUsers()   genderType=" + genderType + "    ageType=" + ageType);
  
    	List<User> listOfUsers = new ArrayList<>();
    	if (ageType.equals("All") && genderType.equals("All")) {
    		listOfUsers = userService.getAllUsers();	
    	} else if (ageType.equals("All") && (!genderType.equals("All"))) {
    		listOfUsers = userService.findByGender(genderType);
    	} else if (!ageType.equals("All") && (genderType.equals("All"))) {
    		if (ageType.equals("< 20")) {
    			listOfUsers = userService.findByAgeLessThan(20);
    		} else if (ageType.equals("20-29")) {
    			listOfUsers = userService.findByAgeBetween(20, 29);
    		} else if (ageType.equals("30-39")) {
    			listOfUsers = userService.findByAgeBetween(30, 39);
    		} else if (ageType.equals("40-49")) {
    			listOfUsers = userService.findByAgeBetween(40, 49);
    		} else if (ageType.equals("40-49")) {
    			listOfUsers = userService.findByAgeBetween(40, 49);
    		} else if (ageType.equals("50-59")) {
    			listOfUsers = userService.findByAgeBetween(50, 59);
    		} else if (ageType.equals("> 59")) {
    			listOfUsers = userService.findByAgeGreaterThan(59);
    		}
    	} else if (!ageType.equals("All") && (!genderType.equals("All"))) {
    		if (ageType.equals("< 20")) {
    			listOfUsers = userService.findByAgeLessThanAndGender(20, genderType);
    		} else if (ageType.equals("20-29")) {
    			listOfUsers = userService.findByAgeBetweenAndGender(20, 29, genderType);
    		} else if (ageType.equals("30-39")) {
    			listOfUsers = userService.findByAgeBetweenAndGender(30, 39, genderType);
    		} else if (ageType.equals("40-49")) {
    			listOfUsers = userService.findByAgeBetweenAndGender(40, 49, genderType);
    		} else if (ageType.equals("40-49")) {
    			listOfUsers = userService.findByAgeBetweenAndGender(50, 59, genderType);
    		} else if (ageType.equals("> 59")) {
    			listOfUsers = userService.findByAgeGreaterThanAndGender(59, genderType);
    		}
    	}
    	
    	model.addAttribute("listOfUsers", listOfUsers);
    	System.out.println("In AdminController:2 searchUsers()   listOfUsers=" + listOfUsers);

    	return "admin/admin-search-users-result-page";
    }
    
    
    @RequestMapping(value="/displayPurchaseReportPage", method = RequestMethod.GET)
    public String displayPurchaseReportsPage(ModelMap model){
       	List<ShoeOrder> listShoeOrders = shoeOrderService.getAllShoeOrders();
    	model.addAttribute("listShoeOrders", listShoeOrders);
        return "admin/admin-purchase-report-page";
    }    
    
    @RequestMapping(value="/displaySearchShoeOrdersPage", method = RequestMethod.GET)
    public String displaySearchShoeOrdersPage(ModelMap model){
    	List<String> dateTypeList = Arrays.asList("All Orders", "Orders today", "Orders Last 7 days", "Orders Last 2 weeks", "Orders This Month", "Orders This Year");
    	model.addAttribute("dateTypeList", dateTypeList);
    	List<String> categoryOrderTypeList = Arrays.asList("Sneaker", "Boot", "Shoe", "Multitype");
    	model.addAttribute("categoryOrderTypeList", categoryOrderTypeList);
    	
       	SearchShoeOrdersChoice searchShoeOrdersChoice = new SearchShoeOrdersChoice();
    	model.addAttribute("searchShoeOrdersChoice", searchShoeOrdersChoice);
        return "admin/admin-search-shoe-orders-page";
    }    
    
    
    @RequestMapping(value="/searchShoeOrders", method = RequestMethod.POST)
    public String searchShoeOrders(@ModelAttribute("searchShoeOrdersChoice") SearchShoeOrdersChoice searchShoeOrdersChoice, ModelMap model, @RequestParam String dateOfOrderType, @RequestParam String categoryOrderType) {
    	System.out.println("In AdminController:1 searchShoeOrders() ");
    	System.out.println("In AdminController:2 searchShoeOrders()    dateOfOrderType=" +  dateOfOrderType + "    categoryOrderType=" + categoryOrderType);
  
    	List<ShoeOrder> listOfShoeOrders = new ArrayList<>();
       	List<SearchShoeOrderItem> listOfShoeOrderItems = new ArrayList<>();
       	
    	if (dateOfOrderType.equals("All Orders")) { 
    		listOfShoeOrders = shoeOrderService.findByOrderType(categoryOrderType);
        	System.out.println("In AdminController:3 searchShoeOrders()    listOfShoeOrders=" +  listOfShoeOrders);
 
        	for (ShoeOrder shoeOrder: listOfShoeOrders) {
        		System.out.println("In AdminController:4 searchShoeOrders()    shoeOrder=" +  shoeOrder);
        		SearchShoeOrderItem searchShoeOrderItem = new SearchShoeOrderItem();
        		searchShoeOrderItem.setShoeOrderId(shoeOrder.getId());
        		searchShoeOrderItem.setUserName(shoeOrder.getUserName());
        		searchShoeOrderItem.setDateOfOrder(shoeOrder.getDateOfOrder());
        		searchShoeOrderItem.setOrderType(shoeOrder.getOrderType());
        		searchShoeOrderItem.setShippingCarrier(shoeOrder.getShippingCarrier());
        		searchShoeOrderItem.setShippingChoice(shoeOrder.getShippingChoice());
        		searchShoeOrderItem.setShipped(shoeOrder.isShipped());
        		searchShoeOrderItem.setShippedDate(shoeOrder.getShippedDate());
        		
        	 	for (OrderItem orderItem: shoeOrder.getOrderItems()) {
        			searchShoeOrderItem.setOrderItemId(orderItem.getId());
        			searchShoeOrderItem.setShoeId(orderItem.getShoeId());
        			searchShoeOrderItem.setShoeName(orderItem.getShoeName());
        			searchShoeOrderItem.setPurchaseQuantity(orderItem.getPurchaseQuantity());
        			searchShoeOrderItem.setImageUrl(orderItem.getImageUrl());
        			searchShoeOrderItem.setPrice(orderItem.getPrice());
        			
                	System.out.println("In AdminController:4a searchShoeOrders()    searchShoeOrderItem=" +  searchShoeOrderItem);
                	SearchShoeOrderItem newSearchShoeOrderItem = searchShoeOrderItem;
        			listOfShoeOrderItems.add(newSearchShoeOrderItem);
        			
        			 
        			
        		}
        		 
        		model.addAttribute("listOfShoeOrderItems", listOfShoeOrderItems);

        	}
   		
     	} else if (dateOfOrderType.equals("Orders today")) {
     		
     	} else if (dateOfOrderType.equals("Orders Last 7 days")) {
     		
     	} else if (dateOfOrderType.equals("Orders Last 2 weeks")) {
     		
     	} else if (dateOfOrderType.equals("Orders This Month")) {
     		
     	} else if (dateOfOrderType.equals("Orders This Year")) {
     		
     	}
    		
    	System.out.println("In AdminController:99 searchShoeOrders()    listOfShoeOrderItems=" +  listOfShoeOrderItems);
    	return "admin/admin-search-shoe-orders-result-page";
    }
}
