package com.fenoreste.saicoop.entity;

import java.io.Serializable;
import java.sql.Timestamp;


import lombok.Data;

@Data
public class pg_stat_activityEntity implements Serializable{	
	
     private String                        client_addr      ;
	 private String                        datname          ;
	 private Integer                       pid              ;
	 private String                        usename          ;
	 private String                        application_name ;	 
	 private String                        client_hostname  ;
	 private Integer                       client_port      ;
	 private Timestamp                     backend_start    ;
	 private Timestamp                     xact_start       ;
	 private Timestamp                     query_start      ;
	 private Timestamp                     state_change     ;
	 private String                        wait_event_type  ;
	 private String                        wait_event       ;
	 private String                        state            ;
	 private String                        backend_xid      ;
	 private String                        backend_xmin     ;
	 private String                        query            ;
	 private String                        backend_type     ;

	
	
	private static final long serialVersionUID = 1L;

}
