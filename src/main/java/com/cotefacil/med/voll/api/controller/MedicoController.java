package com.cotefacil.med.voll.api.controller;

import com.cotefacil.med.voll.api.dto.DadosMedicoDetalhamento;
import com.cotefacil.med.voll.api.dto.MedicoAtualizaDTO;
import com.cotefacil.med.voll.api.dto.MedicoDTO;
import com.cotefacil.med.voll.api.dto.MedicoEspecialidade;
import com.cotefacil.med.voll.api.repository.MedicoRepository;
import com.cotefacil.med.voll.api.service.MedicoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MedicoService service;

    @Autowired
    public MedicoRepository repository;

    @PostMapping
    public ResponseEntity<MedicoDTO> cadastrar(@RequestBody @Valid MedicoDTO dto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(service.cadastrar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosMedicoDetalhamento> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoAtualizaDTO> atualizar(@RequestBody @Valid MedicoAtualizaDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok().body(service.atualizar(dto, id));
    }

    @GetMapping
    public ResponseEntity<Page<MedicoEspecialidade>> findAll(@RequestParam(value = "nome", defaultValue = "") String nome,
                                                             @PageableDefault(size = 10, direction = Sort.Direction.ASC, sort = "nome") Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(nome, pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
