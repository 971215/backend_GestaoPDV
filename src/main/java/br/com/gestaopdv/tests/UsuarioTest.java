/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.tests;

import br.com.gestaopdv.services.UsuarioService;
import br.com.gestaopdv.dao.AutenticacaoDAO;
import br.com.gestaopdv.dao.UsuarioDAO;
import br.com.gestaopdv.model.Usuario;
import javax.persistence.NoResultException;

/**
 *
 * @author andre
 */
public class UsuarioTest {
    
     public static void main(String[] args)  {
        //UsuarioDAO usuarioDAO = new UsuarioDAO();
         UsuarioService service =  new UsuarioService(new UsuarioDAO(), new AutenticacaoDAO());
        //Usuario u = new Usuario(null, "Leidiane Brito", 2, "testando", "12345");
        //service.salvar(u);
        Usuario u;
        try{
        u = service.getUsuario("admin", "admin");
        }catch(RuntimeException e){
            System.out.println("Mensagem = "+e.getMessage());
        }
    }
}
