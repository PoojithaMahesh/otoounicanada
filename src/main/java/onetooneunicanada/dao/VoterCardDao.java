package onetooneunicanada.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetooneunicanada.dto.Person;
import onetooneunicanada.dto.VoterCard;

public class VoterCardDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveVoterCard(int personId,VoterCard card) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
	    Person dbPerson=entityManager.find(Person.class, personId);
	    
	    if(dbPerson!=null) {
//	    	that person is present then i can save the Adharcard
	    	entityTransaction.begin();
	    	entityManager.persist(card);
	    	
//	    	update the person detailsalso
	    	dbPerson.setCard(card);
	    	
	    	entityTransaction.commit();
	    }else {
//	    	that person is not present then i canot issue the votercard
	    	System.out.println("Sorry Person id is not present ");
	    }   
	}

}
