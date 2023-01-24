package com.cotefacil.med.voll.api.dto;

import com.cotefacil.med.voll.api.enums.Especialidade;
import com.cotefacil.med.voll.api.model.Medico;

public record MedicoListagem(String nome, String email, String crm, Especialidade especialidade) {
    public MedicoListagem(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
