/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.dao;

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
public class UsuarioDAO implements OperacaoDAO<Usuario> {

    private static EntityManager sessao = JpaUtil.getEntityManager();

    private Usuario usuario;

    @Override
    public void insert(Usuario entity) {
        sessao.getTransaction().begin();
        sessao.persist(entity);
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void update(Usuario entity) {
        sessao.getTransaction().begin();
        sessao.merge(entity);
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void delete(int id) {
        try {
            usuario = selectOne(id);
            sessao.getTransaction().begin();
            sessao.remove(usuario);
            sessao.getTransaction().commit();
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessao.close();
    }

    @Override
    public Usuario selectOne(int id) throws Exception {
        return sessao.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> selectAll() {
        List<Usuario> usuarios = null;
        try {
            usuarios = sessao.createQuery("from Usuario u").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return usuarios;
    }

}
