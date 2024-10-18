package com.example.demo.controllers;

import com.example.demo.dtos.FuncionarioDTO;
import com.example.demo.dtos.DadosProjetoDTO;
import com.example.demo.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<FuncionarioDTO> adicionarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO novoFuncionario = funcionarioService.adicionarFuncionario(funcionarioDTO);
        return ResponseEntity.ok(novoFuncionario);
    }

    @GetMapping("/{id}/projetos")
    public ResponseEntity<List<DadosProjetoDTO>> buscarProjetosPorFuncionario(@PathVariable Long id) {
        List<DadosProjetoDTO> projetos = funcionarioService.buscarProjetosPorFuncionario(id);
        return ResponseEntity.ok(projetos);
    }
}