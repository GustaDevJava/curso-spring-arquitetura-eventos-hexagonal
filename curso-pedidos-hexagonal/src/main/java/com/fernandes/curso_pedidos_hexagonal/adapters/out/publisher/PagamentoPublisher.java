package com.fernandes.curso_pedidos_hexagonal.adapters.out.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.publisher.representation.DetalhePedidoRepresentation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PagamentoPublisher {

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${icompras.config.kafka.topics.pedidos-pagos}")
    private String topico;

    public void publicar(DetalhePedidoRepresentation representation){
        log.info("Publicando pedido pago {}", representation.codigo());

        try {
            var json = objectMapper.writeValueAsString(representation);
            kafkaTemplate.send(topico, "dados", json);
        }catch (JsonProcessingException e){
            log.error("Erro ao processar o json", e);
        }catch (RuntimeException e){
            log.error("Erro técnico ao publicar no tópico de pedidos", e);
        }
    }

}

