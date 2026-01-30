package com.fernandes.icompras.curso_clientes_hexagonal.config;

import com.fernandes.icompras.curso_clientes_hexagonal.adapters.out.CadastrarClienteAdapter;
import com.fernandes.icompras.curso_clientes_hexagonal.application.core.usecase.CadastrarClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastrarClienteConfig {

    @Bean
    public CadastrarClienteUseCase cadastrarClienteUseCase(
            CadastrarClienteAdapter cadastrarClienteAdapter
    ) {
        return new CadastrarClienteUseCase(cadastrarClienteAdapter);
    }
}
