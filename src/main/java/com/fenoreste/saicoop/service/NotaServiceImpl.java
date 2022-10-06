package com.fenoreste.saicoop.service;

import com.fenoreste.saicoop.entity.Nota;
import com.fenoreste.saicoop.entity.RespuestaDTO;
import com.fenoreste.saicoop.util.conexionJDBC;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Service
public class NotaServiceImpl implements INotaService {
    @Autowired
    conexionJDBC jdbc;

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement stmt;
    String sql="";

    @Override
    public Nota buscarNotaPorId(String id,String ip,String db) {
        Nota nota = new Nota();
        JSONObject json = new JSONObject();
        try {
            con = jdbc.connectDatabase(ip,db);
            if (con != null) {
                String numero =String.format("%06d",Integer.parseInt(id));
                sql = "SELECT * FROM notas WHERE LOWER(idnota)='mireporte"+numero+"'";
                System.out.println(sql);
                stmt = con.createStatement();
                rs = stmt.executeQuery(sql);
                ResultSetMetaData rsmd = rs.getMetaData();
                if (rs.next()) {
                    int numColumns = rsmd.getColumnCount();
                    for (int i = 1; i <= numColumns; i++) {
                        String column_name = rsmd.getColumnName(i);
                        json.put(column_name, rs.getObject(column_name).toString().replaceAll("\\R", ""));
                    }
                }
            }
            con.close();
            System.out.println(json);
            nota = new Gson().fromJson(json.toString(),Nota.class);

        }catch (Exception e){
            System.out.println("Error al buscar nota por id:"+e.getMessage());
        }
        return nota;
    }


    public JsonArray ejecutarQuery(String ip, String db, String query){
        JsonArray array = new JsonArray();
        try {
            con = jdbc.connectDatabase(ip,db);
            if (con != null) {
                sql = query;
                stmt = con.createStatement();
                rs = stmt.executeQuery(sql);
                ResultSetMetaData rsmd = rs.getMetaData();
                while(rs.next()){
                    int columnas = rsmd.getColumnCount();
                    JsonObject obj = new JsonObject();
                    HashMap<String,Object>map = new HashMap<>();
                    LinkedHashMap<String, Object> unsortMap = new LinkedHashMap<String, Object>();
                    for (int i = 0; i <columnas; i++) {
                        unsortMap.put(rsmd.getColumnLabel(i + 1),rs.getObject(i + 1));
                    }
                    array.add(unsortMap);
                }
            }
        }catch (Exception e){
            System.out.println("Error al ejecutar query:"+e.getMessage());
        }
        return array;
    }
}
