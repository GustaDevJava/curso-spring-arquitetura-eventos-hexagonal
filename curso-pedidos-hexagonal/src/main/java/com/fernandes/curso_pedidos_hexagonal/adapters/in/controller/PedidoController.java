package com.fernandes.curso_pedidos_hexagonal.adapters.in.controller;

import com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.dto.AdicaoNovoPagamentoDTO;
import com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.dto.NovoPedidoDTO;
import com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.mappers.PedidoMapper;
import com.fernandes.curso_pedidos_hexagonal.application.ports.in.AdicionarNovoPagamentoInuptPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.in.CriarPedidoInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final CriarPedidoInputPort criarPedidoInputPort;

    private final AdicionarNovoPagamentoInuptPort adicionarNovoPagamentoInuptPort;

    private final PedidoMapper mapper;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody NovoPedidoDTO novoPedidoDTO){
        var pedido = mapper.toPedido(novoPedidoDTO);
        var novoPedido = criarPedidoInputPort.criarPedido(pedido);
        return ResponseEntity.ok(novoPedido.getCodigo());
    }

    @PostMapping("/pagamentos")
    public ResponseEntity<Object> adicionarNovoPagamento(@RequestBody AdicaoNovoPagamentoDTO dto){

        adicionarNovoPagamentoInuptPort.adicionarNovoPagamento(
                dto.codigoPedido(),
                dto.dadosCartao(),
                dto.tipoPagamento()
        );
        return ResponseEntity.noContent().build();

    }


}
