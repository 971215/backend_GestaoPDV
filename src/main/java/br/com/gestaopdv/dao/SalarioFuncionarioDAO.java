/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.dao;

import br.com.gestaopdv.model.Produto;
import br.com.gestaopdv.model.SalarioFuncionario;
import br.com.gestaopdv.util.JpaUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author andre
 */
public class SalarioFuncionarioDAO implements OperacaoDAO<SalarioFuncionario>{

   
    
    private static EntityManager sessao = JpaUtil.getEntityManager();

    private SalarioFuncionario salarioFuncionario;

    @Override
    public void insert(SalarioFuncionario entity) {
        sessao.getTransaction().begin();
        sessao.persist(entity);
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void update(SalarioFuncionario entity) {
        sessao.getTransaction().begin();
        sessao.merge(entity);
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void delete(int id) {
        try {
            salarioFuncionario = selectOne(id);
            sessao.getTransaction().begin();
            sessao.remove(salarioFuncionario);
            sessao.getTransaction().commit();
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessao.close();
    }

    @Override
    public SalarioFuncionario selectOne(int id) throws Exception {
        return sessao.find(SalarioFuncionario.class, id);
    }

    @Override
    public List<SalarioFuncionario> selectAll() {
        List<SalarioFuncionario> salarioFuncionarios = null;
        try {
            salarioFuncionarios = sessao.createQuery("from SalarioFuncionario u").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return salarioFuncionarios;
    }
    
    
    
}
