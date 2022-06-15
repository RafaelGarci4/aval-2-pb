package br.com.rafael.q09;

import java.util.Date;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private float desconto;
    private float preco;
    private Date data;

    public Produto(int id, String nome, String descricao, float desconto, float preco, Date data) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.desconto = desconto;
        this.preco = preco;
        this.data = data;
    }

    public Produto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
