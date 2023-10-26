package com.app.interfaces;

import com.app.model.HistorialCliente;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public interface HistorialClienteDao {
    
    List<HistorialCliente> getAllHistorialCliente();
    List<HistorialCliente> getAllWithIdCliente(ObjectId id);
    HistorialCliente getHistorialCliente(String id);
    void addHistorialCliente(HistorialCliente cliente);
    void updateHistorialCliente(HistorialCliente cliente);
    
}
