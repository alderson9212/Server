package com.fenoreste.saicoop.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({ "/api/tarjetas" })
public class TddController {

    @RequestMapping(value="/alta", method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String activarTarjeta(@RequestBody String cadena) {
        
    	return null;
    }
}
