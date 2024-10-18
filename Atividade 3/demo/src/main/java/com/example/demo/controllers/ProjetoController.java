package com.example.demo.controllers;

import com.example.demo.dtos.ProjetoDTO;
import com.example.demo.dtos.DadosProjetoDTO;
import com.example.demo.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<ProjetoDTO> adicionarProjeto(@RequestBody ProjetoDTO projetoDTO) {
        ProjetoDTO novoProjeto = projetoService.adicionarProjeto(projetoDTO);
        return ResponseEntity.ok(novoProjeto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosProjetoDTO> buscarProjetoPorId(@PathVariable Long id) {
        DadosProjetoDTO projeto = projetoService.buscarProjetoPorId(id);
        return ResponseEntity.ok(projeto);
    }

    @PostMapping("/{idProjeto}/vincular/{idFuncionario}")
    public ResponseEntity<Void> vincularFuncionario(@PathVariable Long idProjeto, @PathVariable Long idFuncionario) {
        projetoService.vincularFuncionario(idProjeto, idFuncionario);
        return ResponseEntity.ok().build();
    }
}
