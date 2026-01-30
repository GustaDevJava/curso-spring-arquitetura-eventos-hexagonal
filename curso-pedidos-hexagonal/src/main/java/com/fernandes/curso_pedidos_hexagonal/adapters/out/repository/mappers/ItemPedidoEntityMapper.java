package com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.mappers;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.entity.ItemPedidoEntity;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.entity.PedidoEntity;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.ItemPedido;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemPedidoEntityMapper {

    @Mapping(source = "pedido.codigo", target = "codigoPedido")
    @Mapping(target = "nome", ignore = true)
    ItemPedido toItemPedido(ItemPedidoEntity itemPedidoEntity);

    @Mapping(target = "pedido", ignore = true)
    ItemPedidoEntity toItemPedidoEntity(ItemPedido item);
}
