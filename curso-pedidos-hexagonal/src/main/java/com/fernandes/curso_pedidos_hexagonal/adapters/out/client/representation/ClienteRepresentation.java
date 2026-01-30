package com.fernandes.curso_pedidos_hexagonal.adapters.out.client.representation;

public record ClienteRepresentation(Long codigo,
                                    String nome,
                                    String cpf,
                                    String logradouro,
                                    String numero,
                                    String bairro,
                                    String email,
                                    String telefone) {
}
