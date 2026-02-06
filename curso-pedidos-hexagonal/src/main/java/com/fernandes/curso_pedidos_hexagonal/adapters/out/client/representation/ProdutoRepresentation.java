package com.fernandes.curso_pedidos_hexagonal.adapters.out.client.representation;

import java.math.BigDecimal;

public record ProdutoRepresentation(
        Long codigo,
        String nome,
        BigDecimal valorUnitario,
        boolean ativo
) {
}
