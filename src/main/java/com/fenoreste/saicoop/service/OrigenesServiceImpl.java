package com.fenoreste.saicoop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenoreste.saicoop.entity.Origen;
import com.fenoreste.saicoop.entity.Usuarios;
import com.fenoreste.saicoop.util.conexionJDBC;
import com.google.gson.Gson;

@Service
public class OrigenesServiceImpl implements IOrigenesService {

	@Autowired
	conexionJDBC jdbc;
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Statement stmt;
	String sql="";
	
	
	@Override
	public Origen buscarMatriz(String ip,String base){
		Origen origen = new Origen();
		JSONObject json = new JSONObject();
		try {
			con = jdbc.connectDatabase(ip, base);
			if (con != null) {
				sql = "SELECT * FROM origenes WHERE matriz=0";
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				ResultSetMetaData rsmd = rs.getMetaData();
				if (rs.next()) {
					int numColumns = rsmd.getColumnCount();
					for (int i = 1; i <= numColumns; i++) {
						String column_name = rsmd.getColumnName(i);
						if(column_name.contains("fechatrabajo")) {
							json.put(column_name, rs.getObject(column_name).toString().substring(0,10));
						}else {
							json.put(column_name, rs.getObject(column_name));	
						}
						
					}
				}
			}
			System.out.println(json);
			con.close();
			origen = new Gson().fromJson(json.toString(), Origen.class);

		} catch (Exception e) {
			System.out.println("Error al buscar matriz:" + e.getMessage());

		}

		return origen;
	}	
}
