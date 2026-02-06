package com.fernandes.curso_pedidos_hexagonal.config;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.AtualizarPedidoAdapter;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.BuscarPedidoAdapter;
import com.fernandes.curso_pedidos_hexagonal.application.core.usecase.AtualizacaoStatusPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizacaoStatusPedidoConfig {

    @Bean
    public AtualizacaoStatusPedidoUseCase atualizacaoStatusPedidoUseCase(
            BuscarPedidoAdapter buscarPedidoAdapter,
            AtualizarPedidoAdapter atualizarPedidoAdapter
    ){
        return new AtualizacaoStatusPedidoUseCase(buscarPedidoAdapter, atualizarPedidoAdapter);
    }
}
