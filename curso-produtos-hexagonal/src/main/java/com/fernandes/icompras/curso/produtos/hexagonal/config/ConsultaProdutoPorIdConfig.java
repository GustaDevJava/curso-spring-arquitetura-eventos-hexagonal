package com.fernandes.icompras.curso.produtos.hexagonal.config;

import com.fernandes.icompras.curso.produtos.hexagonal.adapters.out.ConsultaProdutoPorIdAdapter;
import com.fernandes.icompras.curso.produtos.hexagonal.application.core.usecase.ConsultaProdutoPorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsultaProdutoPorIdConfig {

    @Bean
    public ConsultaProdutoPorIdUseCase consultaProdutoPorIdUseCase(
            ConsultaProdutoPorIdAdapter consultaProdutoPorIdAdapter
    ){
        return new ConsultaProdutoPorIdUseCase(consultaProdutoPorIdAdapter);
    }
}
