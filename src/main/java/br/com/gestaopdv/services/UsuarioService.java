/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.services;

import br.com.gestaopdv.criptografia.Criptografia;
import br.com.gestaopdv.dao.AutenticacaoDAO;
import br.com.gestaopdv.model.Usuario;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import br.com.gestaopdv.dao.OperacaoDAO;
import br.com.gestaopdv.dao.UsuarioDAO;
import java.util.List;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class UsuarioService extends GenericService<Usuario>{

    private AutenticacaoDAO autenticacaoDAO;

    public UsuarioService(OperacaoDAO operacaoDAO, AutenticacaoDAO autenticacaoDAO) {
        this.operacaoDAO = operacaoDAO;
        this.autenticacaoDAO = autenticacaoDAO;
    }

    public Usuario getUsuario(String login, String senha) throws RuntimeException {
        return autenticacaoDAO.getLogin(login, Criptografia.criptografarSenha(senha));
    }

}
