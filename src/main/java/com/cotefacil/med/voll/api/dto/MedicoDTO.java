package com.cotefacil.med.voll.api.dto;

import com.cotefacil.med.voll.api.endereco.Endereco;
import com.cotefacil.med.voll.api.enums.Especialidade;
import com.cotefacil.med.voll.api.model.Medico;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicoDTO {


    private Long id;
    @NotBlank(message = "Campo nome é obrigatório")
    private String nome;
    @NotBlank(message = "Campo email é obrigatório")
    @Email
    private String email;
    @NotBlank
    private String telefone;
    @NotBlank(message = "Campo crm é obrigatório e deve ter de 4 a 6 números")
//    @Pattern(regexp = "\\d{4,6}")
    @Size(min = 4, max = 6, message = "O CRM deve ser de 4 até 6 digitos")
    private String crm;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Especialidade especialidade;

    private Boolean ativo = true;

    @Embedded
    @NotNull
    @Valid
    private EnderecoDTO endereco;
}
