package com.fernandes.curso_pedidos_hexagonal.application.core.usecase;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.DadosPagamento;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.enums.StatusPedido;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.enums.TipoPagamento;
import com.fernandes.curso_pedidos_hexagonal.application.core.exception.PedidoNaoEncontradoException;
import com.fernandes.curso_pedidos_hexagonal.application.ports.in.AdicionarNovoPagamentoInuptPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.AtualizarPedidoOutputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.BuscarPedidoPorCodigoOutputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.CriarPedidoOutputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.SolicitarPagamentoOutputPort;

public class AdicionarNovoPagamentoUseCase implements AdicionarNovoPagamentoInuptPort {

    private final BuscarPedidoPorCodigoOutputPort buscarPedidoPorCodigoOutputPort;

    private final SolicitarPagamentoOutputPort solicitarPagamentoOutputPort;

    private final AtualizarPedidoOutputPort atualizarPedidoOutputPort;

    public AdicionarNovoPagamentoUseCase(BuscarPedidoPorCodigoOutputPort buscarPedidoPorCodigoOutputPort, SolicitarPagamentoOutputPort solicitarPagamentoOutputPort, AtualizarPedidoOutputPort atualizarPedidoOutputPort) {
        this.buscarPedidoPorCodigoOutputPort = buscarPedidoPorCodigoOutputPort;
        this.solicitarPagamentoOutputPort = solicitarPagamentoOutputPort;
        this.atualizarPedidoOutputPort = atualizarPedidoOutputPort;
    }

    @Override
    public void adicionarNovoPagamento(Long codigoPedido, String dadosCartao, TipoPagamento tipo){

        var pedidoEncontrado = buscarPedidoPorCodigoOutputPort.buscarPorCodigo(codigoPedido);

        if(pedidoEncontrado.isEmpty()){
            throw new PedidoNaoEncontradoException("Pedido não encontrado para código informado!", 400);
        }

        var pedido = pedidoEncontrado.get();

        DadosPagamento dadosPagamento = new DadosPagamento();
        dadosPagamento.setTipoPagamento(tipo);
        dadosPagamento.setDados(dadosCartao);

        pedido.setDadosPagamento(dadosPagamento);
        pedido.setStatus(StatusPedido.REALIZADO);
        pedido.setObservacoes("Novo pagamento realizado, aguandando processamento");

        String novaChavePagamento = solicitarPagamentoOutputPort.solicitarPagamento(pedido);
        pedido.setChavePagamento(novaChavePagamento);

        atualizarPedidoOutputPort.atualizarPedido(pedido);
    }
}
