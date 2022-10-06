package com.fenoreste.saicoop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fenoreste.saicoop.entity.Usuarios;
import com.fenoreste.saicoop.service.IUsuariosService;

@RestController
@CrossOrigin(origins = "")
@RequestMapping({ "/api/user" })
public class UsuarioController {

	@Autowired
	IUsuariosService userService;
	
	
	@RequestMapping(value="/buscarPorId/id={id}&ip={ip}&db={db}", method =RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
	public Usuarios buscarPorId(@PathVariable Integer id,@PathVariable String ip,@PathVariable String db) {
		 Usuarios user = userService.buscarPorId(id, ip, db);
		System.out.println("si lleho");
		return user;
	}
	
}
