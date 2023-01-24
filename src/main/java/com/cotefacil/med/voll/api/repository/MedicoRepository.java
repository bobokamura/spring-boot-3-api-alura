package com.cotefacil.med.voll.api.repository;

import com.cotefacil.med.voll.api.model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    @Query(value = "SELECT m "
            + "FROM Medico m "
            + "WHERE (:nome IS NULL OR UPPER(m.nome) LIKE UPPER(CONCAT(:nome, '%'))) "
            + "AND m.ativo = 1")
    Page<Medico> findAllByName(@Param("nome") String nome, Pageable pageable);

}
