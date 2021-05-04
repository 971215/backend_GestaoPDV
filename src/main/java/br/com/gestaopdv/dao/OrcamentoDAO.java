/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.dao;

import br.com.gestaopdv.model.Orcamento;
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
public class OrcamentoDAO implements OperacaoDAO<Orcamento>{

    private static EntityManager sessao = JpaUtil.getEntityManager();

    private Orcamento orcamento;

    @Override
    public void insert(Orcamento entity) {
        sessao.getTransaction().begin();
        sessao.persist(entity);
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void update(Orcamento entity) {
        sessao.getTransaction().begin();
        sessao.merge(entity);
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void delete(int id) {
        try {
            orcamento = selectOne(id);
            sessao.getTransaction().begin();
            sessao.remove(orcamento);
            sessao.getTransaction().commit();
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            Logger.getLogger(OrcamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessao.close();
    }

    @Override
    public Orcamento selectOne(int id) throws Exception {
        return sessao.find(Orcamento.class, id);
    }

    @Override
    public List<Orcamento> selectAll() {
        List<Orcamento> orcamentos = null;
        try {
            orcamentos = sessao.createQuery("from Orcamento u").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return orcamentos;
    }
    
}
