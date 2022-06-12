package com.tcc.zipzop.entity;

import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Produto implements Serializable {

    @PrimaryKey
    @NonNull
    private Integer id;
    private String nome;
    private Integer qtd;
    // Float ? https://stackoverflow.com/questions/9364399/storing-floating-point-numbers-in-android-database
    private Float custo;
    private Float preco;
    private Boolean ativo = (true);
    private Boolean atual = (true);
    private String dataAlteracao;
    private Integer produtoAntesId;
    // FK
    private Integer unidadeMedidaId;

    private Integer formulaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Float getCusto() {
        return custo;
    }

    public void setCusto(Float custo) {
        this.custo = custo;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getAtual() {
        return atual;
    }

    public void setAtual(Boolean atual) {
        this.atual = atual;
    }

    public String getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(String data_alteracao) {
        this.dataAlteracao = data_alteracao;
    }

    public Integer getProdutoAntesId() {
        return produtoAntesId;
    }

    public void setProdutoAntesId(Integer produtoAntesId) {
        this.produtoAntesId = produtoAntesId;
    }

    public Integer getUnidadeMedidaId() {
        return unidadeMedidaId;
    }

    public void setUnidadeMedidaId(Integer unidadeMedidaId) {
        this.unidadeMedidaId = unidadeMedidaId;
    }

    public Integer getFormulaId() {
        return formulaId;
    }

    public void setFormulaId(Integer formulaId) {
        this.formulaId = formulaId;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.nome + " - " + this.qtd;
    }

}