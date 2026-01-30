package com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.dto;

import java.math.BigDecimal;

public record ItemPedidoDTO(
        Long codigoProduto,
        Integer quantidade,
        BigDecimal valorUnitario) {
}
