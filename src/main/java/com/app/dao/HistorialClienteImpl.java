package com.app.dao;

import com.app.interfaces.HistorialClienteDao;
import com.app.model.HistorialCliente;
import com.app.repository.HistorialClienteRepository;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistorialClienteImpl implements HistorialClienteDao{

    @Autowired
    private HistorialClienteRepository historialClienteRepository;

    @Override
    public List<HistorialCliente> getAllHistorialCliente() {
        return historialClienteRepository.findAll();
    }
    
    @Override
    public List<HistorialCliente> getAllWithIdCliente(ObjectId id) {
        return historialClienteRepository.findByClienteId(id);
    }

    @Override
    public HistorialCliente getHistorialCliente(String id) {
        return historialClienteRepository.findById(id).orElse(null);
    }

    @Override
    public void addHistorialCliente(HistorialCliente cliente) {
        historialClienteRepository.save(cliente);
    }

    @Override
    public void updateHistorialCliente(HistorialCliente cliente) {
        historialClienteRepository.save(cliente);
    }
        
}
