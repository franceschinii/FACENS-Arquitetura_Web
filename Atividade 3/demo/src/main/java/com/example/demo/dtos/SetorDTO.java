package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetorDTO {
    private Long id;
    private String nome;
    private List<FuncionarioDTO> funcionarios;
}
