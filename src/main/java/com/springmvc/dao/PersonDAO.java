package com.springmvc.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.entity.Person;
@Transactional
@Repository
public class PersonDAO implements IPersonDAO {
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	public Person getPersonById(int pid) {
		return hibernateTemplate.get(Person.class, pid);
	}
	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons() {
		String hql = "FROM Person as p ORDER BY p.pid";
		return (List<Person>) hibernateTemplate.find(hql);
	}	
	public boolean addPerson(Person person) {
		hibernateTemplate.save(person);
		return false;
	}
	public void updatePerson(Person person) {
		Person p = getPersonById(person.getPid());
		p.setName(person.getName());
		p.setLocation(person.getLocation());
		p.setPhonenumber(person.getPhonenumber());
		p.setEmail(person.getEmail());
		hibernateTemplate.update(p);
	}
	public void deletePerson(int pid) {
		hibernateTemplate.delete(getPersonById(pid));
	}
	@SuppressWarnings("unchecked")
	public boolean personExists(String name, String phonenumber) {
		String hql = "FROM Person as p WHERE p.name = ? and p.phonenumber = ?";
		List<Person> persons = (List<Person>) hibernateTemplate.find(hql, name,  phonenumber);
		return persons.size() > 0 ? true : false;
	}
}
