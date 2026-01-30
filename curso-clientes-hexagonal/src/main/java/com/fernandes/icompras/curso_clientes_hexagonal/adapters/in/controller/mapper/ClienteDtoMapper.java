package com.fernandes.icompras.curso_clientes_hexagonal.adapters.in.controller.mapper;

import com.fernandes.icompras.curso_clientes_hexagonal.adapters.in.controller.dto.request.ClienteRequestDto;
import com.fernandes.icompras.curso_clientes_hexagonal.adapters.in.controller.dto.response.ClienteResponseDto;
import com.fernandes.icompras.curso_clientes_hexagonal.application.core.domain.Cliente;

public interface ClienteDtoMapper {

    Cliente toCliente(ClienteRequestDto requestDto);

    ClienteResponseDto toClienteResponseDto(Cliente cliente);
}
