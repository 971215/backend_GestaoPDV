/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.dao;

import br.com.gestaopdv.model.Categoria;
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
public class CategoriaDAO implements OperacaoDAO<Categoria>{

    private static EntityManager sessao = JpaUtil.getEntityManager();

    private Categoria categoria;

    @Override
    public void insert(Categoria entity) {
        sessao.getTransaction().begin();
        sessao.persist(entity);
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void update(Categoria entity) {
        sessao.getTransaction().begin();
        sessao.merge(entity);
        sessao.getTransaction().commit();
        sessao.close();
    }

    @Override
    public void delete(int id) {
        try {
            categoria = selectOne(id);
            sessao.getTransaction().begin();
            sessao.remove(categoria);
            sessao.getTransaction().commit();
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessao.close();
    }

    @Override
    public Categoria selectOne(int id) throws Exception {
        return sessao.find(Categoria.class, id);
    }

    @Override
    public List<Categoria> selectAll() {
        List<Categoria> categorias = null;
        try {
            categorias = sessao.createQuery("from Categoria u").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return categorias;
    }
    
    public static void main(String[] args) {
        CategoriaDAO categoriaDAO =  new CategoriaDAO();
        Categoria categoria =  new Categoria();
        for(Categoria c : categoriaDAO.selectAll()){
          
    }
        
    }
    
}
