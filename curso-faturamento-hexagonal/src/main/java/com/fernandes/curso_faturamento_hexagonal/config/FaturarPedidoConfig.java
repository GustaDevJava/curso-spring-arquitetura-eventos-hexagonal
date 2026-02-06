package com.fernandes.curso_faturamento_hexagonal.config;

import com.fernandes.curso_faturamento_hexagonal.adapters.out.BuscarUrlAdapter;
import com.fernandes.curso_faturamento_hexagonal.adapters.out.FaturarPedidoAdapter;
import com.fernandes.curso_faturamento_hexagonal.adapters.out.GerarNotaFiscalAdapter;
import com.fernandes.curso_faturamento_hexagonal.application.core.usecase.FaturarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FaturarPedidoConfig {

    @Bean
    public FaturarPedidoUseCase faturarPedidoUseCase(
            GerarNotaFiscalAdapter gerarNotaFiscalAdapter,
            FaturarPedidoAdapter faturarPedidoAdapter,
            BuscarUrlAdapter buscarUrlAdapter
    ){
        return new FaturarPedidoUseCase(gerarNotaFiscalAdapter, buscarUrlAdapter, faturarPedidoAdapter);
    }
}
