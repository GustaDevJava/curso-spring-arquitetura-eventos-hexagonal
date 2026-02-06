package com.fernandes.curso_faturamento_hexagonal.adapters.out.jasper.representation;

import java.math.BigDecimal;
import java.util.List;

public record PedidoNotaRepresentation(
        String nome,
        String cpf,
        String logradouro,
        String numero,
        String bairro,
        String email,
        String telefone,
        String dataPedido,
        BigDecimal total,
        List<ItemNotaRepresentation> itens
) {
}
