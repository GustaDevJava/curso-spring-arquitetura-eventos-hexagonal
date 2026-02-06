package com.fernandes.curso_pedidos_hexagonal.application.core.usecase;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.ItemPedido;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_pedidos_hexagonal.application.core.exception.PedidoNaoEncontradoException;
import com.fernandes.curso_pedidos_hexagonal.application.ports.in.CarregarPedidoInputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.BuscarClienteOutputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.BuscarItensPedidoOutputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.BuscarPedidoPorCodigoOutputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.BuscarProdutoOutputPort;

import java.util.List;

public class CarregarPedidoUseCase implements CarregarPedidoInputPort {

    private final BuscarPedidoPorCodigoOutputPort buscarPedidoPorCodigoOutputPort;
    private final BuscarClienteOutputPort buscarClienteOutputPort;
    private final BuscarItensPedidoOutputPort buscarItensPedidoOutputPort;
    private final BuscarProdutoOutputPort buscarProdutoOutputPort;

    public CarregarPedidoUseCase(BuscarPedidoPorCodigoOutputPort buscarPedidoPorCodigoOutputPort, BuscarClienteOutputPort buscarClienteOutputPort, BuscarItensPedidoOutputPort buscarItensPedidoOutputPort, BuscarProdutoOutputPort buscarProdutoOutputPort) {
        this.buscarPedidoPorCodigoOutputPort = buscarPedidoPorCodigoOutputPort;
        this.buscarClienteOutputPort = buscarClienteOutputPort;
        this.buscarItensPedidoOutputPort = buscarItensPedidoOutputPort;
        this.buscarProdutoOutputPort = buscarProdutoOutputPort;
    }

    @Override
    public Pedido carregarDadosCompletosPedido(Long codigo){
        var pedido = buscarPedidoPorCodigoOutputPort.buscarPorCodigo(codigo);

        if (pedido.isEmpty()){
            String msg = String.format("Pedido não encontrado para código: %s", codigo);
            throw new PedidoNaoEncontradoException(msg, 404);
        }

        pedido.ifPresent(this::carregarDadosCliente);
        pedido.ifPresent(this::carregarItensPedido);

        return pedido.get();
    }

    private void carregarDadosCliente(Pedido pedido){
        Long codigoCliente = pedido.getCodigoCliente();
        var cliente = buscarClienteOutputPort.obterDadosCliente(codigoCliente);
        pedido.setDadosCliente(cliente);
    }

    private void carregarItensPedido(Pedido pedido){
        List<ItemPedido> itens = buscarItensPedidoOutputPort.buscarItensPedido(pedido);
        pedido.setItens(itens);
        pedido.getItens().forEach(this::carregarDadosProduto);
    }

    private void carregarDadosProduto(ItemPedido item){
        var produto = buscarProdutoOutputPort.obterDadosProduto(item.getCodigoProduto());
        item.setNome(produto.getNome());
    }
}
