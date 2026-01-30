package com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.dto;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.enums.TipoPagamento;

public record DadosPagamentoDTO(
        String dados,
        TipoPagamento tipoPagamento) {
}
