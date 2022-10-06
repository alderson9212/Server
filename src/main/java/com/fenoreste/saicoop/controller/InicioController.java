package com.fenoreste.saicoop.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fenoreste.saicoop.util.conexionJDBC;

@RestController
@CrossOrigin(origins = "")
@RequestMapping({ "/api" })
public class InicioController {
	@Autowired
	private conexionJDBC jdbc;
	
	private Connection connection;
	
	@RequestMapping(value="/get/connection/ip={ip}&db={db}", method =RequestMethod.GET)
	public boolean obtenerConexion(@PathVariable String ip,@PathVariable String db) {
		boolean bandera = false;
		try {
			connection = jdbc.connectDatabase(ip, db);
			if(connection != null) {
				bandera = true;
				connection.close();
			}
		} catch (Exception e) {
			System.out.println("Error al verificar al realizar la conexion a la base de datos:"+db);
		}
		
		return bandera;		
	}
	
	
	@RequestMapping(value="/set/session/ip={ip}&db={db}&iduser={iduser}&ipcliente={ipcliente}", method =RequestMethod.GET)
	public String connectionSesion(@PathVariable String ip,@PathVariable String db,@PathVariable String username,@PathVariable Integer iduser,@PathVariable String ipcliente,@PathVariable Integer se) {
		String pid = "";
		System.out.println(se);
		Connection con = jdbc.connectDatabase(ip, db);		
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT pid FROM pg_stat_activity WHERE client_addr ='"+"192.168.99.37"+"' and usename='jsaicoop'");
			while(rs.next()) {
				pid = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return pid;		
	}
	
	
}
