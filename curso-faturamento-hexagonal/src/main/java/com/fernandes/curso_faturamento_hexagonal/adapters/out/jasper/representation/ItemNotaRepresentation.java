package com.fernandes.curso_faturamento_hexagonal.adapters.out.jasper.representation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ItemNotaRepresentation {

    private Long codigoProduto;
    private String nome;
    private Integer quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal total;

}
