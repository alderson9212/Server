package com.fenoreste.saicoop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenoreste.saicoop.entity.Usuarios;
import com.fenoreste.saicoop.util.conexionJDBC;
import com.google.gson.Gson;

@Service
public class UsuarioServiceImpl implements IUsuariosService {

	@Autowired
	conexionJDBC jdbc;
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Statement stmt;
	String sql="";
	
	
	@Override
	public Usuarios buscarPorId(Integer id, String ip, String base) {
		Usuarios user = new Usuarios();
		JSONObject json = new JSONObject();
		try {
			con = jdbc.connectDatabase(ip, base);
			if (con != null) {
				sql = "SELECT * FROM usuarios WHERE idusuario=" + id;
				System.out.println(sql);
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				ResultSetMetaData rsmd = rs.getMetaData();
				if (rs.next()) {
					int numColumns = rsmd.getColumnCount();
					for (int i = 1; i <= numColumns; i++) {
						String column_name = rsmd.getColumnName(i);
						json.put(column_name, rs.getObject(column_name));
					}
				}
			}
			con.close();
			user = new Gson().fromJson(json.toString(), Usuarios.class);

		} catch (Exception e) {
			System.out.println("Error al buscar usuario:" + e.getMessage());

		}

		return user;
	}

}
