package com.fernandes.icompras.curso_clientes_hexagonal.adapters.in.controller.dto.response;

import lombok.Data;

@Data
public class ClienteResponseDto {

    private Long codigo;
    private String nome;
    private String cpf;
    private String logradouro;
    private String numero;
    private String bairro;
    private String email;
    private String telefone;
}
