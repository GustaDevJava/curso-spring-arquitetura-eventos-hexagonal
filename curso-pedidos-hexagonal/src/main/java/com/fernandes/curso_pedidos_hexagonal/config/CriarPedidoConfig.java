package com.fernandes.curso_pedidos_hexagonal.config;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.AtualizarPedidoAdapter;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.CriarPedidoAdapter;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.SalvarItensPedidoAdapter;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.SolicitarPagamentoAdapter;
import com.fernandes.curso_pedidos_hexagonal.application.core.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CriarPedidoConfig {

    @Bean
    public CriarPedidoUseCase criarPedidoUseCase(
            CriarPedidoAdapter criarPedidoAdapter,
            SalvarItensPedidoAdapter salvarItensPedidoAdapter,
            ValidarPedidoUseCase validarPedidoUseCase,
            SolicitarPagamentoAdapter solicitarPagamentoAdapter,
            AtualizarPedidoAdapter atualizarPedidoAdapter
    ){
        return new CriarPedidoUseCase(criarPedidoAdapter,salvarItensPedidoAdapter, validarPedidoUseCase, solicitarPagamentoAdapter, atualizarPedidoAdapter);
    }
}
