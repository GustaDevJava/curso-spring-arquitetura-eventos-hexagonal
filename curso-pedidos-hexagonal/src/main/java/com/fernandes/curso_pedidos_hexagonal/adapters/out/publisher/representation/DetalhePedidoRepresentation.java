package com.fernandes.curso_pedidos_hexagonal.adapters.out.publisher.representation;

import com.fernandes.curso_pedidos_hexagonal.application.core.domain.enums.StatusPedido;

import java.math.BigDecimal;
import java.util.List;

public record DetalhePedidoRepresentation(
        Long codigo,
        Long codigoCliente,
        String nome,
        String cpf,
        String logradouro,
        String numero,
        String bairro,
        String email,
        String telefone,
        String dataPedido,
        BigDecimal total,
        StatusPedido status,
        List<DetalheItemPedidoRepresentation> itens
) {
}
