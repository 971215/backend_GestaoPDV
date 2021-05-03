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
public class UsuarioService {

    private UsuarioDAO usuarioDAO;
    private AutenticacaoDAO autenticacaoDAO;

    public UsuarioService(UsuarioDAO usuarioDAO, AutenticacaoDAO autenticacaoDAO) {
        this.usuarioDAO = usuarioDAO;
        this.autenticacaoDAO = autenticacaoDAO;
    }

    public void salvar(Usuario usuario) {
        usuarioDAO.insert(usuario);
    }

    public void alterar(Usuario usuario) {
        usuarioDAO.update(usuario);
    }

    public Usuario consultar(int id) throws Exception {
        return usuarioDAO.selectOne(id);
    }

    public void remover(int id) {
        usuarioDAO.delete(id);
    }

    public List<Usuario> listar() {
        return usuarioDAO.selectAll();
    }

    public Usuario getUsuario(String login, String senha) throws RuntimeException {
        return autenticacaoDAO.getLogin(login, Criptografia.criptografarSenha(senha));
    }

}
