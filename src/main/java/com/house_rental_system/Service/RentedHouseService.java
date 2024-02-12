package com.house_rental_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.house_rental_system.Entity.RentedHouse;
import com.house_rental_system.Entity.*;
import com.house_rental_system.Repositery.CustomerDao;
import com.house_rental_system.Repositery.RentedHouseDao;

@Service
public class RentedHouseService {

	@Autowired
	private RentedHouseDao RentedHouseDao;

	public RentedHouse getRentedHouse(final int house_id) {
		return RentedHouseDao.getRentedHouse(house_id);
	}

	public List<RentedHouse> getRentedHouses() {
		return RentedHouseDao.getRentedHouses();
	}

	public void addRentedHouse(final RentedHouse House) {
		RentedHouseDao.addRentedHouse(House);
	}

	public void updateRentedHouse(final RentedHouse House) {
		RentedHouseDao.updateRentedHouse(House);
	}

	public void deleteRentedHouse(final int house_id) {
		RentedHouseDao.deleteRentedHouse(house_id);
	}
}
