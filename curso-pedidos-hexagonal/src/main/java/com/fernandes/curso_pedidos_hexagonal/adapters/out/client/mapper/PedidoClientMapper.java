package com.fernandes.curso_pedidos_hexagonal.adapters.out.client.mapper;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.client.model.PedidoClient;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoClientMapper {

    PedidoClient toPedidoClient(Pedido pedido);
}
