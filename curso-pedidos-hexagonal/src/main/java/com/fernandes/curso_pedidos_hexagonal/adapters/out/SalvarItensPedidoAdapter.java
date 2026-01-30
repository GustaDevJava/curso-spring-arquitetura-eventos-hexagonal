package com.fernandes.curso_pedidos_hexagonal.adapters.out;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.ItemPedidoRepository;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.factory.ItemPedidoEntityFactory;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.mappers.ItemPedidoEntityMapper;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.repository.mappers.PedidoEntityMapper;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.ItemPedido;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.SalvarItensPedidoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SalvarItensPedidoAdapter implements SalvarItensPedidoOutputPort {

    private final ItemPedidoRepository repository;

    private final ItemPedidoEntityMapper mapper;

    private final ItemPedidoEntityFactory factory;

    @Override
    public void salvarItensPedido(List<ItemPedido> itens, Long codigoPedido) {
        var itensPedidoEntity = itens.stream().map(item -> factory.criar(item, mapper, codigoPedido)).toList();
        repository.saveAll(itensPedidoEntity);
    }
}
