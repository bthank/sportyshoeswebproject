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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.binu.sportyshoes.dto.Address;
import com.binu.sportyshoes.dto.CustomerCart;
import com.binu.sportyshoes.dto.OrderItem;
import com.binu.sportyshoes.dto.PaymentDetail;
import com.binu.sportyshoes.dto.Shipping;
import com.binu.sportyshoes.dto.ShippingChoice;
import com.binu.sportyshoes.dto.ShoeOrder;
import com.binu.sportyshoes.service.AddressService;
import com.binu.sportyshoes.service.CustomerCartService;
import com.binu.sportyshoes.service.PaymentDetailService;
import com.binu.sportyshoes.service.ShippingService;
import com.binu.sportyshoes.service.ShoeOrderService;
import com.binu.sportyshoes.service.ShoeService;

@Controller
@SessionAttributes({"savedShoeOrder","updatedShoeOrder"})
@RequestMapping(value="/checkout")
public class ShoeOrderController {
	
	@Autowired
	ShoeService shoeService;

	@Autowired
	ShoeOrderService shoeOrderService;
	
	@Autowired
	ShippingService shippingService;
	
	@Autowired
	CustomerCartService customerCartService;
	
	@Autowired
	PaymentDetailService paymentDetailService;
	
	@Autowired
	AddressService addressService;

	@RequestMapping(value = "/displaySelectShippingPage", method = RequestMethod.GET)
	public String displaySelectShippingPage(ModelMap model, HttpServletRequest request) {
    	
    	HttpSession session = request.getSession();
    	CustomerCart customerCart = (CustomerCart)session.getAttribute("customer_cart");
    	
    	System.out.println("In ShoeOrderController:2  displaySelectShippingPage()     session=" + session + "   session.getAttribute(\"user_name\")=" + session.getAttribute("user_name"));
    	if (session == null || session.getAttribute("user_name") == null || session.getAttribute("user_name").equals("")) {
    		session.setAttribute("usererror", "Sorry, you are not authorized to access this page.");
    		return "user/user-unauthorized-access-page";
    	}
    	
     	List<OrderItem> listOfAllOrderItems = customerCartService.getAllOrderItems(customerCart.getId());
    	
    	ShippingChoice shippingChoice = new ShippingChoice();
        List<String> shippingCarrierList = Arrays.asList("USPS", "FedEx", "UPS", "DHL");
        List<String> shippingTypeList    = Arrays.asList("Regular", "2_Day_Air", "3_Day_Air", "Overnight");
      
        model.addAttribute("listOfAllOrderItems", listOfAllOrderItems);
        model.addAttribute("shippingChoice", shippingChoice);
        model.addAttribute("shippingCarrierList", shippingCarrierList);
        model.addAttribute("shippingTypeList", shippingTypeList);
   	    	
        return "checkout/order-select-shipping-page";
	}
	
