package com.fenoreste.saicoop.entity;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class j_admin_sesion {
    private Integer     idusuario                   ;
	private String      sesionservidor              ;
	private String      iplocal                     ;
	private String      ipexterna                   ;
	private String      macaddress                  ;
	private String      ipbasedatos                 ;
	private String      basedatos                   ;
	private String      usuariosistemaoperativo     ;
	private String      sistemaoperativo            ;
	private String      versionsistemaoperativo     ;
	private String      arquitecturasistemaoperativo;
	private Timestamp   ultimaentrada               ;
	private boolean     estatus                     ;
	private boolean     bloqueado                   ;

}
