/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.dao;

import br.com.gestaopdv.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author andre
 */
public interface OperacaoDAO <Entity>{
 
    void insert(Entity entity);
    void update(Entity entity);
    void delete(int id);
    Entity selectOne(int id) throws Exception;
    List<Entity> selectAll();
    
}
