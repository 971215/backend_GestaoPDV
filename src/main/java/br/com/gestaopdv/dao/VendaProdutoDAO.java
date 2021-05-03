/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.dao;

import br.com.gestaopdv.model.Venda;
import br.com.gestaopdv.model.VendaProduto;
import br.com.gestaopdv.util.JpaUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author andre
 */
public class VendaProdutoDAO  implements  OperacaoDAO<VendaProduto>{
 
     private static EntityManager sessao = JpaUtil.getEntityManager();

    private VendaProduto vendaProduto;

    @Override
    public void insert(VendaProduto entity) {
        sessao.getTransaction().begin();
        sessao.persist(entity);
        sessao.getTransaction().commit();
       // sessao.close();
    }

    @Override
    public void update(VendaProduto entity) {
        sessao.getTransaction().begin();
        sessao.merge(entity);
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void delete(int id) {
        try {
            vendaProduto = selectOne(id);
            sessao.getTransaction().begin();
            sessao.remove(vendaProduto);
            sessao.getTransaction().commit();
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessao.close();
    }

    @Override
    public VendaProduto selectOne(int id) throws Exception {
        return sessao.find(VendaProduto.class, id);
    }

    @Override
    public List<VendaProduto> selectAll() {
        List<VendaProduto> vendaProdutos= null;
        try {
            vendaProdutos = sessao.createQuery("from VendaProduto u").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return vendaProdutos;
    }
}
