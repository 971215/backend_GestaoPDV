/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.services;

import br.com.gestaopdv.criptografia.Criptografia;
import br.com.gestaopdv.dao.ProdutoDAO;
import br.com.gestaopdv.model.Produto;
import br.com.gestaopdv.model.Usuario;
import java.util.List;

/**
 *
 * @author andre
 */
public class ProdutoService {
    
    private ProdutoDAO produtoDAO;
    
    
    public ProdutoService(ProdutoDAO produtoDAO){
        this.produtoDAO = produtoDAO;
    }
    
    public void salvar(Produto produto) {
        produtoDAO.insert(produto);
    }

    public void alterar(Produto produto) {
        produtoDAO.update(produto);
    }

    public Produto consultar(int id) throws Exception {
        return produtoDAO.selectOne(id);
    }

    public void remover(int id) {
        produtoDAO.delete(id);
    }

    public List<Produto> listar() {
        return produtoDAO.selectAll();
    }

 
}
