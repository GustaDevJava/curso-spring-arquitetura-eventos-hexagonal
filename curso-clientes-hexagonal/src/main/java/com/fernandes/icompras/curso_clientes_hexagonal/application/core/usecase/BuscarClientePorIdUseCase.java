package com.fernandes.icompras.curso_clientes_hexagonal.application.core.usecase;

import com.fernandes.icompras.curso_clientes_hexagonal.application.core.domain.Cliente;
import com.fernandes.icompras.curso_clientes_hexagonal.application.core.exception.ClienteNaoEncontradoException;
import com.fernandes.icompras.curso_clientes_hexagonal.application.ports.in.BuscarClientePorIdInputPort;
import com.fernandes.icompras.curso_clientes_hexagonal.application.ports.out.BuscarClientePorIdOutputPort;

public class BuscarClientePorIdUseCase implements BuscarClientePorIdInputPort {

    private final BuscarClientePorIdOutputPort buscarClientePorIdOutputPort;

    public BuscarClientePorIdUseCase(BuscarClientePorIdOutputPort buscarClientePorIdOutputPort){
        this.buscarClientePorIdOutputPort = buscarClientePorIdOutputPort;
    }

    @Override
    public Cliente buscarPorCodigo(Long codigo){
        return buscarClientePorIdOutputPort.buscarPorCodigo(codigo).orElseThrow(() -> new ClienteNaoEncontradoException("Erro ao buscar cliente"));
    }
}
