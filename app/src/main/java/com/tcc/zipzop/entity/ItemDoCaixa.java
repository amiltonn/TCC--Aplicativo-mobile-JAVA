package com.tcc.zipzop.entity;

public class ItemDoCaixa {

    private Long id;
    private String nome;
    private Integer qtdSelecionada;

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

    public Integer getQtdSelecionada() {
        return qtdSelecionada;
    }

    public void setQtdSelecionada(Integer qtdSelecionada) {
        this.qtdSelecionada = qtdSelecionada;
    }
}
