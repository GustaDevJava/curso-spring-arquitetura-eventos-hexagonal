package com.fernandes.curso_pedidos_hexagonal.adapters.in.controller;

import com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.dto.AdicaoNovoPagamentoDTO;
import com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.dto.DetalhePedidoDTO;
import com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.dto.NovoPedidoDTO;
import com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.mappers.DetalhePedidoDTOMapper;
import com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.mappers.PedidoMapper;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.publisher.representation.DetalhePedidoRepresentation;
import com.fernandes.curso_pedidos_hexagonal.application.ports.in.AdicionarNovoPagamentoInuptPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.in.CarregarPedidoInputPort;
import com.fernandes.curso_pedidos_hexagonal.application.ports.in.CriarPedidoInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final CriarPedidoInputPort criarPedidoInputPort;

    private final AdicionarNovoPagamentoInuptPort adicionarNovoPagamentoInuptPort;

    private final CarregarPedidoInputPort carregarPedidoInputPort;

    private final PedidoMapper mapper;

    private final DetalhePedidoDTOMapper detalhePedidoDTOMapper;

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

    @GetMapping("{codigo}")
    public ResponseEntity<DetalhePedidoDTO> obterDetalhesPedido(
            @PathVariable("codigo")Long codigo){
        var pedido = carregarPedidoInputPort.carregarDadosCompletosPedido(codigo);
        var detalhePedidoDto = detalhePedidoDTOMapper.toDetalhePedidoDTO(pedido);
        return ResponseEntity.ok(detalhePedidoDto);
    }


}
