package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "cliente")
public class Cliente {
    
    @Id
    private String idCliente;
    
    private String nombreRazonSocial;
    
    private String tipoDocumento;
    
    private String numeroDocumento;
    
    private String telefonoCliente;
    
    private String correoCliente;
    
    private String direccionCliente;    

    public Cliente() {
    }
    
}
