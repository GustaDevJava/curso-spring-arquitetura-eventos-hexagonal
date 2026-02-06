package com.fernandes.curso_pedidos_hexagonal.config;

import com.fernandes.curso_pedidos_hexagonal.adapters.out.BuscarItensPedidoAdapter;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.BuscarPedidoAdapter;
import com.fernandes.curso_pedidos_hexagonal.adapters.out.ValidarPedidoAdapter;
import com.fernandes.curso_pedidos_hexagonal.application.core.usecase.CarregarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarregarPedidoConfig {

    @Bean
    public CarregarPedidoUseCase carregarPedidoUseCase(
            BuscarPedidoAdapter buscarPedidoAdapter,
            ValidarPedidoAdapter validarPedidoAdapter,
            BuscarItensPedidoAdapter buscarItensPedidoAdapter
    ){
        return new CarregarPedidoUseCase(buscarPedidoAdapter, validarPedidoAdapter, buscarItensPedidoAdapter, validarPedidoAdapter);
    }
}
