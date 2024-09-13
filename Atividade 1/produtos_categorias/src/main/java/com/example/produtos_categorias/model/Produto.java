package com.example.produtos_categorias.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_produto;

    @Column(name = "prod_nome", nullable = false)
    private String prod_nome;

    @Column(name = "prod_qtd", nullable = false)
    private Integer prod_qtd;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    // Getters e Setters
    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    public String getProd_nome() {
        return prod_nome;
    }

    public void setProd_nome(String prod_nome) {
        this.prod_nome = prod_nome;
    }

    public Integer getProd_qtd() {
        return prod_qtd;
    }

    public void setProd_qtd(Integer prod_qtd) {
        this.prod_qtd = prod_qtd;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
