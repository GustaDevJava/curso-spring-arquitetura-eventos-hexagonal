package com.fernandes.curso_pedidos_hexagonal.config;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.AtualizarPedidoAdapter;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.BuscarPedidoAdapter;
import com.fernandes.curso_pedidos_hexagonal.application.core.usecase.AtualizarStatusPagamentoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarStatusPagamentoConfig {

    @Bean
    public AtualizarStatusPagamentoUseCase atualizarStatusPagamentoUseCase(
            BuscarPedidoAdapter buscarPedidoAdapter,
            AtualizarPedidoAdapter atualizarPedidoAdapter
    ){
        return new AtualizarStatusPagamentoUseCase(buscarPedidoAdapter, atualizarPedidoAdapter);
    }

}
