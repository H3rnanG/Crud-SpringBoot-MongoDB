package com.app.interfaces;

import com.app.model.PlatoPedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlatoPedidoDao {

    List<PlatoPedido> getAllPlatosPedidos();

    PlatoPedido getPlatoPedido(String id);

    void addPlatoPedido(PlatoPedido platoPedido);

    void updatePlatoPedido(PlatoPedido platoPedido);

    void deletePlatoPedido(String id);
}
