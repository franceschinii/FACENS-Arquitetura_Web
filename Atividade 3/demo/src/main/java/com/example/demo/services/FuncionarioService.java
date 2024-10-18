package com.example.demo.services;

import com.example.demo.dtos.FuncionarioDTO;
import com.example.demo.dtos.DadosProjetoDTO;
import com.example.demo.models.Funcionario;
import com.example.demo.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioDTO adicionarFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioDTO.getNome());
        Funcionario novoFuncionario = funcionarioRepository.save(funcionario);
        return new FuncionarioDTO(novoFuncionario.getId(), novoFuncionario.getNome(), funcionarioDTO.getSetorId());
    }

    public List<DadosProjetoDTO> buscarProjetosPorFuncionario(Long idFuncionario) {
        return funcionarioRepository.buscarProjetosDoFuncionario(idFuncionario)
                .stream()
                .map(projeto -> new DadosProjetoDTO())
                .collect(Collectors.toList());
    }
}
