package com.fernandes.icompras.curso.produtos.hexagonal.adapters.in.controller.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoResponse {

    private Long codigo;
    private String nome;
    private BigDecimal valorUnitario;
    private boolean ativo;
}
