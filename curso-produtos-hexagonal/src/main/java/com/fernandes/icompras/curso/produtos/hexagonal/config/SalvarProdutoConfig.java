package com.fernandes.icompras.curso.produtos.hexagonal.config;

import com.fernandes.icompras.curso.produtos.hexagonal.adapters.out.SalvarProdutoAdapter;
import com.fernandes.icompras.curso.produtos.hexagonal.application.core.usecase.SalvarProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalvarProdutoConfig {

    @Bean
    public SalvarProdutoUseCase salvarProdutoUseCase(
            SalvarProdutoAdapter salvarProdutoAdapter
    ){
        return new SalvarProdutoUseCase(salvarProdutoAdapter);
    }
}
