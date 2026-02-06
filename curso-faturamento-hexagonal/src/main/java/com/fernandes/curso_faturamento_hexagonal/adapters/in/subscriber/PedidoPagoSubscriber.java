package com.fernandes.curso_faturamento_hexagonal.adapters.in.subscriber;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandes.curso_faturamento_hexagonal.adapters.in.subscriber.mapper.PedidoMapper;
import com.fernandes.curso_faturamento_hexagonal.adapters.in.subscriber.representation.DetalhePedidoRepresentation;
import com.fernandes.curso_faturamento_hexagonal.application.ports.in.FaturarPedidoInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoPagoSubscriber {

    private final ObjectMapper objectMapper;
    private final FaturarPedidoInputPort faturarPedidoInputPort;
    private final PedidoMapper mapper;

    @KafkaListener(groupId = "icompras-faturamento",
            topics = "${icompras.config.kafka.topics.pedidos-pagos}")
    public void listener(String json){

        try {
            log.info("Recebendo pedido para faturamento: {}", json);
            var representation = objectMapper.readValue(json, DetalhePedidoRepresentation.class);
            var pedido = mapper.toPedido(representation);
            faturarPedidoInputPort.faturarPedido(pedido);
        }catch (Exception e){
            log.error("Erro na consumação do topico de pedidos pagos");
        }
    }

}
