package com.fernandes.curso_pedidos_hexagonal.adapters.out.client;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.client.representation.ProdutoRepresentation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "produtos", url = "${icompras.pedidos.clients.produtos.url}")
public interface ProdutosClient {

    @GetMapping
    ResponseEntity<ProdutoRepresentation> buscarPorCodigo(@RequestParam("codigo")Long codigo);

}
