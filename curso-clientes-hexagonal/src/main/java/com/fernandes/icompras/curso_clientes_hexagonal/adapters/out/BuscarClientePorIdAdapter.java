package com.fernandes.icompras.curso_clientes_hexagonal.adapters.out;

import com.fernandes.icompras.curso_clientes_hexagonal.adapters.out.repository.ClienteRepository;
import com.fernandes.icompras.curso_clientes_hexagonal.adapters.out.repository.mapper.ClienteEntityMapper;
import com.fernandes.icompras.curso_clientes_hexagonal.application.core.domain.Cliente;
import com.fernandes.icompras.curso_clientes_hexagonal.application.ports.out.BuscarClientePorIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BuscarClientePorIdAdapter implements BuscarClientePorIdOutputPort {

    private final ClienteRepository repository;
    private final ClienteEntityMapper mapper;

    @Override
    public Optional<Cliente> buscarPorCodigo(Long codigo) {
        var clienteEntity = repository.findById(codigo);
        return clienteEntity.map(mapper::toCliente);
    }
}
