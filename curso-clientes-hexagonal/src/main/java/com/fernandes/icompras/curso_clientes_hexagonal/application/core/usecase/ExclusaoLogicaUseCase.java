package com.fernandes.icompras.curso_clientes_hexagonal.application.core.usecase;

import com.fernandes.icompras.curso_clientes_hexagonal.application.core.exception.ClienteNaoEncontradoException;
import com.fernandes.icompras.curso_clientes_hexagonal.application.ports.in.ExclusaoLogicaInputPort;
import com.fernandes.icompras.curso_clientes_hexagonal.application.ports.out.AtualizarClienteOutputPort;
import com.fernandes.icompras.curso_clientes_hexagonal.application.ports.out.BuscarClientePorIdOutputPort;

public class ExclusaoLogicaUseCase implements ExclusaoLogicaInputPort {

    private final AtualizarClienteOutputPort atualizarClienteOutputPort;

    private final BuscarClientePorIdOutputPort buscarClientePorIdOutputPort;

    public ExclusaoLogicaUseCase(AtualizarClienteOutputPort atualizarClienteOutputPort, BuscarClientePorIdOutputPort buscarClientePorIdOutputPort) {
        this.atualizarClienteOutputPort = atualizarClienteOutputPort;
        this.buscarClientePorIdOutputPort = buscarClientePorIdOutputPort;
    }

    @Override
    public void excluir(Long codigo) {
        var clienteOptional = buscarClientePorIdOutputPort.buscarPorCodigo(codigo);

        if (clienteOptional.isEmpty()){
            throw new ClienteNaoEncontradoException("Cliente não encontrado");
        }

        var cliente = clienteOptional.get();

        cliente.setAtivo(false);

        atualizarClienteOutputPort.atualizar(cliente);
    }
}
