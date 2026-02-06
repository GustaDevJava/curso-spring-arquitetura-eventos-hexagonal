package com.fernandes.curso_faturamento_hexagonal.adapters.out.jasper.mapper.impl;

import com.fernandes.curso_faturamento_hexagonal.adapters.out.jasper.mapper.PedidoNotaMapper;
import com.fernandes.curso_faturamento_hexagonal.adapters.out.jasper.representation.ItemNotaRepresentation;
import com.fernandes.curso_faturamento_hexagonal.adapters.out.jasper.representation.PedidoNotaRepresentation;
import com.fernandes.curso_faturamento_hexagonal.application.core.domain.ItemPedido;
import com.fernandes.curso_faturamento_hexagonal.application.core.domain.Pedido;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoNotaMapperImpl implements PedidoNotaMapper {


    @Override
    public PedidoNotaRepresentation toPedidoNota(Pedido pedido) {
        List<ItemNotaRepresentation> itens = pedido.getItens().stream().map(this::toItemNota).toList();

        var pedidoNotaRepresentation
                = new PedidoNotaRepresentation(pedido.getCliente().getNome(),
                pedido.getCliente().getCpf(),
                pedido.getCliente().getLogradouro(),
                pedido.getCliente().getNumero(),
                pedido.getCliente().getBairro(),
                pedido.getCliente().getEmail(),
                pedido.getCliente().getTelefone(),
                pedido.getData(),
                pedido.getTotal(),
                itens);

        return pedidoNotaRepresentation;
    }

    private ItemNotaRepresentation toItemNota(ItemPedido itemPedido){
        return new ItemNotaRepresentation(itemPedido.getCodigo(), itemPedido.getDescricao(), itemPedido.getQuantidade(), itemPedido.getValorUnitario(), itemPedido.getTotal());
    }
}
