/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.services;

import br.com.gestaopdv.dao.OperacaoDAO;
import br.com.gestaopdv.model.Usuario;
import java.util.List;

/**
 *
 * @author andre
 */
public abstract class GenericService<Entity> {

    protected OperacaoDAO operacaoDAO;

    public void salvar(Entity entity) {
        operacaoDAO.insert(entity);
    }

    public void alterar(Entity entity) {
        operacaoDAO.update(entity);
    }

    public Entity consultar(int id) throws Exception {
        return (Entity) operacaoDAO.selectOne(id);
    }

    public void remover(int id) {
        operacaoDAO.delete(id);
    }

    public List<Entity> listar() {
        return operacaoDAO.selectAll();
    }
}
