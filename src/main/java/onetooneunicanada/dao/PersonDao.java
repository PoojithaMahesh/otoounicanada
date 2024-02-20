package onetooneunicanada.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetooneunicanada.dto.Person;
import onetooneunicanada.dto.VoterCard;

public class PersonDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void savePerson(Person person) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}
	public void updatePerson(int personId,Person person) {
//		person=name address
//		personID=3
		EntityManager entityManager=getEntityManager();
		Person dbPerson=entityManager.find(Person.class, personId);
//		dbperson=id,name,address,votercard
		if(dbPerson!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			
			person.setId(personId);
//			person=id name address
			person.setCard(dbPerson.getCard());
//			person=id name addrss,votercard
			entityManager.merge(person);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present to update the data");
		}

	}
	
	
	
	public void findPerson(int personId) {
		EntityManager entityManager=getEntityManager();
		Person dbPerson=entityManager.find(Person.class, personId);
		if(dbPerson!=null) {
//			voterCard is present
			System.out.println(dbPerson);
		}else {
//			id is not present 
			System.out.println("Sorry person is not present");
		}
		
	}
	
	
	public void deletePerson(int personId) {
		EntityManager entityManager=getEntityManager();
		Person dbPerson=entityManager.find(Person.class, personId);
		if(dbPerson!=null) {
//			voterCard is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbPerson);
			entityTransaction.commit();
		}else {
//			id is not present 
			System.out.println("Sorry person is not present");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
