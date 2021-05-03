/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.criptografia;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author andre
 */
public class Criptografia {
    
    public static String criptografarSenha(String senha) {
        MessageDigest md = null;
        String retorno = "";
      try{
            md = MessageDigest.getInstance("MD5");
            BigInteger hash  =  new BigInteger(1, md.digest(senha.getBytes()));
            retorno =  hash.toString(16);
      }catch(NoSuchAlgorithmException e){
          retorno = null;
      }
        return retorno;
    }
}
