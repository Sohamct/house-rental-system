package com.house_rental_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.house_rental_system.Entity.Owner;
import com.house_rental_system.Repositery.OwnerDao;

@Service
public class OwnerService {
	
	@Autowired
	private OwnerDao OwnerDao;

	public Owner getOwner(final int owner_id) {
		return OwnerDao.getOwner(owner_id);
	}

	public List<Owner> getOwners() {
		return OwnerDao.getOwners();
	}

	public void addOwner(final Owner Owner) {
		OwnerDao.addOwner(Owner);
	}
	public void deleteOwner(final int id) {
		OwnerDao.deleteOwner(id);
	}
}
