/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.dao;

import br.com.gestaopdv.model.Categoria;
import br.com.gestaopdv.model.Produto;
import br.com.gestaopdv.util.JpaUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author andre
 */
public class ProdutoDAO implements OperacaoDAO<Produto>{
    
     private static EntityManager sessao = JpaUtil.getEntityManager();

    private Produto produto;

    @Override
    public void insert(Produto entity) {
        sessao.getTransaction().begin();
        sessao.persist(entity);
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void update(Produto entity) {
        sessao.getTransaction().begin();
        sessao.merge(entity);
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void delete(int id) {
        try {
            produto = selectOne(id);
            sessao.getTransaction().begin();
            sessao.remove(produto);
            sessao.getTransaction().commit();
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessao.close();
    }

    @Override
    public Produto selectOne(int id) throws Exception {
        return sessao.find(Produto.class, id);
    }

    @Override
    public List<Produto> selectAll() {
        List<Produto> produtos = null;
        try {
            produtos = sessao.createQuery("from Produto u").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return produtos;
    }
    
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto p =  new Produto();
        Categoria c =  new Categoria();
        
        p.setCodigoBarras("010101010100");
        p.setDescricao("arroz");
        p.setMarca("fake");
        p.setQuantidadeEstoque(100);
        p.setPreco(4.0);
        p.setQuantidadeVendido(0);
        c.setId(1);
        p.setCategoria(c);
        
        produtoDAO.insert(p);
        System.out.println("Salvou");
    }
    
}
