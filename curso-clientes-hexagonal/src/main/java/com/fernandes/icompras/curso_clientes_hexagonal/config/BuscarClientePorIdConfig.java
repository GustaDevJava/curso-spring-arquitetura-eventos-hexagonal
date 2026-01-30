package com.fernandes.icompras.curso_clientes_hexagonal.config;

import com.fernandes.icompras.curso_clientes_hexagonal.adapters.out.BuscarClientePorIdAdapter;
import com.fernandes.icompras.curso_clientes_hexagonal.application.core.usecase.BuscarClientePorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarClientePorIdConfig {

    @Bean
    public BuscarClientePorIdUseCase buscarClientePorIdUseCase(
            BuscarClientePorIdAdapter buscarClientePorIdAdapter
    ){
        return new BuscarClientePorIdUseCase(buscarClientePorIdAdapter);
    }
}
