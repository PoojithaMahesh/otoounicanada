package onetooneunicanada.cont;

import onetooneunicanada.dao.PersonDao;
import onetooneunicanada.dao.VoterCardDao;
import onetooneunicanada.dto.Person;
import onetooneunicanada.dto.VoterCard;

public class PersonVoterCont {
public static void main(String[] args) {
	
	
	
	
//	Person person=new Person();
//	person.setId(3);
//	person.setName("sandhya");
//	person.setAddress("canada");
//	
//	
//	
//	
//	
//	PersonDao personDao=new PersonDao();
//	personDao.savePerson(person);
//	
	
	
	
	VoterCard card=new VoterCard();
	card.setId(300);
	card.setName("Sandhya");
	card.setAge(18);
	
	
	VoterCardDao cardDao=new  VoterCardDao();
	cardDao.saveVoterCard(3, card);
	
	
	
	
	
	
	
}
}
