package com.fernandes.curso_logistica_hexagonal.config;

import com.fernandes.curso_logistica_hexagonal.adapters.out.EnvioPedidoAdapter;
import com.fernandes.curso_logistica_hexagonal.application.core.usecase.EnvioPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvioPedidoConfig {

    @Bean
    public EnvioPedidoUseCase envioPedidoUseCase(
            EnvioPedidoAdapter envioPedidoAdapter
    ){
        return new EnvioPedidoUseCase(envioPedidoAdapter);
    }
}
