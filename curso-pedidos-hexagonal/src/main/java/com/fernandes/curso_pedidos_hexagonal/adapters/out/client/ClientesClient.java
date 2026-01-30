package com.fernandes.curso_pedidos_hexagonal.adapters.out.client;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.client.representation.ClienteRepresentation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cliente", url = "${icompras.pedidos.clients.clientes.url}")
public interface ClientesClient {

    @GetMapping
    ResponseEntity<ClienteRepresentation> cadastrarCliente(@RequestParam("codigo") Long codigo);
}
