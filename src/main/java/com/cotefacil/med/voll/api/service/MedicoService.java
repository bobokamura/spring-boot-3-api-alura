package com.cotefacil.med.voll.api.service;

import com.cotefacil.med.voll.api.dto.DadosMedicoDetalhamento;
import com.cotefacil.med.voll.api.dto.MedicoAtualizaDTO;
import com.cotefacil.med.voll.api.dto.MedicoDTO;
import com.cotefacil.med.voll.api.dto.MedicoEspecialidade;
import com.cotefacil.med.voll.api.endereco.Endereco;
import com.cotefacil.med.voll.api.model.Medico;
import com.cotefacil.med.voll.api.repository.MedicoRepository;
import com.cotefacil.med.voll.api.service.exception.ResourseNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MedicoRepository repository;

    public MedicoService() {
    }

//    @Transactional
//    public MedicoDTO cadastrar(MedicoDTO dto) {
//        Medico entity = modelMapper.map(dto, Medico.class);
//        repository.save(entity);
//        return modelMapper.map(entity, MedicoDTO.class);
//    }

    @Transactional
    public MedicoDTO cadastrar(MedicoDTO dto) {
        Medico entity = new Medico();
        copyDTOtoEntity(dto, entity);
        repository.save(entity);
        return modelMapper.map(entity, MedicoDTO.class);
    }

    @Transactional
    public MedicoAtualizaDTO atualizar(MedicoAtualizaDTO dto, Long id) {
        try {
            Medico entity = repository.getReferenceById(id);
            copyDTOtoEntityUpdate(dto, entity);
            return new MedicoAtualizaDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourseNotFoundException(id);
        }
    }

    @Transactional(readOnly = true)
    public DadosMedicoDetalhamento findById(Long id) {
        Optional<Medico> obj = repository.findById(id);
        var entity = obj.orElseThrow(() -> new ResourseNotFoundException(id));
        return new DadosMedicoDetalhamento(entity);
    }

    @Transactional(readOnly = true)
    public Page<MedicoEspecialidade> findAll(String nome, Pageable pageable) {
        var page = repository.findAllByName(nome, pageable);
        return page.map(MedicoEspecialidade::new);
    }

    @Transactional
    public void delete(Long id) {
        try{
            Medico entity = repository.getReferenceById(id);
            entity.excluir();
        } catch (EmptyResultDataAccessException e) {
            throw new ResourseNotFoundException(id);
        } catch(EntityNotFoundException e) {
            throw new ResourseNotFoundException(id);
        }
    }
    private static void copyDTOtoEntity(MedicoDTO dto, Medico entity) {
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setCrm(dto.getCrm());
        entity.setEspecialidade(dto.getEspecialidade());

        Endereco endereco = new Endereco();
        endereco.setLogradouro(dto.getEndereco().getLogradouro());
        endereco.setBairro(dto.getEndereco().getBairro());
        endereco.setCep(dto.getEndereco().getCep());
        endereco.setCidade(dto.getEndereco().getCidade());
        endereco.setUf(dto.getEndereco().getUf());
        endereco.setNumero(dto.getEndereco().getNumero());
        endereco.setComplemento(dto.getEndereco().getComplemento());

        entity.setEndereco(endereco);
    }

    private static void copyDTOtoEntityUpdate(MedicoAtualizaDTO dto, Medico entity) {
        if (dto.getNome() != null) {
            entity.setNome(dto.getNome());
        }
        if (dto.getTelefone() != null) {
            entity.setTelefone(dto.getTelefone());
        }

        Endereco endereco = new Endereco();
        if (dto.getEndereco().getLogradouro() != null) {
            endereco.setLogradouro(dto.getEndereco().getLogradouro());
        }
        if (dto.getEndereco().getBairro() != null) {
            endereco.setBairro(dto.getEndereco().getBairro());
        }
        if (dto.getEndereco().getCep() != null) {
            endereco.setCep(dto.getEndereco().getCep());
        }
        if (dto.getEndereco().getCidade() != null) {
            endereco.setCidade(dto.getEndereco().getCidade());
        }
        if (dto.getEndereco().getUf() != null) {
            endereco.setUf(dto.getEndereco().getUf());
        }
        if (dto.getEndereco().getNumero() != null) {
            endereco.setNumero(dto.getEndereco().getNumero());
//            entity.getEndereco().setNumero(dto.getEndereco().getNumero());
        }
        if (dto.getEndereco().getComplemento() != null) {
            endereco.setComplemento(dto.getEndereco().getComplemento());
//            entity.getEndereco().setComplemento(dto.getEndereco().getComplemento());
        }
        entity.setEndereco(endereco);
    }
}
