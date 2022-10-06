package com.fenoreste.saicoop.service;

import org.json.JSONObject;

import com.fenoreste.saicoop.entity.Usuarios;


public interface IUsuariosService {

	public Usuarios buscarPorId(Integer id,String ip,String base);
	
}
