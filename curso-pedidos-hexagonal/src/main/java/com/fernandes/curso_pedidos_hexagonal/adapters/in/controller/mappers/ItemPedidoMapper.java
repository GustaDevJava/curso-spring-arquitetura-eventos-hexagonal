package com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.mappers;

import com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.dto.ItemPedidoDTO;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.ItemPedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {

    @Mapping(target = "nome", ignore = true)
    @Mapping(target = "codigo", ignore = true)
    @Mapping(target = "codigoPedido", ignore = true)
    ItemPedido toItemPedido(ItemPedidoDTO itemPedidoDTO);

}
