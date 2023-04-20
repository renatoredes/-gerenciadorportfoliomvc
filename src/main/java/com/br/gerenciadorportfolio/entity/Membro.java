package com.br.gerenciadorportfolio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Membro  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String nome;

    private String atribuicao;


    @ManyToOne
    @JoinColumn(name = "projeto_id", nullable = false)
    @JsonIgnore
    private Projeto projeto;

    public Membro() {
    }

    public Membro(Long id, String nome, String atribuicao, Projeto projeto) {
        this.id = id;
        this.nome = nome;
        this.atribuicao = atribuicao;
        this.projeto = projeto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAtribuicao() {
        return atribuicao;
    }

    public void setAtribuicao(String atribuicao) {
        this.atribuicao = atribuicao;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membro membro = (Membro) o;
        return Objects.equals(id, membro.id) && Objects.equals(nome, membro.nome) && Objects.equals(atribuicao, membro.atribuicao) && Objects.equals(projeto, membro.projeto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, atribuicao, projeto);
    }
}
