package com.fernandes.curso_pedidos_hexagonal.adapters.in.controller.dto;
/*
Body:
        4 {
        5 "codigo": "number",
        6 "chavePagamento": "string",
        7 "status": "boolean",
        8 "observacoes": "string"
        9 }
        10
        11 Headers:
        12 {
        13 "apiKey": "string"
        14 }
*/

public record RecebimentoCallbackPagamentoDTO(Long codigo,
                                              String chavePagamento,
                                              Boolean status,
                                              String observacoes) {
}
