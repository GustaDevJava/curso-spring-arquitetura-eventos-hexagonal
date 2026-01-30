package com.fernandes.curso_pedidos_hexagonal.adapters.out.client;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.client.model.PedidoClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class ServicoBancarioClient {

    public String solicitarPagamento(PedidoClient pedidoClient){
      log.info("Solicitando pagamento para o pedido de código: {}", pedidoClient.getCodigo());
        return UUID.randomUUID().toString();
    }
}
