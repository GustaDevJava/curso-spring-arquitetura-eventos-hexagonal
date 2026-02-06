package com.fernandes.curso_logistica_hexagonal.adapters.in.subscriber.representation;

import com.fernandes.curso_logistica_hexagonal.application.core.domain.enums.StatusPedido;

public record AtualizacaoFaturamentoRepresentation(
        Long codigo,
        StatusPedido status,
        String urlNotaFiscal,
        String codigoRastreio
) {
}
