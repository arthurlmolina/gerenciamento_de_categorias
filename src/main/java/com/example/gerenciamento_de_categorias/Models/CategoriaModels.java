package com.example.gerenciamento_de_categorias.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_categoria")
public class CategoriaModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nomes")
    private String nome;
    @Column(name = "descricoes")
    private String descricao;

    public CategoriaModels() {
    }

    public CategoriaModels(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
