package com.fenoreste.saicoop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fenoreste.saicoop.service.IAdminSesionService;

@RestController
@CrossOrigin(origins = "")
@RequestMapping({ "/api" })
public class SessionesController {
    
	@Autowired
	IAdminSesionService adminSesionService;
	
	@RequestMapping(value="/session/buscar/ip={ip}&db={db}&iduser={iduser}", method =RequestMethod.GET)
	public String sesionBuscar(@PathVariable String ip,@PathVariable String db,@PathVariable String iduser) {
		String pid = "";
		System.out.println("Si llego");
		
		try {
			
		} catch (Exception e) {

		}
		
		return pid;		
	}
	
	@GetMapping(value ="/test")
	public void sillega() {
		System.out.println("Si llega");
	}
}
