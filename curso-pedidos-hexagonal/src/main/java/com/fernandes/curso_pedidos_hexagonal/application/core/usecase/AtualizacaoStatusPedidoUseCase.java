package com.fernandes.curso_pedidos_hexagonal.application.core.usecase;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.enums.StatusPedido;
import com.fernandes.curso_pedidos_hexagonal.application.ports.in.AtualizacaoStatusPedidoInputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.AtualizarPedidoOutputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.out.BuscarPedidoPorCodigoOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AtualizacaoStatusPedidoUseCase implements AtualizacaoStatusPedidoInputPort {

    private final BuscarPedidoPorCodigoOutputPort buscarPedidoPorCodigoOutputPort;
    private final AtualizarPedidoOutputPort atualizarPedidoOutputPort;

    private static final Logger log =
            LoggerFactory.getLogger(AtualizacaoStatusPedidoUseCase.class);

    public AtualizacaoStatusPedidoUseCase(BuscarPedidoPorCodigoOutputPort buscarPedidoPorCodigoOutputPort, AtualizarPedidoOutputPort atualizarPedidoOutputPort) {
        this.buscarPedidoPorCodigoOutputPort = buscarPedidoPorCodigoOutputPort;
        this.atualizarPedidoOutputPort = atualizarPedidoOutputPort;
    }

    @Override
    public void atualizarStatus(Long codigo, StatusPedido status, String urlNotaFiscal, String rastreio) {
        var pedidoOptional = buscarPedidoPorCodigoOutputPort.buscarPorCodigo(codigo);

        if(pedidoOptional.isEmpty()){
            log.warn("Pedido não encontrado para codigo: {}", codigo);
        }

        Pedido pedido = pedidoOptional.get();

        pedido.setStatus(status);
        if(urlNotaFiscal != null){
            pedido.setUrlNotaFiscal(urlNotaFiscal);
        }
        if (rastreio != null){
            pedido.setCodigoRastreio(rastreio);
        }

        atualizarPedidoOutputPort.atualizarPedido(pedido);

    }
}
