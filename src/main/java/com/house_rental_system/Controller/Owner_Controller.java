package com.house_rental_system.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.house_rental_system.Entity.Owner;
import com.house_rental_system.Service.OwnerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class Owner_Controller {
	@Autowired
	private OwnerService OwnerService;

	@PostMapping("/owner/{id}")
	public String getowner(@PathVariable int id, ModelMap ownerModel) {
		Owner owner = OwnerService.getOwner(id);
		ownerModel.addAttribute("owner", owner);
		return "ViewOwner";
	}


	@GetMapping("/owners")
	public String getowners(ModelMap ownerModel) {
		List<Owner> owners = OwnerService.getOwners();
		ownerModel.addAttribute("owners", owners);
		return "ViewOwners";
	}

	@GetMapping("/owner/R")
	public String addPage() {
		return "AddOwner";
	}

	@PostMapping("/add/owner")
	public String addowner(
			@RequestParam(value = "owner_name", required = true) String owner_name,
			@RequestParam(value = "owner_email", required = true) String owner_email,
			@RequestParam(value = "owner_username", required = true) String owner_username,
			@RequestParam(value = "owner_password", required = true) String owner_password,
			@RequestParam(value = "owner_phone_no", required = true) String owner_phone_no, ModelMap ownerModel) {
		Owner owner = new Owner();
		owner.setOwner_name(owner_name);
		owner.setOwner_email(owner_email);
		owner.setOwner_username(owner_username);
		owner.setOwner_password(owner_password);
		owner.setOwner_phone_no(owner_phone_no);
		OwnerService.addOwner(owner);
//		ownerModel.addAttribute("msg", "owner added successfully");
//		List<Owner> owners = OwnerService.getOwners();
//		ownerModel.addAttribute("owners", owners);
		
		return "Login_O";
	}
	
	@GetMapping("/owner/L")
	public String loginUser()
	{
		return "Login_O";
	}
	
	@PostMapping("/loginowner")
	public String loginowner(@RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password, HttpServletRequest request)
	{
		List<Owner> o = OwnerService.getOwners();
		
		for(Owner owner : o)
		{
			if((owner.getOwner_username()).equals(username) && (owner.getOwner_password()).equals(password))
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("username", username);
				session.setAttribute("usertype", "Owner");
				session.setAttribute("id", owner.getOwner_id());
				return "redirect:/home";
			}
		}
		return "Login_O";
	}
}
