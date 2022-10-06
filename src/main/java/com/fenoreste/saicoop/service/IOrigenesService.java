package com.fenoreste.saicoop.service;

import org.springframework.stereotype.Service;

import com.fenoreste.saicoop.entity.Origen;


@Service
public interface IOrigenesService {

	public Origen buscarMatriz(String ip,String base);
}
