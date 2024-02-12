package com.house_rental_system.Repositery;

import java.util.List;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.house_rental_system.Entity.Owner;

@Repository
public class OwnerDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public OwnerDao(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	public List<Owner> getOwners() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query
		TypedQuery<Owner> theQuery =
				currentSession.createQuery("from Owner", Owner.class);
		
		// execute query and get result list
		List<Owner> Owners = theQuery.getResultList();

		currentSession.close();
		return Owners;
	}
	
	@Transactional
	public void addOwner(final Owner Owner) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(Owner);
		currentSession.close();
	}
	public Owner getOwner(final int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		Owner Owner = currentSession.get(Owner.class, id);
		currentSession.close();
		return Owner;
	}
	@Transactional
	public void deleteOwner(final int owner_id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
//		TypedQuery<Owner> theQuery =
//			currentSession.createQuery("delete from Owner where id=:tid", Owner.class);
//		theQuery.setParameter("tid", id);
//		theQuery.executeUpdate();
		
		Owner Owner = currentSession.get(Owner.class, owner_id);
		currentSession.remove(Owner);
		currentSession.close();
				
	}

}