    @RequestMapping(value="/addShippingChoice", method = RequestMethod.POST)
    public String addShippingChoice(@ModelAttribute("shippingChoice") ShippingChoice shippingChoice, HttpServletRequest request) {
    	System.out.println("In ShoeOrderController:1  addShippingChoice()     shippingChoice=" + shippingChoice);
    	 
    	HttpSession session = request.getSession();
    	CustomerCart customerCart = (CustomerCart)session.getAttribute("customer_cart");
   
    	double subtotal = (double) session.getAttribute("subtotal");
    	double tax = (double) session.getAttribute("tax");
    	double total = (double) session.getAttribute("total");
    	int orderItemQuantity = (int) session.getAttribute("orderItemQuantity");
    	Shipping shipping = shippingService.getShippingById(shippingChoice.getShippingCarrier()+"_"+shippingChoice.getShippingType());
    	double shippingCost = Math.round((orderItemQuantity * shipping.getCostPerItem()) * 100.0) / 100.0;
    	double grandTotal = Math.round((total + shippingCost) * 100.0) / 100.0;
    	
    	
    	
       	System.out.println("In ShoeOrderController:2  addShippingChoice()     customerCart=" + customerCart);
       	
       	// build ShoeOrder
       	session.setAttribute("savedShoeOrder", null);
       	ShoeOrder shoeOrder = new ShoeOrder();
       	shoeOrder.setUserName(customerCart.getCustomerUsername());
       	long millis=System.currentTimeMillis();
       	shoeOrder.setDateOfOrder(new java.sql.Date(millis));
       	shoeOrder.setOrderItems(customerCart.getOrderItems());
       	 
       	System.out.println("\n\n\n\n");
       	String orderType = "";
       	for ( OrderItem item : customerCart.getOrderItems()) {
       		String shoeType = shoeService.findById(item.getShoeId()).getShoeType();
       		if (orderType.equals("")) {
       	       	System.out.println("In ShoeOrderController:2a  addShippingChoice()   where orderType equals blank   orderType=" + orderType);

       			orderType = shoeType;
       		} else if (orderType.equals(shoeType)) {
      	       	System.out.println("In ShoeOrderController:2b  addShippingChoice()   where orderType equals shoeType   orderType=" + orderType + "   shoeType=" + shoeType);

       			orderType = shoeType;
       		} else  {
      	       	System.out.println("In ShoeOrderController:2c  addShippingChoice()   where orderType does not equal shoeType and setting to Multitype   orderType=|" + orderType + "|   shoeType=|" + shoeType + "|");

       			orderType = "Multitype";
       		}
       	}
       	System.out.println("\n\n\n\n");
       	shoeOrder.setOrderType(orderType);
       	
       	shoeOrder.setShippingCarrier(shippingChoice.getShippingCarrier());
       	shoeOrder.setShippingChoice(shippingChoice.getShippingType());
       	shoeOrder.setOrderBeforeTaxCost(subtotal);
       	shoeOrder.setOrderTax(tax);
       	shoeOrder.setOrderShippingCost(shippingCost);
       	shoeOrder.setOrderGrandTotal(grandTotal);
       	shoeOrder.setShipped(false);
       //	ShoeOrder savedShoeOrder = shoeOrderService.addShoeOrder(shoeOrder);
       	System.out.println("In ShoeOrderController:3  addShippingChoice()     shoe order  saved to db  =====>        shoeOrder=" + shoeOrder + "    session.getAttribute(\"savedShoeOrder\")=" + session.getAttribute("savedShoeOrder"));
       	
       
       	
    	session.setAttribute("updatedShoeOrder", shoeOrder);
       	System.out.println("In ShoeOrderController:4  addShippingChoice()     session.getAttribute(\"updatedShoeOrder\")=" + session.getAttribute("updatedShoeOrder"));
   	
    	/*
    	if (savedShoeOrder.getId().equals(null)) {
    		String msg = "Sorry, shipping could not be added to the shoe order.  Please contact the Help Desk.";
    		session.setAttribute("error", msg);
    		return "checkout/user-shoe-order-add-shipping-failure-page";
    	} else {
    		String msg = "Shipping was successfully added to the shoe order.  Please click to add payment details.";
    		session.setAttribute("success", msg);
    		return "checkout/user-shoe-order-add-shipping-success-page";
    	} 
    	*/   	
    	
    	String msg = "Shipping was successfully added to the shoe order.  Please click to add payment details.";
		session.setAttribute("success", msg);
		return "checkout/user-shoe-order-add-shipping-success-page";
    }
    
    
	@RequestMapping(value = "/displayAddPaymentDetailsPage", method = RequestMethod.GET)
	public String displayAddPaymentDetailsPage(ModelMap model, HttpServletRequest request) {
    	
    	HttpSession session = request.getSession();
       	System.out.println("In ShoeOrderController:1  displayAddPaymentDetailsPage()     session.getAttribute(\"updatedShoeOrder\")=" + session.getAttribute("updatedShoeOrder"));

 
    	System.out.println("In ShoeOrderController:2  displayAddPaymentDetailsPage()     session=" + session + "   session.getAttribute(\"user_name\")=" + session.getAttribute("user_name"));
    	if (session == null || session.getAttribute("user_name") == null || session.getAttribute("user_name").equals("")) {
    		session.setAttribute("usererror", "Sorry, you are not authorized to access this page.");
    		return "user/user-unauthorized-access-page";
    	}
    	
    	PaymentDetail paymentDetail = new PaymentDetail();
        List<String> paymentTypeList = Arrays.asList("1 - CC", "2 - Debit");
        List<String> expMonthList    = Arrays.asList("01 - Jan", "02 - Feb", "03 - Mar", "04 - Apr", "05 - May", "06 - Jun", "07 - Jul", "08 - Aug",
        											 "09 - Sep", "10 - Oct", "11 - Nov", "12 - Dec");
        List<String> expYearList    = Arrays.asList("2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028",
				 "2029", "2030");
        List<String> countryList = Arrays.asList("USA", "Canada");
      
        model.addAttribute("paymentDetail", paymentDetail);
        model.addAttribute("paymentTypeList", paymentTypeList);
        model.addAttribute("expMonthList", expMonthList);
        model.addAttribute("expYearList", expYearList);
        model.addAttribute("countryList", countryList);
   	    	
        return "checkout/shoe-order-add-payment-details-page";
	}

