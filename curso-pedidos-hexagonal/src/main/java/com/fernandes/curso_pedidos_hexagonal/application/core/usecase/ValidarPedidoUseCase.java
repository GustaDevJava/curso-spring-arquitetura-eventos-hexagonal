package com.fernandes.curso_pedidos_hexagonal.application.core.usecase;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.ItemPedido;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.BuscarClienteOutputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.BuscarProdutoOutputPort;

public class ValidarPedidoUseCase {

    private final BuscarProdutoOutputPort buscarProdutoOutputPort;
    private final BuscarClienteOutputPort buscarClienteOutputPort;

    public ValidarPedidoUseCase(BuscarProdutoOutputPort buscarProdutoOutputPort, BuscarClienteOutputPort buscarClienteOutputPort) {
        this.buscarProdutoOutputPort = buscarProdutoOutputPort;
        this.buscarClienteOutputPort = buscarClienteOutputPort;
    }

    public void validar(Pedido pedido){
        Long codigoCliente = pedido.getCodigoCliente();
        validarCliente(codigoCliente);
        pedido.getItens().forEach(this::validarItem);
    }

    private void validarCliente(Long codigoCliente){
        buscarClienteOutputPort.obterDadosCliente(codigoCliente);
    }

    private void validarItem(ItemPedido item){
        buscarProdutoOutputPort.obterDadosProduto(item.getCodigoProduto());
    }
}
