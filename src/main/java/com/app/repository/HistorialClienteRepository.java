package com.app.repository;

import com.app.model.HistorialCliente;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialClienteRepository extends MongoRepository<HistorialCliente, String>{
    
    @Query("{'idCliente': ?0}")
    List<HistorialCliente> findByClienteId(ObjectId idCliente);
    
}
