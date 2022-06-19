package br.com.rafael.q09;

import java.util.Date;
import java.util.Calendar;


public class Produto {
    //private int id;
    private String nome;
    private String descricao;
    private double desconto;
    private double preco;
   // private Date data;


    public Produto( String nome, String descricao, float desconto, float preco) {
       // this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.desconto = desconto;
        this.preco = preco;
       // this.data = data;
    }

    public Produto() {
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

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
