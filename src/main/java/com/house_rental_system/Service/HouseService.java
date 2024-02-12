package com.house_rental_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.house_rental_system.Entity.House;
import com.house_rental_system.Repositery.HouseDao;

@Service
public class HouseService {

	@Autowired
	private HouseDao HouseDao;

	public House getHouse(final int house_id) {
		return HouseDao.getHouse(house_id);
	}

	public List<House> getHouses() {
		return HouseDao.getHouses();
	}

	public void addHouse(final House House) {
		HouseDao.addHouse(House);
	}

	public void updateHouse(final House House) {
		HouseDao.updateHouse(House);
	}

	public void deleteHouse(final int house_id) {
		HouseDao.deleteHouse(house_id);
	}
}
