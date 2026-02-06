package com.fernandes.curso_pedidos_hexagonal.adapters.in.subscriber.representation;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.enums.StatusPedido;

public record AtualizacaoStatusPedidoRepresentation(
        Long codigo,
        StatusPedido status,
        String urlNotaFiscal,
        String codigoRastreio

) {
}
