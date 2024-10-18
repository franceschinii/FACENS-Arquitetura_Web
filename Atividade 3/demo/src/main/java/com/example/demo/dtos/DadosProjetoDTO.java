package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosProjetoDTO {
    private ProjetoDTO projeto;
    private List<FuncionarioDTO> funcionarios;
}
