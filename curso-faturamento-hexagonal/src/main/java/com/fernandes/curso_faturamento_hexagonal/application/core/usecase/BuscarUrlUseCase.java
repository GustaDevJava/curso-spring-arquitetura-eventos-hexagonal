package com.fernandes.curso_faturamento_hexagonal.application.core.usecase;

import com.fernandes.curso_faturamento_hexagonal.application.ports.in.BuscarUrlInputPort;
import com.fernandes.curso_faturamento_hexagonal.application.ports.out.BuscarUrlOutputPort;

public class BuscarUrlUseCase implements BuscarUrlInputPort {

    private final BuscarUrlOutputPort buscarUrlOutputPort;

    public BuscarUrlUseCase(BuscarUrlOutputPort buscarUrlOutputPort) {
        this.buscarUrlOutputPort = buscarUrlOutputPort;
    }

    @Override
    public String getUrl(String fileName) {
        return buscarUrlOutputPort.getUrl(fileName);
    }
}
