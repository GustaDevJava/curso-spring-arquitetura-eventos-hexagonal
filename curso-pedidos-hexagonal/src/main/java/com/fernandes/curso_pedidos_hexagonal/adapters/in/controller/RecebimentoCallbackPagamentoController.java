package com.fernandes.curso_pedidos_hexagonal.adapters.in.controller;

import com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.dto.RecebimentoCallbackPagamentoDTO;
import com.fernandes.curso_pedidos_hexagonal.application.ports.in.AtualizarStatusPagamentoInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos/callback-pagamentos")
@RequiredArgsConstructor
public class RecebimentoCallbackPagamentoController {

    private final AtualizarStatusPagamentoInputPort atualizarStatusPagamentoInputPort;

    @PostMapping
    public ResponseEntity<Object> atualizarStatusPagamento(
            @RequestBody RecebimentoCallbackPagamentoDTO body,
            @RequestHeader(required = true, name = "apiKey") String apiKey
            ){
        atualizarStatusPagamentoInputPort.atualizarStatusPagamento(
                body.codigo(),
                body.chavePagamento(),
                body.status(),
                body.observacoes()
        );

        return ResponseEntity.ok().build();
    }
}
