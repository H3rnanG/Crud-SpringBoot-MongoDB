package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.model.PlatoPedido;

@Repository
public interface PlatoPedidoRepository extends MongoRepository<PlatoPedido, String>{

}
