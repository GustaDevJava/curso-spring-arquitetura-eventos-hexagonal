package com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.factory;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.entity.ItemPedidoEntity;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.entity.PedidoEntity;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.mappers.ItemPedidoEntityMapper;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.ItemPedido;
import org.springframework.stereotype.Component;

@Component
public class ItemPedidoEntityFactory {

    public ItemPedidoEntity criar(ItemPedido itemPedido, ItemPedidoEntityMapper mapper, Long codigoPedido){
        var itemPedidoEntity = mapper.toItemPedidoEntity(itemPedido);
        var pedidoEntity = new PedidoEntity();

        pedidoEntity.setCodigo(codigoPedido);
        itemPedidoEntity.setPedido(pedidoEntity);

        return itemPedidoEntity;
    }
}
