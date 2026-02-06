package com.fernandes.icompras.curso.produtos.hexagonal.config;

import com.fernandes.icompras.curso.produtos.hexagonal.adapters.out.AtualizarProdutoAdapter;
import com.fernandes.icompras.curso.produtos.hexagonal.adapters.out.ConsultaProdutoPorIdAdapter;
import com.fernandes.icompras.curso.produtos.hexagonal.application.core.usecase.ExclusaoLogicaProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExclusaoLogicaProdutoConfig {

    @Bean
    public ExclusaoLogicaProdutoUseCase exclusaoLogicaProdutoUseCase(
            ConsultaProdutoPorIdAdapter consultaProdutoPorIdAdapter,
            AtualizarProdutoAdapter atualizarProdutoAdapter
    ){
        return new ExclusaoLogicaProdutoUseCase(consultaProdutoPorIdAdapter, atualizarProdutoAdapter);
    }
}
