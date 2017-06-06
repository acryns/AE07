package Backend;

import java.sql.SQLException;

import com.j256.ormlite.dao.*;

public class DaoHelper {

	private Dao personDao;
	
	
	public static Dao<Person,Integer> getPersonDao()  {	
		Dao<Person, Integer> personDao;
		try {
			personDao = DaoManager.createDao(ConnectionFactory.getH2ConnectionSource(), Person.class);
			return personDao;
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
}
