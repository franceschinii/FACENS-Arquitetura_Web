package com.example.demo.repositories;

import com.example.demo.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    @Query("SELECT p FROM Projeto p JOIN FETCH p.funcionarios WHERE p.id = :id")
    Projeto buscarProjetoComFuncionarios(@Param("id") Long id);

    @Query("SELECT p FROM Projeto p WHERE p.dataInicio BETWEEN :inicio AND :fim")
    List<Projeto> buscarProjetosPorPeriodo(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);
}
