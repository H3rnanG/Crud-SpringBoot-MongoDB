package com.app.interfaces;

import com.app.model.Cliente;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ClienteDao {

    List<Cliente> getAllClientes();
    Cliente getCliente(String id);
    void addCliente(Cliente cliente);
    void updateCliente(Cliente cliente);
    void deleteCliente(String id);
    
}
