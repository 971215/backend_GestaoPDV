/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author andre
 */
@Entity
@Table(name="tb_produto")
public class Produto {
    
    @Id
    private String codigoBarras;
    private String descricao;
    private String marca;
    private Double preco;
    private Integer quantidadeEstoque;
    private Integer quantidadeVendido;
    @ManyToOne
    private Categoria categoria;


    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Integer getQuantidadeVendido() {
        return quantidadeVendido;
    }

    public void setQuantidadeVendido(Integer quantidadeVendido) {
        this.quantidadeVendido = quantidadeVendido;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Produto(String codigoBarras, String descricao, String marca, Double preco, Integer quantidadeEstoque, Integer quantidadeVendido, Categoria categoria) {
        this.codigoBarras = codigoBarras;
        this.descricao = descricao;
        this.marca = marca;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeVendido = quantidadeVendido;
        this.categoria = categoria;
    }
    public Produto(){
        
    }
    
    
    
}
