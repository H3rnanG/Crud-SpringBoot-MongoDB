package com.app.controller;

import com.app.interfaces.HistorialClienteDao;
import com.app.model.HistorialCliente;
import com.app.services.JsonResponseComponent;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historialCliente")
public class HistorialClienteController {

    @Autowired
    private JsonResponseComponent jsonResponseComponent;
    
    @Autowired
    private HistorialClienteDao historialClienteDao;
    
    @GetMapping
    public List<HistorialCliente> getAllHistorialCliente(){
        return historialClienteDao.getAllHistorialCliente();
    };
    
    @GetMapping("/getAllWithId/")
    public List<HistorialCliente> getAllWithIdCliente(@RequestParam("id") String id){
        ObjectId idCliente = new ObjectId(id);
        return historialClienteDao.getAllWithIdCliente(idCliente);
    };
    
    @GetMapping("/")
    public HistorialCliente getHistorialCliente(@RequestParam("id") String id){
        return historialClienteDao.getHistorialCliente(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<JsonNode> addCliente(@RequestBody HistorialCliente historialCliente) {
        jsonResponseComponent.clearJsonResponse();
        try {
            historialClienteDao.addHistorialCliente(historialCliente);
            jsonResponseComponent.addProperty("message", "Historial Creado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }
    
    @PutMapping("/")
    public ResponseEntity<JsonNode> updateCliente(@RequestBody HistorialCliente historialCliente) {
        jsonResponseComponent.clearJsonResponse();
        try {
            historialClienteDao.updateHistorialCliente(historialCliente);
            jsonResponseComponent.addProperty("message", "Historial Actualizado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }
    
}
