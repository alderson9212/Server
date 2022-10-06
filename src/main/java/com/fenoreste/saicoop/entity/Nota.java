package com.fenoreste.saicoop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nota implements Serializable {

    private String idnota;
    private String descripcion;
    private String nota;

    private final long serialVersionUUID = 1L;
}
