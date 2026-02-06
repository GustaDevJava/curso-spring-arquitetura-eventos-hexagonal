package com.fernandes.curso_logistica_hexagonal.adapters.out.publisher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandes.curso_logistica_hexagonal.adapters.out.publisher.representation.AtualizacaoEnvioPedidoRepresentation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EnvioPedidoPublisher {

    @Value("${icompras.config.kafka.topics.pedidos-enviados}")
    private String topico;

    private final ObjectMapper objectMapper;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void enviarPedido(AtualizacaoEnvioPedidoRepresentation atualizacaoEnvioPedido) {
        try {
            var json = objectMapper.writeValueAsString(atualizacaoEnvioPedido);
            kafkaTemplate.send(topico, "dados", json);
        } catch (Exception e) {
            log.error("Erro ao enviar mensagem.");
        }

    }
}
