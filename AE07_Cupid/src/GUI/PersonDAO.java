package GUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDAO implements PersonDAOInterface {

	@Override
	public ArrayList<Person> getAll() throws Exception {
		try (Connection connection = ConnectionFactory.getH2Connection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM PEOPLE")) {
			ResultSet resultSet = statement.executeQuery();
			ArrayList<Person> pList = new ArrayList<Person>();
			while(resultSet.next()) {
				Person p = extractPersonFromResultSet(resultSet);
				pList.add(p);
			}
			return pList;
		} catch (SQLException ex) {
			throw new Exception(ex.getMessage(), ex);
		}
	}

	@Override
	public Person getById(int id) throws Exception {
		try (Connection connection = ConnectionFactory.getH2Connection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM PEOPLE WHERE PERSON_ID = ?")) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return extractPersonFromResultSet(resultSet);
			} else {
				return null;
			}
		} catch (SQLException ex) {
			throw new Exception(ex.getMessage(), ex);
		}
	}

	@Override
	public boolean add(Person person) throws Exception {
		if (getById(person.getId()) != null) {
			return false;
		} else {
			try (Connection connection = ConnectionFactory.getH2Connection();
					PreparedStatement statement = connection.prepareStatement("INSERT INTO PEOPLE (firstname, lastname, age, street, zip, city,gender, info, note, photo, mail) VALUES (?,?,?,?,?,?,?,?,?,?,?)")) {
				statement.setString(1, person.getName());
				statement.setString(2, person.getLastname());
				statement.setInt(3, person.getAge());
				statement.setString(4, person.getStreet());
				statement.setInt(5, person.getZip());
				statement.setString(6, person.getCity());
				statement.setString(7, person.getGender());
				statement.setString(8, person.getAddInfo());
				statement.setString(9, person.getNote());
				statement.setString(10, person.getPhoto());
				statement.setString(11, person.getMail());
				statement.execute();
				return true;
			} catch (SQLException ex) {
				throw new Exception(ex.getMessage(), ex);
			}
		}
	}

	@Override
	public boolean update(Person person) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Person person) throws Exception {
		try (Connection connection = ConnectionFactory.getH2Connection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM PEOPLE WHERE PERSON_ID = ?")) {
			statement.setInt(1, person.getId());
			statement.executeQuery();
			return true;
		} catch (SQLException ex) {
			throw new Exception(ex.getMessage(), ex);
		}
	}

	// TODO den ganzen Rest
	private Person extractPersonFromResultSet(ResultSet rs) throws SQLException {
		Person person = new Person();

		person.setId(rs.getInt("person_id"));
		person.setName(rs.getString("firstname"));
		person.setLastname(rs.getString("lastname"));
		person.setAge(rs.getInt("age"));
		person.setStreet(rs.getString("street"));
		person.setZip(rs.getInt("zip"));
		person.setAddInfo(rs.getString("info"));
		person.setNote(rs.getString("note"));
		person.setGender(rs.getString("gender"));
		person.setMail(rs.getString("mail"));

		return person;
	}
	
	public ArrayList<Person> getListByName(String search) throws Exception {
		try (Connection connection = ConnectionFactory.getH2Connection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM PEOPLE WHERE firstname LIKE ? OR lastname LIKE ?")) {
			statement.setString(1,"%" + search + "%");
			statement.setString(2,"%" + search + "%");
			ResultSet resultSet = statement.executeQuery();
			ArrayList<Person> pList = new ArrayList<Person>();
			while(resultSet.next()) {
				Person p = extractPersonFromResultSet(resultSet);
				pList.add(p);
			}
			return pList;
		} catch (SQLException ex) {
			throw new Exception(ex.getMessage(), ex);
		}
	}
	
	public ArrayList<Person> getListByGender(String search) throws Exception {
		try (Connection connection = ConnectionFactory.getH2Connection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM PEOPLE WHERE gender LIKE ? ")) {
			statement.setString(1, "%" + search + "%");
			ResultSet resultSet = statement.executeQuery();
			ArrayList<Person> pList = new ArrayList<Person>();
			while(resultSet.next()) {
				Person p = extractPersonFromResultSet(resultSet);
				pList.add(p);
			}
			return pList;
		} catch (SQLException ex) {
			throw new Exception(ex.getMessage(), ex);
		}
	}
	
	public boolean updateNote(Person p) throws Exception {
		try (Connection connection = ConnectionFactory.getH2Connection();
				PreparedStatement statement = connection.prepareStatement("UPDATE PEOPLE SET note = ? WHERE PERSON_ID = ?")) {
			statement.setString(1, p.getNote());
			statement.setInt(2, p.getId());
			statement.executeQuery();
			return true;
		} catch (SQLException ex) {
			throw new Exception(ex.getMessage(), ex);
		}
	}
}
