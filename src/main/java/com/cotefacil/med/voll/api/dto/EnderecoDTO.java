package com.cotefacil.med.voll.api.dto;

import com.cotefacil.med.voll.api.endereco.Endereco;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnderecoDTO {

//    @NotBlank(message = "Campo logradouro é obrigatório")
    private String logradouro;
//    @NotBlank(message = "Campo bairro é obrigatório")
    private String bairro;
//    @NotBlank(message = "Campo cep é obrigatório")
    private String cep;
//    @NotBlank(message = "Campo cidade é obrigatório")
    private String cidade;

    private String complemento;

    private String numero;
//    @NotBlank(message = "Campo UF é obrigatório")
    private String uf;

    public EnderecoDTO(Endereco entity) {
        logradouro = entity.getLogradouro();
        bairro = entity.getBairro();
        cep = entity.getCep();
        cidade = entity.getCidade();
        complemento = entity.getComplemento();
        numero = entity.getNumero();
        uf = entity.getUf();
    }
}
