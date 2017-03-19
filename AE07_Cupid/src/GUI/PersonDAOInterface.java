package GUI;

import java.util.ArrayList;

public interface PersonDAOInterface {

	ArrayList<Person> getAll() throws Exception;
	Person getById(int id) throws Exception;
	boolean add(Person person) throws Exception;
	boolean update(Person person) throws Exception;
	boolean delete(Person person) throws Exception;
	ArrayList<Person> getListByName(String search) throws Exception;
	ArrayList<Person> getListByGender(String search) throws Exception;
	public boolean updateNote(Person p) throws Exception;
}
