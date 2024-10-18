package com.example.demo.repositories;

import com.example.demo.models.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SetorRepository extends JpaRepository<Setor, Long> {
    @Query("SELECT s FROM Setor s JOIN FETCH s.funcionarios")
    List<Setor> listarSetoresComFuncionarios();
}
