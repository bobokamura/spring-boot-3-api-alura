package com.cotefacil.med.voll.api.dto;

import com.cotefacil.med.voll.api.endereco.Endereco;
import com.cotefacil.med.voll.api.enums.Especialidade;
import com.cotefacil.med.voll.api.model.Medico;

public record DadosMedicoDetalhamento(
        Long id,
        String nome,
        String email,
        String crm,
        String telefone,
        Boolean ativo,

        Especialidade especialidade,
        Endereco endereco) {

    public DadosMedicoDetalhamento(Medico entity) {
        this(entity.getId(), entity.getNome(), entity.getEmail(), entity.getCrm(), entity.getTelefone(), entity.getAtivo(), entity.getEspecialidade(), entity.getEndereco()
        );
    }
}
