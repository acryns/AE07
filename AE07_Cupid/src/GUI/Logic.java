package GUI;

import java.util.ArrayList;

public class Logic {
	
	public static ArrayList<Person> getPersonList(){
		ArrayList<Person> people = new ArrayList<>();
		//get all from db
		return people;
	}

	public static Person getPersonById(int id){
		Person person = new Person();
		return person;
	}
	
	public static void saveNewPerson(String name, String lastname, String gender, String birthday, String street, String zip, String city, String phone, String mail, String image, String info){
		//write to db
	}
	
	public static void addNoteToPerson(String id, String note){
		//write to db
	}
	
	public static ArrayList<Person> getPersonBySearch(String search){
		ArrayList<Person> people = new ArrayList<>();
		//get from db with search string
		return people;
	}
	
	public static ArrayList<Person> getPeopleByGender(String gender){
		ArrayList<Person> people = new ArrayList<>();
		switch(gender){
			case "women":
				//get women from db add to people
				return people;
			case "men":
				//get men from db add to people
				return people;
			default:
				//get all from db add to people
				return people;
		}
	}
}
