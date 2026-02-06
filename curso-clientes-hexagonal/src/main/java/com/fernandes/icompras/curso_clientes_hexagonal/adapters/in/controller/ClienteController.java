package com.fernandes.icompras.curso_clientes_hexagonal.adapters.in.controller;

import com.fernandes.icompras.curso_clientes_hexagonal.adapters.in.controller.dto.request.ClienteRequestDto;
import com.fernandes.icompras.curso_clientes_hexagonal.adapters.in.controller.dto.response.ClienteResponseDto;
import com.fernandes.icompras.curso_clientes_hexagonal.adapters.in.controller.mapper.ClienteDtoMapper;
import com.fernandes.icompras.curso_clientes_hexagonal.application.ports.in.BuscarClientePorIdInputPort;
import com.fernandes.icompras.curso_clientes_hexagonal.application.ports.in.CadastrarClienteInputPort;
import com.fernandes.icompras.curso_clientes_hexagonal.application.ports.in.ExclusaoLogicaInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final CadastrarClienteInputPort cadastrarClienteInputPort;
    private final BuscarClientePorIdInputPort buscarClientePorIdInputPort;
    private final ExclusaoLogicaInputPort exclusaoLogicaInputPort;
    private final ClienteDtoMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteResponseDto> cadastrarCliente(@RequestBody ClienteRequestDto requestDto){
        var cliente = mapper.toCliente(requestDto);
        cliente = cadastrarClienteInputPort.cadastrarCliente(cliente);
        return ResponseEntity.ok().body(mapper.toClienteResponseDto(cliente));
    }

    @GetMapping
    public ResponseEntity<ClienteResponseDto> cadastrarCliente(@RequestParam("codigo") Long codigo){
        var cliente = buscarClientePorIdInputPort.buscarPorCodigo(codigo);
        return ResponseEntity.ok().body(mapper.toClienteResponseDto(cliente));
    }

    @DeleteMapping
    public ResponseEntity<Void> exlusaoLogica(@RequestParam("codigo") Long codigo){
        exclusaoLogicaInputPort.excluir(codigo);
        return ResponseEntity.noContent().build();
    }
}
