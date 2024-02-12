package com.house_rental_system.Repositery;

import java.util.List;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.house_rental_system.Entity.House;

@Repository
public class HouseDao {
	private EntityManager entityManager;
	
	// set up constructor injection
		@Autowired
		public HouseDao(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}

		public House getHouse(final int id) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			House House = currentSession.get(House.class, id);
			currentSession.close();
			return House;
		}

		public List<House> getHouses() {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
					
			// create a query
			TypedQuery<House> theQuery =
					currentSession.createQuery("from House", House.class);
			
			// execute query and get result list
			List<House> Houses = theQuery.getResultList();

			currentSession.close();
			return Houses;
		}
		@Transactional
		public void addHouse(final House House) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.persist(House);
			currentSession.close();
		}

		@Transactional
		public void updateHouse(final House House) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.merge(House);
			currentSession.close();
		}

		@Transactional
		public void deleteHouse(final int id) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			
			// create a query
//			TypedQuery<House> theQuery =
//				currentSession.createQuery("delete from House where id=:house_id", House.class);
//			theQuery.setParameter("house_id", id);
//			theQuery.executeUpdate();
			
			House House = currentSession.get(House.class, id);
			currentSession.remove(House);
			currentSession.close();
				
		}
}
