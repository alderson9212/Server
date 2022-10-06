package com.fenoreste.saicoop.service;

import com.fenoreste.saicoop.entity.Nota;
import com.fenoreste.saicoop.entity.RespuestaDTO;
import com.github.cliftonlabs.json_simple.JsonArray;


public interface INotaService {

    public Nota buscarNotaPorId(String id,String ip,String db);
    public JsonArray ejecutarQuery(String ip, String db, String query);

}
