package com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.mappers;

import com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.dto.ItemPedidoDTO;
import com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.mappers.ItemPedidoMapper;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.entity.ItemPedidoEntity;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.entity.PedidoEntity;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.ItemPedido;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.enums.StatusPedido;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoEntityMapper {

    ItemPedidoEntityMapper ITEM_PEDIDO_ENTITY_MAPPER = Mappers.getMapper(ItemPedidoEntityMapper.class);

    PedidoEntity toPedidoEntity(Pedido pedido);

    @Mapping(source = "itens", target = "itens", qualifiedByName = "mapItens")
    @Mapping(target = "dadosCliente", ignore = true)
    Pedido toPedido(PedidoEntity pedidoEntity);

    @Named("mapItens")
    default List<ItemPedido> mapItens(List<ItemPedidoEntity> entities){
        return entities.stream().map(ITEM_PEDIDO_ENTITY_MAPPER::toItemPedido).toList();
    }

    @AfterMapping
    default void afertMapping(@MappingTarget PedidoEntity pedidoEntity){
        pedidoEntity.getItens().forEach(item -> item.setPedido(pedidoEntity));
    }
}
