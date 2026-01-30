package com.fernandes.curso_pedidos_hexagonal.application.core.usecase;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_pedidos_hexagonal.application.ports.in.CriarPedidoInputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.AtualizarPedidoOutputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.CriarPedidoOutputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.SalvarItensPedidoOutputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.SolicitarPagamentoOutputPort;

public class CriarPedidoUseCase implements CriarPedidoInputPort {

    private final CriarPedidoOutputPort criarPedidoOutputPort;

    private final SalvarItensPedidoOutputPort salvarItensPedidoOutputPort;

    private final ValidarPedidoUseCase validarPedidoUseCase;

    private final SolicitarPagamentoOutputPort solicitarPagamentoOutputPort;

    private final AtualizarPedidoOutputPort atualizarPedidoOutputPort;

    public CriarPedidoUseCase(CriarPedidoOutputPort criarPedidoOutputPort, SalvarItensPedidoOutputPort salvarItensPedidoOutputPort, ValidarPedidoUseCase validarPedidoUseCase, SolicitarPagamentoOutputPort solicitarPagamentoOutputPort, AtualizarPedidoOutputPort atualizarPedidoOutputPort) {
        this.criarPedidoOutputPort = criarPedidoOutputPort;
        this.salvarItensPedidoOutputPort = salvarItensPedidoOutputPort;
        this.validarPedidoUseCase = validarPedidoUseCase;
        this.solicitarPagamentoOutputPort = solicitarPagamentoOutputPort;
        this.atualizarPedidoOutputPort = atualizarPedidoOutputPort;

    }

    @Override
    public Pedido criarPedido(Pedido pedido) {
        validarPedidoUseCase.validar(pedido);
        var pedidoSalvo = realizarPersistencia(pedido);
        envioSolicitacaoPagamento(pedidoSalvo);
        atualizarPedidoOutputPort.atualizarPedido(pedidoSalvo);
        return pedidoSalvo;
    }

    private void envioSolicitacaoPagamento(Pedido pedidoSalvo) {
        var chavePagamento = solicitarPagamentoOutputPort.solicitarPagamento(pedidoSalvo);
        pedidoSalvo.setChavePagamento(chavePagamento);
    }

    private Pedido realizarPersistencia(Pedido pedido) {
        var pedidoSalvo = criarPedidoOutputPort.criarPedido(pedido);
        salvarItensPedidoOutputPort.salvarItensPedido(pedidoSalvo.getItens(), pedidoSalvo.getCodigo());
        return pedidoSalvo;
    }
}
