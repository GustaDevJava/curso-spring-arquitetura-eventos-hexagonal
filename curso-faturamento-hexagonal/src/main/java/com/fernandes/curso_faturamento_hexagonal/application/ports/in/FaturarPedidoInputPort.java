package com.fernandes.curso_faturamento_hexagonal.application.ports.in;

import com.fernandes.curso_faturamento_hexagonal.application.core.domain.Pedido;

public interface FaturarPedidoInputPort {

    void faturarPedido(Pedido pedido);
}
