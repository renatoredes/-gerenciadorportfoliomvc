package com.br.gerenciadorportfolio.entity;

import com.br.gerenciadorportfolio.entity.enums.ClassificacaoRisco;
import com.br.gerenciadorportfolio.entity.enums.StatusProjeto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Projeto  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "gerente_id")
    private Gerente gerenteResponsavel;
    private String dataInicio;
    private String previsaoTermino;
    private String dataRealTermino;
    private BigDecimal orcamentoTotal;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private StatusProjeto status;

    @Enumerated(EnumType.STRING)
    private ClassificacaoRisco classificacaoRisco;

    @OneToMany(mappedBy = "projeto")
    private List<Membro> membros = new ArrayList<>();

    public Projeto() {
    }

    public Projeto(Long id, String nome, Gerente gerenteResponsavel, String dataInicio, String previsaoTermino, String dataRealTermino, BigDecimal orcamentoTotal, String descricao, StatusProjeto status, ClassificacaoRisco classificacaoRisco, List<Membro> membros) {
        this.id = id;
        this.nome = nome;
        this.gerenteResponsavel = gerenteResponsavel;
        this.dataInicio = dataInicio;
        this.previsaoTermino = previsaoTermino;
        this.dataRealTermino = dataRealTermino;
        this.orcamentoTotal = orcamentoTotal;
        this.descricao = descricao;
        this.status = status;
        this.classificacaoRisco = classificacaoRisco;
        this.membros = membros;
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

    public Gerente getGerenteResponsavel() {
        return gerenteResponsavel;
    }

    public void setGerenteResponsavel(Gerente gerenteResponsavel) {
        this.gerenteResponsavel = gerenteResponsavel;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getPrevisaoTermino() {
        return previsaoTermino;
    }

    public void setPrevisaoTermino(String previsaoTermino) {
        this.previsaoTermino = previsaoTermino;
    }

    public String getDataRealTermino() {
        return dataRealTermino;
    }

    public void setDataRealTermino(String dataRealTermino) {
        this.dataRealTermino = dataRealTermino;
    }

    public BigDecimal getOrcamentoTotal() {
        return orcamentoTotal;
    }

    public void setOrcamentoTotal(BigDecimal orcamentoTotal) {
        this.orcamentoTotal = orcamentoTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusProjeto getStatus() {
        return status;
    }

    public void setStatus(StatusProjeto status) {
        this.status = status;
    }

    public ClassificacaoRisco getClassificacaoRisco() {
        return classificacaoRisco;
    }

    public void setClassificacaoRisco(ClassificacaoRisco classificacaoRisco) {
        this.classificacaoRisco = classificacaoRisco;
    }

    public List<Membro> getMembros() {
        return membros;
    }

    public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projeto projeto = (Projeto) o;
        return Objects.equals(id, projeto.id) && Objects.equals(nome, projeto.nome) && Objects.equals(gerenteResponsavel, projeto.gerenteResponsavel) && Objects.equals(dataInicio, projeto.dataInicio) && Objects.equals(previsaoTermino, projeto.previsaoTermino) && Objects.equals(dataRealTermino, projeto.dataRealTermino) && Objects.equals(orcamentoTotal, projeto.orcamentoTotal) && Objects.equals(descricao, projeto.descricao) && status == projeto.status && classificacaoRisco == projeto.classificacaoRisco && Objects.equals(membros, projeto.membros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, gerenteResponsavel, dataInicio, previsaoTermino, dataRealTermino, orcamentoTotal, descricao, status, classificacaoRisco, membros);
    }
}
