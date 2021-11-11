package com.binu.sportyshoes.controller;

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

import com.binu.sportyshoes.dto.Shoe;
import com.binu.sportyshoes.service.ShoeService;

@Controller
@RequestMapping(value="/shoe")
public class ShoeController {

	
	@Autowired
	ShoeService shoeService;
	
	
    @RequestMapping(value="/displayAddShoeToInventoryPage", method = RequestMethod.GET)
    public String displayAddShoeToInventoryPage(ModelMap model, HttpServletRequest request){
    	
    	HttpSession session = request.getSession();
    	System.out.println("In ShoeController: displayAddShoeToInventoryPage()   session=" + session);
    	if (session == null || session.getAttribute("admin_user") == null || !session.getAttribute("admin_user").equals("true")) {
    		session.setAttribute("usererror", "Sorry, you are not authorized to access this page.");
    		return "user/user-unauthorized-access-page";
    	}
    	
    	Shoe shoe = new Shoe();
        List<String> shoeTypeList = Arrays.asList("Boot", "Shoe", "Sneaker");
        List<String> brandList = Arrays.asList("Adidas", "Nike", "Reebok", "Skechers", "Puma", "Wilson", "Bostonian", "Arnot",
        		                               "Fendi", "Gucci", "Louis Vitton", "Tommy Hilfiger", "Nautica", "Pearl", "Timberland", "UrbanWear", "Other");  
        List<String> colorList = Arrays.asList("White", "Black", "Brown", "Red", "Green", "Blue", "Pink", "Orange", "Yellow", "Silver", "Gold", "Multicolored", "Other");
        List<String> sizeList = Arrays.asList("1", "1.5", "2", "2.5", "3", "3.5", "4", "4.5", "5", "5.5", "6", "6.5", "7", "7.5", "8", "8.5",
        		                              "9", "9.5", "10", "10.5", "11", "11.5", "12", "12.5");
        List<String> countryOfManufactureList = Arrays.asList("USA", "Mexico", "Canada", "China", "India", "Brazil", "Turkey", "Russia",
                "Venezuela", "Argentina", "France", "Italy", "Switzerland", "Austria", "Sri Lanka", "England", "Other");        

        model.addAttribute("shoe", shoe);
        model.addAttribute("shoeTypeList", shoeTypeList);
        model.addAttribute("brandList", brandList);
        model.addAttribute("colorList", colorList);
        model.addAttribute("sizeList", sizeList);
        model.addAttribute("countryOfManufactureList", countryOfManufactureList);    	
    	
        return "shoe/admin-add-shoe-form";
    }	
	
    @RequestMapping(value="/addShoeToInventory", method = RequestMethod.POST)
    public String addShoeToInventory(@ModelAttribute("shoe") Shoe shoe, HttpServletRequest request) {
    	System.out.println(shoe);
    	 
    	HttpSession session = request.getSession();
    	session.setAttribute("shoename", shoe.getShoeName());
    	Shoe addedShoe = shoeService.addShoeToInventory(shoe);
    	
    	if (addedShoe.getId().equals(null)) {
    		String msg = "Sorry, the shoe  " + addedShoe.getStockId() + " : " + addedShoe.getShoeName() + "  could not be added.  Please contact the Help Desk.";
    		session.setAttribute("errormsg", msg);
    		return "shoe/admin-add-shoe-failure-page";
    	} else {
    		String msg = addedShoe.getStockId() + " : " + addedShoe.getShoeName();
    		session.setAttribute("successmsg", msg);
    		return "shoe/admin-add-shoe-success-page";
    	}    	
    }
    
	
	
	
}
