package com.fernandes.curso_faturamento_hexagonal.adapters.in.subscriber.mapper.impl;

import com.fernandes.curso_faturamento_hexagonal.adapters.in.subscriber.mapper.PedidoMapper;
import com.fernandes.curso_faturamento_hexagonal.adapters.in.subscriber.representation.DetalhePedidoRepresentation;
import com.fernandes.curso_faturamento_hexagonal.application.core.domain.Cliente;
import com.fernandes.curso_faturamento_hexagonal.application.core.domain.ItemPedido;
import com.fernandes.curso_faturamento_hexagonal.application.core.domain.Pedido;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoMapperImpl implements PedidoMapper {

    @Override
    public Pedido toPedido(DetalhePedidoRepresentation representation) {
        Pedido pedido = new Pedido();
        pedido.setCodigo(representation.codigo());

        Cliente cliente = new Cliente();
        cliente.setNome(representation.nome());
        cliente.setCpf(representation.cpf());
        cliente.setLogradouro(representation.logradouro());
        cliente.setNumero(representation.numero());
        cliente.setBairro(representation.bairro());
        cliente.setEmail(representation.email());
        cliente.setTelefone(representation.telefone());

        pedido.setCliente(cliente);

        pedido.setData(representation.dataPedido());
        pedido.setTotal(representation.total());

        List<ItemPedido> itens = representation.itens().stream().map(itemRepresentation -> {
                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setCodigo(itemRepresentation.codigoProduto());
                    itemPedido.setDescricao(itemRepresentation.nome());
                    itemPedido.setValorUnitario(itemRepresentation.valorUnitario());
                    itemPedido.setQuantidade(itemRepresentation.quantidade());
                    return itemPedido;
                }
        ).toList();

        pedido.setItens(itens);
        return pedido;
    }
}