    @RequestMapping(value="/addPaymentDetail", method = RequestMethod.POST)
    public String addPaymentDetail(@ModelAttribute("paymentDetail") PaymentDetail paymentDetail, HttpServletRequest request) {
    	System.out.println("In ShoeOrderController:1  addPaymentDetail()     paymentDetail=" + paymentDetail);

    	 
    	HttpSession session = request.getSession();
       	System.out.println("In ShoeOrderController:1a  addPaymentDetail()     session.getAttribute(\"updatedShoeOrder\")=" + session.getAttribute("updatedShoeOrder"));

    	CustomerCart customerCart = (CustomerCart)session.getAttribute("customer_cart");	
       	//double subtotal = (double) session.getAttribute("subtotal");
    	//double tax = (double) session.getAttribute("tax");
    	//double total = (double) session.getAttribute("total");
       	System.out.println("In ShoeOrderController:2  addPaymentDetail()     customerCart=" + customerCart);
       	
       	// save billingAddress to the db
       	Address billingAddress = new Address();
       	billingAddress.setAddressLine1(paymentDetail.getBillingAddress().getAddressLine1());
       	billingAddress.setAddressLine2(paymentDetail.getBillingAddress().getAddressLine2());
       	billingAddress.setCity(paymentDetail.getBillingAddress().getCity());
       	billingAddress.setState(paymentDetail.getBillingAddress().getState());
       	billingAddress.setZipCode(paymentDetail.getBillingAddress().getZipCode());
       	billingAddress.setCountry(paymentDetail.getBillingAddress().getCountry());
       	Address savedBillingAddress = addressService.addAddress(billingAddress);
       	System.out.println("In ShoeOrderController:3  addPaymentDetail()  billing address saved to db =====>  savedBillingAddress=" + savedBillingAddress);
       	
       	paymentDetail.setBillingAddress(savedBillingAddress);
       	
       	// add PaymentDetail record to DB
       	PaymentDetail savedPaymentDetail = paymentDetailService.addPaymentDetail(paymentDetail);
       	System.out.println("In ShoeOrderController:4  addPaymentDetail()   payment detail saved to db =====>    savedPaymentDetail=" + savedPaymentDetail);
       	
       	// build ShoeOrder
       	ShoeOrder shoeOrder =  (ShoeOrder)session.getAttribute("updatedShoeOrder");	 
       	shoeOrder.setPaymentDetail(savedPaymentDetail);
        	System.out.println("In ShoeOrderController:5  addPaymentDetail()     shoe order NOT YET saved to db  =====>       shoeOrder=" + shoeOrder);
       
       	
    	session.setAttribute("updatedShoeOrder", shoeOrder);
       	System.out.println("In ShoeOrderController:6  addPaymentDetail()     session.getAttribute(\"updatedShoeOrder\")=" + session.getAttribute("updatedShoeOrder"));

    	
  		String msg = "Payment detail was successfully added to the shoe order.  Please go to the next page to submit the order.";
		session.setAttribute("success", msg);
		return "checkout/user-shoe-order-add-paymentdetail-success-page";
    }
    
    
	@RequestMapping(value = "/displaySubmitShoeOrderPage", method = RequestMethod.GET)
	public String displaySubmitShoeOrderPage(ModelMap model, HttpServletRequest request) {
		System.out.println("In ShoeOrderController:2  displaySubmitShoeOrderPage()  ");
    	HttpSession session = request.getSession();
 
    	System.out.println("In ShoeOrderController:2  displaySubmitShoeOrderPage()     session=" + session + "   session.getAttribute(\"user_name\")=" + session.getAttribute("user_name"));
       	System.out.println("In ShoeOrderController:3  displaySubmitShoeOrderPage()     session.getAttribute(\"updatedShoeOrder\")=" + session.getAttribute("updatedShoeOrder"));

    	if (session == null || session.getAttribute("user_name") == null || session.getAttribute("user_name").equals("")) {
    		session.setAttribute("usererror", "Sorry, you are not authorized to access this page.");
    		return "user/user-unauthorized-access-page";
    	}
    	
    	ShoeOrder shoeOrder = new ShoeOrder();
    	model.addAttribute("shoeOrder", shoeOrder);
       	System.out.println("In ShoeOrderController:4  displaySubmitShoeOrderPage()     session.getAttribute(\"updatedShoeOrder\")=" + session.getAttribute("updatedShoeOrder"));

    	return "checkout/shoe-order-submit-page";
	}


