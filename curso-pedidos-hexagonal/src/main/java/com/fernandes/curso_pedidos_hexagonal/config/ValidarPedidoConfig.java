package com.fernandes.curso_pedidos_hexagonal.config;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.ValidarPedidoAdapter;
import com.fernandes.curso_pedidos_hexagonal.application.core.usecase.ValidarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidarPedidoConfig {

    @Bean
    public ValidarPedidoUseCase validarPedidoUseCase(
            ValidarPedidoAdapter validarPedidoAdapter
    ){
        return new ValidarPedidoUseCase(validarPedidoAdapter,validarPedidoAdapter);
    }
}
