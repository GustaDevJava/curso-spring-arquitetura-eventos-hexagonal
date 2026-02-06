package com.fernandes.curso_faturamento_hexagonal.adapters.out.publisher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandes.curso_faturamento_hexagonal.adapters.out.publisher.representation.AtualizacaoStatusPedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FaturamentoPublisher {

    public final KafkaTemplate<String, String> kafkaTemplate;

    public final ObjectMapper objectMapper;

    @Value("${icompras.config.kafka.topics.pedidos-faturados}")
    private String topico;

    public void publicar(AtualizacaoStatusPedido pedido) {

        try {
            String json = objectMapper.writeValueAsString(pedido);
            kafkaTemplate.send(topico, "dados", json);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
