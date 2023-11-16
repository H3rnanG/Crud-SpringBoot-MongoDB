package com.app.controller;

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

import com.app.interfaces.PlatoPedidoDao;
import com.app.model.PlatoPedido;

import com.app.services.JsonResponseComponent;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/platoPedido")
public class PlatoPedidoController {

    @Autowired
    private JsonResponseComponent jsonResponseComponent;

    @Autowired
    private PlatoPedidoDao platoPedidoDao;

    @GetMapping
    public List<PlatoPedido> getAllPlatosPedidos() {
        return platoPedidoDao.getAllPlatosPedidos();
    }

    @GetMapping("/")
    public PlatoPedido getPlatoPedido(@RequestParam("id") String id) {
        return platoPedidoDao.getPlatoPedido(id);
    }

    @PostMapping("/")
    public ResponseEntity<JsonNode> addPlatoPedido(@RequestBody PlatoPedido platoPedido) {
        jsonResponseComponent.clearJsonResponse();
        try {
            platoPedidoDao.addPlatoPedido(platoPedido);
            jsonResponseComponent.addProperty("message", "Plato Pedido Creado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }

    @PutMapping("/")
    public ResponseEntity<JsonNode> updatePlatoPedido(@RequestBody PlatoPedido platoPedido) {
        jsonResponseComponent.clearJsonResponse();
        try {
            platoPedidoDao.updatePlatoPedido(platoPedido);
            jsonResponseComponent.addProperty("message", "Plato Pedido Actualizado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }

    @DeleteMapping("/")
    public ResponseEntity<JsonNode> deletePlatoPedido(@RequestParam("id") String id) {
        jsonResponseComponent.clearJsonResponse();
        try {
            platoPedidoDao.deletePlatoPedido(id);
            jsonResponseComponent.addProperty("message", "Plato Pedido Eliminado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }
}
