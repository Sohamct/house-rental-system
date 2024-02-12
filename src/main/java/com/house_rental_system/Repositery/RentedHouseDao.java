package com.house_rental_system.Repositery;

import java.util.List;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.house_rental_system.Entity.RentedHouse;

@Repository
public class RentedHouseDao {
	private EntityManager entityManager;
	
	// set up constructor injection
		@Autowired
		public RentedHouseDao(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
		@Transactional
		public RentedHouse getRentedHouse(final int id) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			RentedHouse RentedHouse = currentSession.get(RentedHouse.class, id);
			currentSession.close();
			return RentedHouse;
		}
		@Transactional
		public List<RentedHouse> getRentedHouses() {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
					
			// create a query
			TypedQuery<RentedHouse> theQuery =
					currentSession.createQuery("from RentedHouse", RentedHouse.class);
			
			// execute query and get result list
			List<RentedHouse> RentedHouses = theQuery.getResultList();

			currentSession.close();
			return RentedHouses;
		}
		@Transactional
		public void addRentedHouse(final RentedHouse rentedHouse) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			System.out.println(rentedHouse);
			currentSession.persist(rentedHouse);
			currentSession.close();
		}

		@Transactional
		public void updateRentedHouse(final RentedHouse RentedHouse) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.merge(RentedHouse);
			currentSession.close();
		}

		@Transactional
		public void deleteRentedHouse(final int id) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			
			// create a query
//			TypedQuery<RentedHouse> theQuery =
//				currentSession.createQuery("delete from RentedHouse where id=:RentedHouse_id", RentedHouse.class);
//			theQuery.setParameter("RentedHouse_id", id);
//			theQuery.executeUpdate();
			
			RentedHouse RentedHouse = currentSession.get(RentedHouse.class, id);
			currentSession.remove(RentedHouse);
			currentSession.close();
				
		}
}
