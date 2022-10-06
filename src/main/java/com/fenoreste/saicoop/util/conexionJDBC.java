package com.fenoreste.saicoop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

@Service
public class conexionJDBC {

	   Connection con = null;
	    public Connection connectDatabase(String ip,String db)  {
	      try {
	           try {
	                Class.forName("org.postgresql.Driver");
	            } catch (ClassNotFoundException ex) {
	                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
	            }   
	            // Database connectss
	            // Conectamos con la base de datos
	         	   //Obtenemos una conexion
	        	   con = DriverManager.getConnection(
		                    "jdbc:postgresql://"+ip+":5432/"+db,
		                    "jsaicoop", "slufpana?");  
	        } catch (java.sql.SQLException sqle) {
	            System.out.println("Error al conectar a la base de datos: " + db);	
	            con = null;
	        }        
	        return con;
	    }
	    
	    
}
