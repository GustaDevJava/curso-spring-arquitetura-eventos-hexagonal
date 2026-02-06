package com.fernandes.curso_faturamento_hexagonal.adapters.out;

import com.fernandes.curso_faturamento_hexagonal.adapters.out.publisher.FaturamentoPublisher;
import com.fernandes.curso_faturamento_hexagonal.adapters.out.publisher.representation.AtualizacaoStatusPedido;
import com.fernandes.curso_faturamento_hexagonal.adapters.out.publisher.representation.enums.StatusPedido;
import com.fernandes.curso_faturamento_hexagonal.application.core.domain.Pedido;
import com.fernandes.curso_faturamento_hexagonal.application.ports.out.FaturarPedidoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FaturarPedidoAdapter implements FaturarPedidoOutputPort {

    private final FaturamentoPublisher publisher;

    @Override
    public void publicar(Pedido pedido, String urlNotaFiscal) {
        var atulizaStatusPedido = new AtualizacaoStatusPedido(
                pedido.getCodigo(),
                StatusPedido.FATURADO,
                urlNotaFiscal);
        publisher.publicar(atulizaStatusPedido);
    }
}
