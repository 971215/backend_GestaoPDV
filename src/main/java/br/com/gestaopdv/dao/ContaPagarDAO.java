/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.dao;

import br.com.gestaopdv.model.ContaPagar;
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
public class ContaPagarDAO implements OperacaoDAO<ContaPagar>{

    private static EntityManager sessao = JpaUtil.getEntityManager();

    private ContaPagar contaPagar;

    @Override
    public void insert(ContaPagar entity) {
        sessao.getTransaction().begin();
        sessao.persist(entity);
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void update(ContaPagar entity) {
        sessao.getTransaction().begin();
        sessao.merge(entity);
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void delete(int id) {
        try {
            contaPagar = selectOne(id);
            sessao.getTransaction().begin();
            sessao.remove(contaPagar);
            sessao.getTransaction().commit();
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessao.close();
    }

    @Override
    public ContaPagar selectOne(int id) throws Exception {
        return sessao.find(ContaPagar.class, id);
    }

    @Override
    public List<ContaPagar> selectAll() {
        List<ContaPagar> contasPagar = null;
        try {
            contasPagar = sessao.createQuery("from Produto u").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return contasPagar;
    }
    
}
