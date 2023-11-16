package com.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "platosPedido")
public class PlatoPedido {

    @Id
    private String idPlatoPedido;

    @Field("idPedido")
    private String idPedido;

    @Field("idPlato")
    private String idPlato;

    @Field("cantidad")
    private int cantidad;

    @Field("precioUnitario")
    private double precioUnitario;

    public PlatoPedido() {
    }
}