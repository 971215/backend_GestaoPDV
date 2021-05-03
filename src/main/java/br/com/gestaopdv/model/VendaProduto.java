/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "tb_venda_tb_produto")
public class VendaProduto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;        
    private Integer Venda_id;
    private String produtos_codigoBarras;
    private Integer quantidade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVenda_id() {
        return Venda_id;
    }

    public void setVenda_id(Integer Venda_id) {
        this.Venda_id = Venda_id;
    }

    public String getProdutos_codigoBarras() {
        return produtos_codigoBarras;
    }

    public void setProdutos_codigoBarras(String produtos_codigoBarras) {
        this.produtos_codigoBarras = produtos_codigoBarras;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
