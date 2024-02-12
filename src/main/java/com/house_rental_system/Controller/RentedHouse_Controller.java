package com.house_rental_system.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.house_rental_system.Entity.Customer;
import com.house_rental_system.Entity.House;
import com.house_rental_system.Entity.Owner;
import com.house_rental_system.Entity.RentedHouse;
import com.house_rental_system.Service.CustomerService;
import com.house_rental_system.Service.HouseService;
import com.house_rental_system.Service.OwnerService;

import org.springframework.beans.factory.annotation.Autowired;

import com.house_rental_system.Service.RentedHouseService;

@Controller
public class RentedHouse_Controller {
	
	@Autowired
	private RentedHouseService RentedHouseService;
	@Autowired
	private HouseService HouseService;
	@Autowired
	private CustomerService cs;
	@Autowired
	private OwnerService ownerService;

	@GetMapping(value = "/rent/{h_id}/house/{c_id}")
	public String rentHouse(@PathVariable(value = "h_id", required = true) int id,
			@PathVariable(value = "c_id", required = true) int c_id, ModelMap mymodel) {
		

		House h = HouseService.getHouse(id);
		
	Customer customer = cs.getCustomer(c_id);
		h.setRent_status(true);
		Owner owner = ownerService.getOwner(h.getOwnerId());
		h.setCustomer(customer);
		
		

		System.out.println("***************************************");
		HouseService.updateHouse(h);
		
//		RentedHouseService.addRentedHouse(rh);
//		mymodel.addAttribute("msg", "House is Rented with id: "+ h_id + " with rent: "+rh.getHouse_rent() +" which is at "+rh.getHouse_address());
		return "Home";
	}
	

}
