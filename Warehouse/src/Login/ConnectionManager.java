package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager
{	
	 protected static String conn_url="jdbc:mysql://127.0.0.1:3306/jdbc_login"; // URL connection using our IP and DB
	 protected static String username="root"; // our DB_Username
	 protected static String pass="test123"; // our DB_Password
	 protected static Connection conn; 
		 
	   public static Connection getConnection()
	   {
		   	try
		   	{
			   Class.forName("com.mysql.jdbc.Driver").newInstance(); //instance of JDBC	   
			   		try 
			   		{
			   			conn=DriverManager.getConnection(conn_url,username,pass); // Sign in DB using the DB_Credentials
			   		}
			   		catch(SQLException ex)
			   		{
			   		 System.out.println("Failed to create the database connection."); 		
			   		}
		   	}   	
	       catch(ClassNotFoundException ex)
	 	   {
	    	   System.out.println("Driver not found."); 	
	 	   } catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	    
	   }     
}
