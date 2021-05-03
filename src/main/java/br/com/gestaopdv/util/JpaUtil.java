/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author andre
 */
public class JpaUtil {
    
     
    private static EntityManagerFactory fabrica =  Persistence.createEntityManagerFactory("persistencia-jpa");
    
    public static EntityManager getEntityManager(){
        EntityManager sessao = fabrica.createEntityManager();
        return sessao;
        
    }
    
    
}
