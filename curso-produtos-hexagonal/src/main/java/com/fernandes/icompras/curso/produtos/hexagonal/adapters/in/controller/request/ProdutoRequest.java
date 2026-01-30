package com.fernandes.icompras.curso.produtos.hexagonal.adapters.in.controller.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoRequest {

    private String nome;
    private BigDecimal valorUnitario;
}
