/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author G0041901
 */
@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int cod_produto;
    private String titulo;
    private double preco;
    private String descricao;
    private String categoria;
    private String imagem;
    private double nota;
    private int quantidade;
    
    public Produto(){
        super();
    }

    public Produto(int cod_produto, String titulo, double preco, String descricao, String categoria, String imagem, double nota, int quantidade) {
        this.cod_produto = cod_produto;
        this.titulo = titulo;
        this.preco = preco;
        this.descricao = descricao;
        this.categoria = categoria;
        this.imagem = imagem;
        this.nota = nota;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }   
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public String getJson(){
        String json = "{";        
        json += "\"cod_produto\":"+cod_produto+",";
        json += "\"titulo\":\""+titulo+"\",";
        json += "\"preco\":"+preco+",";
        json += "\"descricao\":\""+descricao+"\",";
        json += "\"categoria\":\""+categoria+"\",";
        json += "\"imagem\":\""+imagem+"\",";
        json += "\"nota\":"+nota+",";
        json += "\"quantidade\":"+quantidade;
        json += '}';
        
        return json;
    }

}
