package com.house_rental_system.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;
import com.house_rental_system.Entity.House;
import com.house_rental_system.Entity.Owner;
import com.house_rental_system.Service.HouseService;
import com.house_rental_system.Service.OwnerService;
import com.house_rental_system.Service.RentedHouseService;

@Controller
public class House_Controller {
	@Autowired
	private HouseService HouseService;
	
	@Autowired
	private OwnerService ownerService;
	
	@Autowired
	private RentedHouseService RentedHouseService;
	
	@GetMapping("/add/house/{id}")
	public String addHouse(@PathVariable int id, ModelMap m) {
		m.addAttribute("owner_id", id);
		return "AddHouse";
	}
	
	@PostMapping("/addHouse/{Id}")
	public String AddHouse(@PathVariable(value = "Id", required = true) int owner_id, 
			@RequestParam(value = "house_address") String house_addr,
			@RequestParam(value = "house_rent") Double house_rent,
			@RequestParam(value = "house_city") String house_city,
			@RequestParam(value = "house_info") String house_info, ModelMap m) {
		
		House h = new House();
		h.setCity(house_city);
		h.setHouse_info(house_info);
		h.setRent(house_rent);
		h.setHouse_address(house_addr);
		
		Owner owner = ownerService.getOwner(owner_id);
		h.setOwner(owner);
		HouseService.addHouse(h);
		String msg = "New House with House-Id: "+h.getHouse_id()+" with "+ house_info + " of Rent: "+ house_rent+ " added successfully.";
		
		m.addAttribute("msg", msg);
		m.addAttribute("owner_id", owner_id);
		return "AddHouse";
	}
	
	@GetMapping("/non_rented/house/{id}")
	public String ViewHouses(@PathVariable(value = "id", required = true) int owner_id, ModelMap m) {
		ArrayList <House> Houses = (ArrayList<House>) HouseService.getHouses();
		ArrayList<House> houses = new ArrayList<House>();
		for(House h : Houses) {
			if(h.getOwnerId()==(owner_id)) {
				houses.add(h);
				System.out.println(h);
			}
		}
		m.addAttribute("houses", houses);
		m.addAttribute("owner_id", (owner_id));
		return "Non-Rented-Houses";	
	}
	
	@GetMapping("/delete/{h_id}/house/{owner_id}")
	public String DeleteHouse(@PathVariable(value = "h_id", required = true) int h_id,
			@PathVariable(value = "owner_id", required = true) int owner_id, ModelMap mymodel) {
		HouseService.deleteHouse(h_id);
		mymodel.addAttribute("owner_id", owner_id);
		return "redirect:/non_rented/house/{owner_id}";
	}
	
	@GetMapping("/house/{h_id}")
	public String showHouse(@PathVariable(value = "h_id", required = true) int h_id, ModelMap mymodel) {
		House h = HouseService.getHouse(h_id);
		mymodel.addAttribute("house", h);
		return "ViewHouse";
	}
	

}
