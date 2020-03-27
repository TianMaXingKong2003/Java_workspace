package cn.itcast.dao;

import java.util.List;
import java.util.Map;

import cn.itcast.domain.Person;

public interface IPersonDao {
	public void savePerson(Person person);
	public Person findPersonByName(String username);
	public Person findPersonByNameAndPassword(String username,String password);
	public void updatePerson(Person person);
	public void udpatePubtime(Person person);
	public void ZeroPubtime(Person person);
	public List<Person> findAllPersons();
	public List<Person> findPersonsByParams(Map<String, String> map);
	public Person findPersonById(long id);
}