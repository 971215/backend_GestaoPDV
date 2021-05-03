/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.dao;

import br.com.gestaopdv.exceptions.NegocioException;
import br.com.gestaopdv.model.Usuario;
import br.com.gestaopdv.util.JpaUtil;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author andre
 */
public class AutenticacaoDAO {

    private static EntityManager sessao = JpaUtil.getEntityManager();

    public Usuario getLogin(String login, String senha) throws RuntimeException {
        Usuario usuario = (Usuario) sessao.createQuery(
                "SELECT u from Usuario u where u.login = :login and u.senha = :senha")
                .setParameter("login", login)
                .setParameter("senha", senha).getSingleResult();
        
        return usuario;

    }

}
