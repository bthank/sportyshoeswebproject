package com.binu.sportyshoes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.binu.sportyshoes.dto.CustomerCart;
import com.binu.sportyshoes.dto.OrderItem;
import com.binu.sportyshoes.service.CustomerCartService;

@Controller
@SessionAttributes({"subtotal","tax","total","orderItemQuantity"})
@RequestMapping(value="/cart")
public class CustomerCartController {
	
	@Autowired
	CustomerCartService customerCartService;
	

    @RequestMapping(value="/displayCustomerCartPage", method = RequestMethod.GET)
    public String displayCustomerCartPage(ModelMap model, HttpServletRequest request, HttpServletResponse response){
    	System.out.println("In CustomerCartController:1 displayCustomerCartPage()   ");
    	HttpSession session = request.getSession();
    	CustomerCart customerCart = (CustomerCart)session.getAttribute("customer_cart");
       	System.out.println("In CustomerCartController:2 displayCustomerCartPage()     customerCart=" + customerCart);
    	List<OrderItem> listOfAllOrderItems = customerCartService.getAllOrderItems(customerCart.getId());
    	// loop thru the list of order items and sum up the subtotal, tax and total amounts
    	double subtotal = 0.0;
    	double tax = 0.0;
    	double total = 0.0;
    	int orderItemQuantity = 0;
    	for (OrderItem item : listOfAllOrderItems) {
    		subtotal += item.getPurchaseQuantity() * item.getPrice();
    		orderItemQuantity += item.getPurchaseQuantity(); 
    	}
    	subtotal = Math.round(subtotal * 100.0) / 100.0;
    	tax = Math.round(subtotal * 0.06 * 100.0) / 100.0;
    	total = Math.round((subtotal + tax)  * 100.0) / 100.0;
    	System.out.println("In CustomerCartController:3 displayCustomerCartPage()     listOfAllOrderItems=" + listOfAllOrderItems);
    	model.addAttribute("listOfAllOrderItems", listOfAllOrderItems);
    	model.addAttribute("subtotal", subtotal);
    	model.addAttribute("tax", tax);
    	model.addAttribute("total", total);
    	model.addAttribute("orderItemQuantity", orderItemQuantity);
    	
        return "user/cart/user-cart-page";
    
    }
    
	@RequestMapping(value="/addItemToCart/{id}", method = RequestMethod.GET)
	public String addItemToCart(@PathVariable(name = "id") int shoeId, ModelMap model, HttpServletRequest request) {
		System.out.println("In CustomerCartController:1 addItemToCart()   shoeId=" + shoeId);
		HttpSession session = request.getSession();
		System.out.println("In CustomerCartController:1a addItemToCart()   session=" + session);
		CustomerCart customerCart = (CustomerCart)session.getAttribute("customer_cart");
		String userName = (String)session.getAttribute("user_name");
		System.out.println("In CustomerCartController:1b addItemToCart()   customerCart=" + customerCart);
		if (customerCart == null) {
	        customerCart = new CustomerCart();
	        customerCart.setCustomerUsername(userName);
        	List<OrderItem> listOfOrderItems = new ArrayList<>();
        	customerCart.setOrderItems(listOfOrderItems);
            CustomerCart saved_cart = customerCartService.addCart(customerCart);
            model.put("customer_cart", saved_cart);
            session.setAttribute("customer_cart", saved_cart);
		}
        
		
		
		try {
			System.out.println("In CustomerCartController:1c addItemToCart()");
			
			int customerCartId = customerCart.getId();
			System.out.println("In CustomerCartController:2 addItemToCart()   shoeId=" + shoeId + "    customerCartId=" + customerCartId);

			OrderItem item = new OrderItem();
			item.setShoeId(shoeId);
			item.setPurchaseQuantity(1);

			CustomerCart updatedCart = customerCartService.addItemToCart(customerCartId, item);
			model.put("customer_cart", updatedCart);
			session.setAttribute("customer_cart", updatedCart);
			customerCart = (CustomerCart)session.getAttribute("customer_cart");
			System.out.println("In CustomerCartController:3 addItemToCart()   customerCart=" + customerCart);
			
			session.setAttribute("success", "Excellent!  You have successfully added a sporty shoe to your cart!");
			return "user/cart/user-cart-item-successfully-added-page";
			
		} catch (Exception e) {
			session.setAttribute("error", "Sorry, the item could not be added.   Try again later.");
			return "user/cart/user-cart-item-add-failure-page";
		}
	}
	
//deleteOrderItem
	@RequestMapping(value="/deleteOrderItem/{id}", method = RequestMethod.GET)
	public String deleteOrderItem(@PathVariable(name = "id") int orderItemId, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("In CustomerCartController:1 deleteOrderItem()   orderItemId=" + orderItemId);
		HttpSession session = request.getSession();
		System.out.println("In CustomerCartController:1a deleteOrderItem()   session=" + session);
		CustomerCart customerCart = (CustomerCart)session.getAttribute("customer_cart");
		System.out.println("In CustomerCartController:1b deleteOrderItem()   customerCart=" + customerCart);
		try {
			System.out.println("In CustomerCartController:1c deleteOrderItem()");
	
			int customerCartId = customerCart.getId();
			System.out.println("In CustomerCartController:2 deleteOrderItem()   orderItemId=" + orderItemId + "    customerCartId=" + customerCartId);

			customerCartService.deleteItemFromCart(customerCartId, orderItemId);
						
			session.setAttribute("success", "You have successfully deleted the item from your cart.");
			return "user/cart/user-cart-item-delete-success-page";

			
		} catch (Exception e) {
			session.setAttribute("error", "Sorry, the item could not be deleted.   Try again later.");
			return "user/cart/user-cart-item-delete-failure-page";
		}
	}	
	
	
}
