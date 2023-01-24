package com.cotefacil.med.voll.api.dto;

import com.cotefacil.med.voll.api.enums.Especialidade;
import com.cotefacil.med.voll.api.model.Medico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MedicoAtualizaDTO {

    private Long id;
    private String nome;
    private String telefone;
    private EnderecoDTO endereco;

    public MedicoAtualizaDTO(Medico entity) {
        id = entity.getId();
        nome = entity.getNome();
        telefone = entity.getTelefone();
        entity.getEndereco();
    }
}
