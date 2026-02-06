package com.fernandes.curso_pedidos_hexagonal.application.ports.in;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.enums.StatusPedido;

public interface AtualizacaoStatusPedidoInputPort {

    void atualizarStatus(Long codigo, StatusPedido status, String urlNotaFiscal, String rastreio);
}
