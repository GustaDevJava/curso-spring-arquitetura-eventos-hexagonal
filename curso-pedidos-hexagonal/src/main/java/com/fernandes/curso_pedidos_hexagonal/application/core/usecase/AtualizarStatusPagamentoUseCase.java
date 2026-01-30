package com.fernandes.curso_pedidos_hexagonal.application.core.usecase;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.enums.StatusPedido;
import com.fernandes.curso_pedidos_hexagonal.application.ports.in.AtualizarStatusPagamentoInputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.AtualizarPedidoOutputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.BuscarPedidoPorCodigoEChaveOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AtualizarStatusPagamentoUseCase implements AtualizarStatusPagamentoInputPort {

    private final BuscarPedidoPorCodigoEChaveOutputPort buscarPedidoPorCodigoEChaveOutputPort;
    private final AtualizarPedidoOutputPort atualizarPedidoOutputPort;

    private static final Logger log =
            LoggerFactory.getLogger(AtualizarStatusPagamentoUseCase.class);

    public AtualizarStatusPagamentoUseCase(BuscarPedidoPorCodigoEChaveOutputPort buscarPedidoPorCodigoEChaveOutputPort, AtualizarPedidoOutputPort atualizarPedidoOutputPort) {
        this.buscarPedidoPorCodigoEChaveOutputPort = buscarPedidoPorCodigoEChaveOutputPort;
        this.atualizarPedidoOutputPort = atualizarPedidoOutputPort;
    }

    public void atualizarStatusPagamento(
            Long codigoPedido, String chavePagamento, boolean sucesso, String observacoes){
       var pedidoOptional = buscarPedidoPorCodigoEChaveOutputPort.buscarPorCodigoEChavePagamento
                (codigoPedido, chavePagamento);

        if(pedidoOptional.isEmpty()){
            var msg = String.format("Pedido não encontrado para o código %d e chave pgmto %s",
                    codigoPedido, chavePagamento);
            log.error(msg);
            return;
        }

        Pedido pedido = pedidoOptional.get();

        if(sucesso){
            pedido.setStatus(StatusPedido.PAGO);
        }else {
            pedido.setStatus(StatusPedido.ERRO_PAGAMENTO);
            pedido.setObservacoes(observacoes);
        }

        atualizarPedidoOutputPort.atualizarPedido(pedido);
    }
}
