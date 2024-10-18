package com.example.demo.services;

import com.example.demo.dtos.SetorDTO;
import com.example.demo.dtos.DadosSetorDTO;
import com.example.demo.models.Setor;
import com.example.demo.repositories.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetorService {

    @Autowired
    private SetorRepository setorRepository;

    public SetorDTO adicionarSetor(SetorDTO setorDTO) {
        Setor setor = new Setor();
        setor.setNome(setorDTO.getNome());
        Setor novoSetor = setorRepository.save(setor);
        return new SetorDTO(novoSetor.getId(), novoSetor.getNome(), null);
    }

    public DadosSetorDTO buscarSetorPorId(Long idSetor) {
        Setor setor = setorRepository.findById(idSetor).orElseThrow(() -> new RuntimeException("Setor não encontrado"));
        return new DadosSetorDTO();
    }
}
