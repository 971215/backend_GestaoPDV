/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.util;

import br.com.gestaopdv.model.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.internal.SessionFactoryImpl;

/**
 *
 * @author andre
 */
public class JDBCUtil {

    private static EntityManager sessao = JpaUtil.getEntityManager();

    public static Connection conector() {

        Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String nomeBanco = "projeto_gestao";
        String url = "jdbc:mysql://localhost:3306/" + nomeBanco;
        String usuario = "root";
        String senha = "";

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            return conexao;
        } catch (Exception e) {
            System.out.println("Erro = " + e.getMessage());
            return null;
        }

    }

    public static void main(String[] args) {
        conector();
    
    }

   public static Connection conectorTeste() {

        Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String nomeBanco = "projeto_gestao";
        String url = "jdbc:mysql://localhost:3306/" + nomeBanco;
        String usuario = "root";
        String senha = "";

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            return conexao;
        } catch (Exception e) {
            System.out.println("Erro = " + e.getMessage());
            return null;
        }

    }
   
}
