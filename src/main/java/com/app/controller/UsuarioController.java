package com.app.controller;

import com.app.interfaces.UsuarioDao;
import com.app.model.Usuario;
import com.app.services.JsonResponseComponent;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private JsonResponseComponent jsonResponseComponent;
    
    @Autowired
    private UsuarioDao clienteDao;
    
    @GetMapping
    public List<Usuario> getAllUsuarios(){
        return clienteDao.getAllUsuarios();
    }
    
    @GetMapping("/")
    public Usuario getCliente(@RequestParam("id") String id){
        return clienteDao.getUsuario(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<JsonNode> addUsuario(@RequestBody Usuario cliente) {
        jsonResponseComponent.clearJsonResponse();
        try {
            clienteDao.addUsuario(cliente);
            jsonResponseComponent.addProperty("message", "Usuario Creado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }
    
    @PutMapping("/")
    public ResponseEntity<JsonNode> updateUsuario(@RequestBody Usuario cliente) {
        jsonResponseComponent.clearJsonResponse();
        try {
            clienteDao.updateUsuario(cliente);
            jsonResponseComponent.addProperty("message", "Usuario Actualizado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }
    
    @DeleteMapping("/")
    public ResponseEntity<JsonNode> deleteUsuario(@RequestParam("id") String id) {
        jsonResponseComponent.clearJsonResponse();
        try {
            clienteDao.deleteUsuario(id);
            jsonResponseComponent.addProperty("message", "Usuario Eliminado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }
    
}
