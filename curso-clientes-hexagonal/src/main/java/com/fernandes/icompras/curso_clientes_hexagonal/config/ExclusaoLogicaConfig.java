package com.fernandes.icompras.curso_clientes_hexagonal.config;

import com.fernandes.icompras.curso_clientes_hexagonal.adapters.out.AtualizaClienteAdapter;
import com.fernandes.icompras.curso_clientes_hexagonal.adapters.out.BuscarClientePorIdAdapter;
import com.fernandes.icompras.curso_clientes_hexagonal.application.core.usecase.ExclusaoLogicaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExclusaoLogicaConfig {

    @Bean
    public ExclusaoLogicaUseCase exclusaoLogicaUseCase(
            AtualizaClienteAdapter atualizaClienteAdapter,
            BuscarClientePorIdAdapter buscarClientePorIdAdapter
    ){
        return new ExclusaoLogicaUseCase(atualizaClienteAdapter, buscarClientePorIdAdapter);
    }
}
