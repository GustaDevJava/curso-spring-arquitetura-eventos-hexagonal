package com.fernandes.curso_logistica_hexagonal.adapters.in.subscriber;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandes.curso_logistica_hexagonal.adapters.in.subscriber.representation.AtualizacaoFaturamentoRepresentation;
import com.fernandes.curso_logistica_hexagonal.application.ports.in.EnvioPedidoInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FaturamentoSubscriber {

    private final ObjectMapper objectMapper;

    private final EnvioPedidoInputPort envioPedidoInputPort;

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}",
            topics = "${icompras.config.kafka.topics.pedidos-faturados}")
    public void listener(String json) {
        log.info("Recebendo pedido para envio: {}", json);

        try {
            var atualizacaoFaturamento =
                    objectMapper.readValue(json, AtualizacaoFaturamentoRepresentation.class);

            envioPedidoInputPort.enviar(atualizacaoFaturamento.codigo(), atualizacaoFaturamento.urlNotaFiscal());
        } catch (Exception e) {
            log.error("Erro ao preparar pedido para envio", e);
        }

    }
}
