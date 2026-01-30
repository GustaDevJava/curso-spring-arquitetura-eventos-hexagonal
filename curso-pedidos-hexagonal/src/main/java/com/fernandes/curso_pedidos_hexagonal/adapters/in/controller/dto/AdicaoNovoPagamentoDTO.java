package com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.dto;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.enums.TipoPagamento;

public record AdicaoNovoPagamentoDTO(Long codigoPedido, String dadosCartao, TipoPagamento tipoPagamento) {
}
