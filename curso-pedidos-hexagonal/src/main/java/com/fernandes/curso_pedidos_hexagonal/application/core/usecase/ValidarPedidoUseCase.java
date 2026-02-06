package com.fernandes.curso_pedidos_hexagonal.application.core.usecase;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Cliente;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.ItemPedido;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Produto;
import com.fernandes.curso_pedidos_hexagonal.application.core.exception.ValidationException;
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

        Cliente cliente = buscarClienteOutputPort.obterDadosCliente(codigoCliente);

        if(!cliente.isAtivo()){
            throw new ValidationException("codigoCliente","Cliente Inativo.");
        }
    }

    private void validarItem(ItemPedido item){
        Produto produto = buscarProdutoOutputPort.obterDadosProduto(item.getCodigoProduto());

        if (!produto.isAtivo()){
            throw new ValidationException("codigoProduto", "Produto Inativo.");
        }
    }
}
