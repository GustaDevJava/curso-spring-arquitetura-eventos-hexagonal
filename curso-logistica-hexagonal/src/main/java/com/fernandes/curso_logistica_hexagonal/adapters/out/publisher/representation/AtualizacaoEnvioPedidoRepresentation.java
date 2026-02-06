package com.fernandes.curso_logistica_hexagonal.adapters.out.publisher.representation;

import com.fernandes.curso_logistica_hexagonal.application.core.domain.enums.StatusPedido;

public record AtualizacaoEnvioPedidoRepresentation(
        Long codigo,
        StatusPedido status,
        String codigoRastreio
) {
}
