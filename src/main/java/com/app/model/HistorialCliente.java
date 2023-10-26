package com.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@Document(collection = "historialCliente")
public class HistorialCliente {

    @Id
    private String idHistorialCliente;
    
    private ObjectId idCliente;
    
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "UTC")
    private Date fechaVisitante;
    
    private String descripcion;

    public HistorialCliente() {
    }
    
}
