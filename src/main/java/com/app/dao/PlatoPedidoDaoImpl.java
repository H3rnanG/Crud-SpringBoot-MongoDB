package com.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.interfaces.PlatoPedidoDao;
import com.app.model.PlatoPedido;
import com.app.repository.PlatoPedidoRepository;

@Service
public class PlatoPedidoDaoImpl implements PlatoPedidoDao {

    @Autowired
    private PlatoPedidoRepository platoPedidoRepository;

    @Override
    public List<PlatoPedido> getAllPlatosPedidos() {
        return platoPedidoRepository.findAll();
    }

    @Override
    public PlatoPedido getPlatoPedido(String id) {
        return platoPedidoRepository.findById(id).orElse(null);
    }

    @Override
    public void addPlatoPedido(PlatoPedido platoPedido) {
        platoPedidoRepository.save(platoPedido);
    }

    @Override
    public void updatePlatoPedido(PlatoPedido platoPedido) {
        platoPedidoRepository.save(platoPedido);
    }

    @Override
    public void deletePlatoPedido(String id) {
        platoPedidoRepository.deleteById(id);
    }
}

