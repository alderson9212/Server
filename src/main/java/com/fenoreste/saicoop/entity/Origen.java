/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.saicoop.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author wilmer
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Origen implements Serializable{
	
    private Integer idorigen;
    private int matriz;
    private String nombre;
    private String calle;
    private String numeroext;
    private String numeroint;
    private String telefono1;
    private String telefono2;
    private String codigopostal;
    private boolean estatus;
    private Date fechatrabajo;
    private String ctaRendimientos;
    private String ctaQuebrantos;
    private String ctaEfectivo;
    private String ctaDocumentos1;
    private String ctaDocumentos2;
    private String ctaDocumentos3;
    private String ctaDocumentos4;
    private String ctaDocumentos5;
    private boolean enlinea;
    private String ctaDocumentos6;
    private String ctaDocumentos7;
    
    private final long versionSerialUID = 1L;
}
