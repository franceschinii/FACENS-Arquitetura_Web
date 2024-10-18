package com.example.demo.repositories;

import com.example.demo.models.Funcionario;
import com.example.demo.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    @Query("SELECT f.projetos FROM Funcionario f WHERE f.id = :id")
    List<Projeto> buscarProjetosDoFuncionario(@Param("id") Long id);
}
