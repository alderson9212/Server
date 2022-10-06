package com.fenoreste.saicoop.service;

import org.springframework.stereotype.Service;

import com.fenoreste.saicoop.entity.j_admin_sesion;

public interface IAdminSesionService {
    
	public j_admin_sesion buscar(Integer idusuario);
	
}
