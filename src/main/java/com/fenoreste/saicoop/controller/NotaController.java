package com.fenoreste.saicoop.controller;

import com.fenoreste.saicoop.entity.Nota;
import com.fenoreste.saicoop.entity.RespuestaDTO;
import com.fenoreste.saicoop.service.INotaService;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping({ "/api/notas" })
public class NotaController {
   @Autowired
   INotaService notaService;

   @RequestMapping(value="/buscarPorId/id={id}&ip={ip}&db={db}", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
   public Nota buscarPorId(@PathVariable String id,@PathVariable String ip,@PathVariable String db){
      return notaService.buscarNotaPorId(id,ip,db);
   }

   @RequestMapping(value="/ejecutar/ip={ip}&db={db}", method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
   public ResponseEntity<?> ejecutar(@PathVariable String ip, @PathVariable String db, @RequestBody String cadena){
      JsonObject json = new JsonObject();
      System.out.println(cadena);
      try{
         JSONObject jsonEntrada = new JSONObject(cadena);
         cadena = jsonEntrada.getString("query");
         JsonArray lista = notaService.ejecutarQuery(ip,db,cadena);
         json.put("totalRegistros",lista.size());
         json.put("Objeto",lista);
         System.out.println(json);
      }catch (Exception e){
         System.out.println("Error al ejecutar busqueda:"+e.getMessage());
      }
      return ResponseEntity.status(200).body(json);
   }


}
