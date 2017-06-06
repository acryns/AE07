package Backend;

import java.sql.Connection;
import java.sql.ResultSet;

import org.h2.jdbcx.JdbcDataSource;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	
    public static final String URL = "jdbc:h2:file:./AE07_Cupid/database/PeopleOfTheDatabase";
    public static final String USER = "sa";
    public static final String PASS = "";

    
    public static Connection getH2Connection() throws SQLException
    {
      try {
    	  JdbcDataSource ds = new JdbcDataSource();
    	  ds.setURL(URL);
    	  ds.setUser(USER);
    	  ds.setPassword(PASS);
    	  Connection conn = ds.getConnection();
    	  return conn;
      } catch (SQLException ex) {
    	  new ExceptionHandler(ex).handle();
    	  return null;
          //throw new RuntimeException("Error connecting to the database", ex);
      }
    }
    
    public static ConnectionSource getH2ConnectionSource() {
    	try {
  	  		JdbcConnectionSource ds = new JdbcConnectionSource(URL);
  	  		//ds.setUrl(URL);
  	  		ds.setUsername(USER);
  	  		ds.setPassword(PASS);
  	  		return ds;
    	} catch (Exception ex) {
    		System.out.println("EXCEPTION");
    		return null;
    	}
    }
    
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getH2Connection();
        Statement stmt = connection.createStatement();
        try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM people");
            while(rs.next())
            {
            	System.out.println(rs.getInt("person_id"));
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
