package com.cotefacil.med.voll.api.model;

import com.cotefacil.med.voll.api.dto.DadosMedico;
import com.cotefacil.med.voll.api.dto.EnderecoDTO;
import com.cotefacil.med.voll.api.endereco.Endereco;
import com.cotefacil.med.voll.api.enums.Especialidade;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Medico")
@Table(name = "medicos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    private Boolean ativo = true;

    public void excluir() {
        this.ativo = false;
    }
}
