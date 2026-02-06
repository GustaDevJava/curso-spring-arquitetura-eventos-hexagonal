package com.fernandes.curso_pedidos_hexagonal.adapters.in.subscriber;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandes.curso_pedidos_hexagonal.adapters.in.subscriber.representation.AtualizacaoStatusPedidoRepresentation;
import com.fernandes.curso_pedidos_hexagonal.application.ports.in.AtualizacaoStatusPedidoInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AtualizacaoStatusPedidoSubscriber {

    private final ObjectMapper objectMapper;

    private final AtualizacaoStatusPedidoInputPort atualizacaoStatusPedidoInputPort;

    @KafkaListener(groupId = "icompras-atualizacao-pedido",
            topics = {
                    "${icompras.config.kafka.topics.pedidos-faturados}",
                    "${icompras.config.kafka.topics.pedidos-enviados}"
            })
    public void receberAtualizacao(String json) {
        log.info("Recebendo atualizacao de status: {}", json);

        try {
            var atualizacaoStatus =
                    objectMapper.readValue(json, AtualizacaoStatusPedidoRepresentation.class);

            atualizacaoStatusPedidoInputPort.atualizarStatus(
                    atualizacaoStatus.codigo(),
                    atualizacaoStatus.status(),
                    atualizacaoStatus.urlNotaFiscal(),
                    atualizacaoStatus.codigoRastreio());

            log.info("Pedido atualizado com sucesso!");
        } catch (Exception e) {
            log.error("Erro ao atualizar status pedido: {}", e.getMessage());
        }
    }
}
