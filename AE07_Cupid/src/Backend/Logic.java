package Backend;

import java.util.ArrayList;

public class Logic {
	
	private PersonDAOInterface dao;
	
	public Logic(PersonDAOInterface dao) {
		this.dao = dao;
	}
	
	public ArrayList<Person> getPersonList(){
		ArrayList<Person> people = null;
		try {
			people = this.dao.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//get all from db
		return people;
	}

	public Person getPersonById(int id){
		Person person = null;
		try {
			person = this.dao.getById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;
	}
	
	public boolean saveNewPerson(String name, String lastname, String gender, String birthday, String street, String zip, String city, String phone, String mail, String image, String info){
		Person person = new Person();
		person.setName(name);
		person.setLastname(lastname);
		person.setGender(gender);
		person.setBirthday(birthday);
		person.setStreet(street);
		person.setZip(Integer.parseInt(zip));
		person.setCity(city);
		person.setPhone(phone);
		person.setMail(mail);
		person.setPhoto(image);
		person.setAddInfo(info);
		boolean bool = false;
		try {
			bool = this.dao.add(person);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}
	
	public boolean addNoteToPerson(String id, String note) throws Exception{
		Person p = new Person();
		p.setId(Integer.parseInt(id));
		p.setNote(note);
		boolean bool = false;
		try {
			bool = this.dao.updateNote(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}
	
	public ArrayList<Person> getPersonBySearch(String search){
		ArrayList<Person> pList = new ArrayList<Person>();
		try {
			pList = this.dao.getListByName(search);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pList;
	}
	
	public ArrayList<Person> getPeopleByGender(String gender){
		ArrayList<Person> pList = new ArrayList<Person>();
		try {
			return this.dao.getListByGender(gender);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pList;
	}
}
