package com.cotefacil.med.voll.api.dto;

import com.cotefacil.med.voll.api.enums.Especialidade;
import com.cotefacil.med.voll.api.model.Medico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MedicoEspecialidade {

    private Long id;
    private String nome;
    private String email;
    private String crm;
    private Especialidade especialidade;

    public MedicoEspecialidade(Medico entity) {
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
        crm = entity.getCrm();
        especialidade = entity.getEspecialidade();
    }
}
