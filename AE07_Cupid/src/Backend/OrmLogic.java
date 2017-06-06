package Backend;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

public class OrmLogic {

	private Dao<Person, Integer> personDao;
	
	public OrmLogic() {
		this.personDao = DaoHelper.getPersonDao();
	}

	public ArrayList<Person> getPersonList(){
		ArrayList<Person> people = new ArrayList<Person>();
		try {
			List list = this.personDao.queryForAll();
			people.addAll(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return people;
	}

	public Person getPersonById(int id){
		Person person = null;
		try {
			person = personDao.queryForId(id);
		} catch (SQLException e) {
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
//     person.setBirthday(birthday);
		person.setAge(Integer.parseInt(birthday));
		person.setStreet(street);
		person.setZip(Integer.parseInt(zip));
		person.setCity(city);
//		person.setPhone(phone);
		person.setMail(mail);
//      person.setPhoto(image);
		person.setInfo(info);
		boolean bool = false;
		try {
			this.personDao.create(person);
			bool = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}
	
	public boolean addNoteToPerson(String id, String note) throws Exception{

		boolean bool = false;
		Person person = this.personDao.queryForId(Integer.parseInt(id));
		person.setNote(note);
		this.personDao.update(person);
		return bool;
	}
	
	public ArrayList<Person> getPersonBySearch(String search){
		ArrayList<Person> pList = new ArrayList<Person>();
			 	
		QueryBuilder<Person, Integer> queryBuilder =
		  this.personDao.queryBuilder();
		// get the WHERE object to build our query
		try {
		Where<Person, Integer> where = queryBuilder.where();
		// the name field must be equal to "foo"
		where.eq("firstname", search);
		// and
		where.or();
		// the password field must be equal to "_secret"
		where.eq("lastname", search);
		PreparedQuery<Person> preparedQuery = queryBuilder.prepare();
		List list = this.personDao.query(preparedQuery);
		pList.addAll(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pList;
	}
	
	public ArrayList<Person> getPeopleByGender(String gender){
		ArrayList<Person> pList = new ArrayList<Person>();
		try {
			List list = this.personDao.queryForEq("gender", gender);
			pList.addAll(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pList;
	}
	
}
