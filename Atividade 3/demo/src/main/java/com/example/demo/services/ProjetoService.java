package com.example.demo.services;

import com.example.demo.dtos.ProjetoDTO;
import com.example.demo.dtos.DadosProjetoDTO;
import com.example.demo.models.Funcionario;
import com.example.demo.models.Projeto;
import com.example.demo.repositories.ProjetoRepository;
import com.example.demo.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public ProjetoDTO adicionarProjeto(ProjetoDTO projetoDTO) {
        Projeto projeto = new Projeto();
        projeto.setNome(projetoDTO.getNome());
        projeto.setDataInicio(projetoDTO.getDataInicio());
        projeto.setDataFim(projetoDTO.getDataFim());

        Projeto novoProjeto = projetoRepository.save(projeto);
        return new ProjetoDTO(novoProjeto.getId(), novoProjeto.getNome(), novoProjeto.getDataInicio(),
                novoProjeto.getDataFim(), null);
    }

    public DadosProjetoDTO buscarProjetoPorId(Long id) {
        Projeto projeto = projetoRepository.buscarProjetoComFuncionarios(id);
        return new DadosProjetoDTO();
    }

    public void vincularFuncionario(Long idProjeto, Long idFuncionario) {
        Projeto projeto = projetoRepository.findById(idProjeto)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        projeto.getFuncionarios().add(funcionario);
        projetoRepository.save(projeto);
    }
}
