package Dao;

import java.sql.*;

public class ConnectionFactory {
	
	public Connection getConnection() {
		System.out.println("Conectando ao banco");
		try{   
	      Class.forName ("org.gjt.mm.mysql.Driver");  
	    }catch (ClassNotFoundException e)  {    
	          e.printStackTrace();   
	    } 
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/praonde", "root", "");

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
				
	}
}