    @RequestMapping(value="/submitShoeOrder", method = RequestMethod.POST)
    public String submitShoeOrder(HttpServletRequest request, @ModelAttribute("shoeOrder") PaymentDetail shoeOrder) {
    	System.out.println("In ShoeOrderController:1  submitShoeOrder()    ");

    	 
    	HttpSession session = request.getSession();
       	System.out.println("In ShoeOrderController:1a  submitShoeOrder()     session.getAttribute(\"updatedShoeOrder\")=" + session.getAttribute("updatedShoeOrder"));

       	// submit shoe order
       	ShoeOrder shoeOrderToSave =  (ShoeOrder)session.getAttribute("updatedShoeOrder");	
       	System.out.println("In ShoeOrderController:2  submitShoeOrder()    shoeOrderToSave=" + shoeOrderToSave);
     	ShoeOrder savedShoeOrder = shoeOrderService.addShoeOrder(shoeOrderToSave);
       	System.out.println("In ShoeOrderController:3  submitShoeOrder()        shoe order saved to db  =====>     savedShoeOrder=" + savedShoeOrder);
       
       	
    	session.setAttribute("updatedShoeOrder", savedShoeOrder);
    	
    	
    	if (savedShoeOrder.getId().equals(null)) {
    		String msg = "Sorry, the shoe order could not be submitted.  Please contact the Help Desk.";
    		session.setAttribute("error", msg);
    		return "checkout/user-shoe-order-submit-failure-page";
    	} else {
    		String msg = "The shoe order was successfully submitted.  Thank you for your order.";
    		session.setAttribute("success", msg);
    		// clear the customer's cart
    		session.setAttribute("customer_cart", null);
    		session.setAttribute("savedShoeOrder", null);
    		session.setAttribute("updatedShoeOrder", null);
    		return "checkout/user-shoe-order-submit-success-page";
    	}   
    }
}
