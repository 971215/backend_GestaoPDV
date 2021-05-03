/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.dao;

import br.com.gestaopdv.model.Despesa;
import br.com.gestaopdv.model.Usuario;
import br.com.gestaopdv.util.JpaUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author andre
 */
public class DespesaDAO implements OperacaoDAO<Despesa>{

     private static EntityManager sessao = JpaUtil.getEntityManager();

    private Despesa despesa;

    @Override
    public void insert(Despesa entity) {
        sessao.getTransaction().begin();
        sessao.persist(entity);
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void update(Despesa entity) {
        sessao.getTransaction().begin();
        sessao.merge(entity);
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void delete(int id) {
        try {
            despesa = selectOne(id);
            sessao.getTransaction().begin();
            sessao.remove(despesa);
            sessao.getTransaction().commit();
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessao.close();
    }

    @Override
    public Despesa selectOne(int id) throws Exception {
        return sessao.find(Despesa.class, id);
    }

    @Override
    public List<Despesa> selectAll() {
        List<Despesa> despesas = null;
        try {
            despesas = sessao.createQuery("from Despesa u").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return despesas;
    }
    
    public static void main(String[] args) {
        DespesaDAO despesaDAO = new DespesaDAO();
        Despesa d = new Despesa();
        d.setId(null);
        d.setMes(3);
        d.setAno(2021);
        d.setTotalDespesa(0.0);
        despesaDAO.insert(d);
    }
}
