package com.fernandes.curso_pedidos_hexagonal.config;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.AtualizarPedidoAdapter;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.BuscarPedidoAdapter;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.SolicitarPagamentoAdapter;
import com.fernandes.curso_pedidos_hexagonal.application.core.usecase.AdicionarNovoPagamentoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdicionarNovoPagamentoConfig {

    @Bean
    public AdicionarNovoPagamentoUseCase adicionarNovoPagamentoUseCase(
            BuscarPedidoAdapter buscarPedidoAdapter,
            SolicitarPagamentoAdapter solicitarPagamentoAdapter,
            AtualizarPedidoAdapter atualizarPedidoAdapter
    ){
        return new AdicionarNovoPagamentoUseCase(buscarPedidoAdapter,solicitarPagamentoAdapter, atualizarPedidoAdapter);
    }
}
