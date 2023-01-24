package com.cotefacil.med.voll.api.dto;

import jakarta.validation.constraints.NotBlank;


public record DadosEndereco(

        @NotBlank(message = "Campo logradouro é obrigatório")
        String logradouro,
        @NotBlank(message = "Campo bairro é obrigatório")
        String bairro,
        @NotBlank(message = "Campo cep é obrigatório")
        String cep,
        @NotBlank(message = "Campo cidade é obrigatório")
        String cidade,
        @NotBlank(message = "Campo UF é obrigatório")
        String uf,
        String complemento,
        String numero){
}
