package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Plato;

@Repository
public interface PlatoRepository extends MongoRepository<Plato, String>{

}
