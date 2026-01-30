package com.fernandes.curso_pedidos_hexagonal.application.ports.in;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;

public interface CriarPedidoInputPort {

    Pedido criarPedido(Pedido pedido);
}
