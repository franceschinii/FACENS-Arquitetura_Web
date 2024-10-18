package com.example.demo.controllers;

import com.example.demo.dtos.SetorDTO;
import com.example.demo.dtos.DadosSetorDTO;
import com.example.demo.services.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorService setorService;

    @PostMapping
    public ResponseEntity<SetorDTO> adicionarSetor(@RequestBody SetorDTO setorDTO) {
        SetorDTO novoSetor = setorService.adicionarSetor(setorDTO);
        return ResponseEntity.ok(novoSetor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosSetorDTO> buscarSetorPorId(@PathVariable Long id) {
        DadosSetorDTO setor = setorService.buscarSetorPorId(id);
        return ResponseEntity.ok(setor);
    }
}
