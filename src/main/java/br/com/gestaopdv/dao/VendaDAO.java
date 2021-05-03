/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.dao;

import br.com.gestaopdv.model.Categoria;
import br.com.gestaopdv.model.Venda;
import br.com.gestaopdv.util.JpaUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author andre
 */
public class VendaDAO implements OperacaoDAO<Venda> {

    private static EntityManager sessao = JpaUtil.getEntityManager();

    private Venda venda;

    @Override
    public void insert(Venda entity) {
        sessao.getTransaction().begin();
        sessao.persist(entity);
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void update(Venda entity) {
        sessao.getTransaction().begin();
        sessao.merge(entity);
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void delete(int id) {
        try {
            venda = selectOne(id);
            sessao.getTransaction().begin();
            sessao.remove(venda);
            sessao.getTransaction().commit();
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessao.close();
    }

    @Override
    public Venda selectOne(int id) throws Exception {
        return sessao.find(Venda.class, id);
    }

    @Override
    public List<Venda> selectAll() {
        List<Venda> vendas = null;
        try {
            vendas = sessao.createQuery("from Venda u").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return vendas;
    }
}
