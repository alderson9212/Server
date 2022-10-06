package com.fenoreste.saicoop.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaDTO implements Serializable {

    JSONArray array = new JSONArray();
    private final long serialVersionUUID = 1L;
}
