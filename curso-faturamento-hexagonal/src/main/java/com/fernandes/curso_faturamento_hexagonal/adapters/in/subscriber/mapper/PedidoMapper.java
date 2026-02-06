package com.fernandes.curso_faturamento_hexagonal.adapters.in.subscriber.mapper;

import com.fernandes.curso_faturamento_hexagonal.adapters.in.subscriber.representation.DetalhePedidoRepresentation;
import com.fernandes.curso_faturamento_hexagonal.application.core.domain.Pedido;

public interface PedidoMapper {

    Pedido toPedido(DetalhePedidoRepresentation representation);
}
