package com.fernandes.icompras.curso_clientes_hexagonal.adapters.in.controller.mapper.impl;

import com.fernandes.icompras.curso_clientes_hexagonal.adapters.in.controller.dto.request.ClienteRequestDto;
import com.fernandes.icompras.curso_clientes_hexagonal.adapters.in.controller.dto.response.ClienteResponseDto;
import com.fernandes.icompras.curso_clientes_hexagonal.adapters.in.controller.mapper.ClienteDtoMapper;
import com.fernandes.icompras.curso_clientes_hexagonal.application.core.domain.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteDtoMapperImpl implements ClienteDtoMapper {

    @Override
    public Cliente toCliente(ClienteRequestDto requestDto) {
        Cliente cliente = new Cliente();
        cliente.setNome(requestDto.getNome());
        cliente.setCpf(requestDto.getCpf());
        cliente.setLogradouro(requestDto.getLogradouro());
        cliente.setNumero(requestDto.getNumero());
        cliente.setBairro(requestDto.getBairro());
        cliente.setEmail(requestDto.getEmail());
        cliente.setTelefone(requestDto.getTelefone());
        return cliente;
    }

    @Override
    public ClienteResponseDto toClienteResponseDto(Cliente cliente) {
        ClienteResponseDto clienteResponseDto = new ClienteResponseDto();
        clienteResponseDto.setCodigo(cliente.getCodigo());
        clienteResponseDto.setNome(cliente.getNome());
        clienteResponseDto.setCpf(cliente.getCpf());
        clienteResponseDto.setLogradouro(cliente.getLogradouro());
        clienteResponseDto.setNumero(cliente.getNumero());
        clienteResponseDto.setBairro(cliente.getBairro());
        clienteResponseDto.setEmail(cliente.getEmail());
        clienteResponseDto.setTelefone(cliente.getTelefone());
        return clienteResponseDto;
    }
}
