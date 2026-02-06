package com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.dto;

import java.math.BigDecimal;

public record DetalheItemPedidoDTO(
        Long codigoProduto,
        String nome,
        Integer quantidade,
        BigDecimal valorUnitario
) {
}
