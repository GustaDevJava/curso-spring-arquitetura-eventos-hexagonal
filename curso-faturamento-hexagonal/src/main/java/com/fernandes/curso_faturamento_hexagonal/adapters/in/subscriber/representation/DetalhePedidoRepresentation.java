package com.fernandes.curso_faturamento_hexagonal.adapters.in.subscriber.representation;

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
        List<DetalheItemPedidoRepresentation> itens
) {
}
