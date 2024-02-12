package com.house_rental_system.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Registration {
	
	
	@GetMapping("/home")
	public String Home() {
		return "Home";
	}
	
	@PostMapping("/R")
	public String R(@RequestParam("userType") String usertype) {
		System.out.println(usertype);
		if(usertype.equals("Admin")) {
			return "redirect:/admin/L";
		}
		else if(usertype.equals("Customer")) {
			return "redirect:/customer/R";
		}
		else {
			return "redirect:/owner/R";
		}
	}
	
	@PostMapping("/L")
	public String L(@RequestParam("userType") String usertype) {
		if(usertype.equals("Admin")) {
			return "redirect:/admin/L";
		}
		else if(usertype.equals("Customer")) {
			return "redirect:/customer/L";
		}
		else {
			return "redirect:/owner/L";
		}
	}
		
}
