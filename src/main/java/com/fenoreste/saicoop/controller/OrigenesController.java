package com.fenoreste.saicoop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fenoreste.saicoop.entity.Origen;
import com.fenoreste.saicoop.service.IOrigenesService;

@RestController
@CrossOrigin(origins = "")
@RequestMapping({ "/api/origenes" })
public class OrigenesController {

	@Autowired
	IOrigenesService origenesService;
	
	
	@RequestMapping(value="/buscarMatriz/ip={ip}&db={db}", method =RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
	public Origen buscarPorId(@PathVariable String ip,@PathVariable String db) {
		 Origen origen = origenesService.buscarMatriz(ip, db);
		return origen;
	}
}
