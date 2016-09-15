package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.IPersonDAO;
import com.springmvc.entity.Person;
@Service
public class PersonService implements IPersonService {
	@Autowired
	private IPersonDAO personDAO;
	public Person getPersonById(int pid) {
		Person obj = personDAO.getPersonById(pid);
		return obj;
	}	
	public List<Person> getAllPersons(){
		return personDAO.getAllPersons();
	}
	public synchronized boolean addPerson(Person person){
       if (personDAO.personExists(person.getName(), person.getPhonenumber())) {
    	   return false;
       } else {
    	   personDAO.addPerson(person);
    	   return true;
       }
	}
	public void updatePerson(Person person) {
		personDAO.updatePerson(person);
	}
	public void deletePerson(int pid) {
		personDAO.deletePerson(pid);
	}
}
