package com.fernandes.curso_faturamento_hexagonal.config;

import com.fernandes.curso_faturamento_hexagonal.adapters.out.BuscarUrlAdapter;
import com.fernandes.curso_faturamento_hexagonal.application.core.usecase.BuscarUrlUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarUrlConfig {

    @Bean
    public BuscarUrlUseCase buscarUrlUseCase(
            BuscarUrlAdapter buscarUrlAdapter
    ){
        return new BuscarUrlUseCase(buscarUrlAdapter);
    }
}
