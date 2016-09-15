package com.springmvc.dao;
import java.util.List;

import com.springmvc.entity.Person;
public interface IPersonDAO {
    List<Person> getAllPersons();
    Person getPersonById(int pid);
    boolean addPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(int pid);
    boolean personExists(String name, String phonenumber);
}
 