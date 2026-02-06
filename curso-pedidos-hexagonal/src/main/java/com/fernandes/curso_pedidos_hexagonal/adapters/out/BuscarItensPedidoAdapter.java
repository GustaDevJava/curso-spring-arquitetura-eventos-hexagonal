package com.fernandes.curso_pedidos_hexagonal.adapters.out;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.ItemPedidoRepository;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.entity.ItemPedidoEntity;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.mappers.ItemPedidoEntityMapper;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.mappers.PedidoEntityMapper;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.ItemPedido;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.BuscarItensPedidoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarItensPedidoAdapter implements BuscarItensPedidoOutputPort {

    private final ItemPedidoRepository repository;
    private final PedidoEntityMapper pedidoEntityMapper;
    private final ItemPedidoEntityMapper itemPedidoEntityMapper;

    @Override
    public List<ItemPedido> buscarItensPedido(Pedido pedido) {
        var pedidoEntity = pedidoEntityMapper.toPedidoEntity(pedido);
        List<ItemPedidoEntity> itensEntity = repository.findByPedido(pedidoEntity);
        return itensEntity.stream().map(itemPedidoEntityMapper::toItemPedido).toList();
    }
}
