package com.fernandes.curso_pedidos_hexagonal.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.fernandes.curso_pedidos_hexagonal.adapters.out.client")
public class ClientsConfig {
}
