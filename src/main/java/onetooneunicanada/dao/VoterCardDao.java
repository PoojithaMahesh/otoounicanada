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

	
	public void updateVoterCard(int voterId,VoterCard card) {
		EntityManager entityManager=getEntityManager();
		VoterCard dbCard=entityManager.find(VoterCard.class, voterId);
		if(dbCard!=null) {
//			that votercard is present then i can update the data
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			
			card.setId(voterId);
			entityManager.merge(card);
			entityTransaction.commit();
			
		}else {
//		that votercard is not present then we should not update the data
			System.out.println("Sorry voterCard id is not present");
		}
	}
	
	
	public void findVoterCard(int voterId) {
		EntityManager entityManager=getEntityManager();
		VoterCard dbCard=entityManager.find(VoterCard.class, voterId);
		if(dbCard!=null) {
//			voterCard is present
			System.out.println(dbCard);
		}else {
//			id is not present 
			System.out.println("Sorry voterId is noy present");
		}
		
	}
	
	
	public void deleteVoterCard(int voterId) {
		EntityManager entityManager=getEntityManager();
		VoterCard dbCard=entityManager.find(VoterCard.class, voterId);
		if(dbCard!=null) {
//			voterCard is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbCard);
			entityTransaction.commit();
		}else {
//			id is not present 
			System.out.println("Sorry voterId is noy present");
		}
		
	}
	
	
	
}
