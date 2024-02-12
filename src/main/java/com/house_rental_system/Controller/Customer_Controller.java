package com.house_rental_system.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.house_rental_system.Entity.Customer;
import com.house_rental_system.Entity.House;
import com.house_rental_system.Service.HouseService;
import com.house_rental_system.Service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class Customer_Controller {
	@Autowired
	private CustomerService CustomerService;
	
	@Autowired
	private HouseService HouseService;

	@PostMapping("/Customer/{id}")
	public String getCustomer(@PathVariable int id, ModelMap CustomerModel) {
		Customer Customer = CustomerService.getCustomer(id);
		CustomerModel.addAttribute("Customer", Customer);
		return "ViewCustomer";
	}


	@GetMapping("/Customers")
	public String getCustomers(ModelMap CustomerModel) {
		List<Customer> customers = CustomerService.getCustomers();
		CustomerModel.addAttribute("customers", customers);
		return "ViewCustomers";
	}

	@GetMapping("/customer/R")
	public String addPage() {
		return "AddCustomer";
	}

	@PostMapping("/add/customer")
	public String addCustomer(
			@RequestParam(value = "customer_name", required = true) String customer_name,
			@RequestParam(value = "customer_email", required = true) String customer_email,
			@RequestParam(value = "customer_username", required = true) String customer_username,
			@RequestParam(value = "customer_password", required = true) String customer_password,
			@RequestParam(value = "customer_phone_no", required = true) String customer_phone_no) {
		Customer Customer = new Customer();
		Customer.setCustomer_name(customer_name);
		Customer.setCustomer_email(customer_email);
		Customer.setCustomer_username(customer_username);
		Customer.setCustomer_password(customer_password);
		Customer.setCustomer_phone_no(customer_phone_no);
		CustomerService.addCustomer(Customer);
//		CustomerModel.addAttribute("msg", "Customer added successfully");
//		List<Customer> Customers = CustomerService.getCustomers();
//		CustomerModel.addAttribute("Customers", Customers);
		return "Login_C";
	}
	
	@GetMapping("/customer/L")
	public String loginUser()
	{
		return "Login_C";
	}
	
	@PostMapping("/logincustomer")
	public String loginCustomer(@RequestParam(value = "customer_username", required = true) String customer_username,
			@RequestParam(value = "customer_password", required = true) 
	String customer_password, HttpServletRequest request, ModelMap m)
	{
		List<Customer> c = CustomerService.getCustomers();
		
		for(Customer customer : c)
		{
			if((customer.getCustomer_username()).equals(customer_username) && (customer.getCustomer_password()).equals(customer_password))
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("username", customer_username);
				session.setAttribute("usertype", "Customer");
				session.setAttribute("id", customer.getCustomer_id());
				List <House> houses = HouseService.getHouses();
				m.addAttribute("houses", houses);
				return "Home";
			}
		}
		String msg = "Username or password is wrong ! Please Try Again";
		m.addAttribute("message", msg);
		System.out.println(customer_username);
		System.out.println(customer_password);
		return "Login_C";
	}
	@PostMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "Home";
	}
	
	
}
