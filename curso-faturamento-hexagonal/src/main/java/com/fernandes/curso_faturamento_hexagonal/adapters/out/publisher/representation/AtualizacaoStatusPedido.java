package com.fernandes.curso_faturamento_hexagonal.adapters.out.publisher.representation;

import com.fernandes.curso_faturamento_hexagonal.adapters.out.publisher.representation.enums.StatusPedido;

public record AtualizacaoStatusPedido(
        Long codigo,
        StatusPedido status,
        String urlNotaFiscal
) {
}
