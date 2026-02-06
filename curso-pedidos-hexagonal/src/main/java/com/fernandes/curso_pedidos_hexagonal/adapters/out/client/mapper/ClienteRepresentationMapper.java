package com.fernandes.curso_pedidos_hexagonal.adapters.out.client.mapper;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.client.representation.ClienteRepresentation;
import com.fernandes.curso_pedidos_hexagonal.application.core.domain.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteRepresentationMapper {

    Cliente toCliente(ClienteRepresentation clienteRepresentation);
}
