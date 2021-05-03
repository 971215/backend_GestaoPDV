/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.exceptions;

/**
 *
 * @author andre
 */
public class NegocioException extends RuntimeException{

    private String msg;
    public NegocioException(String msg) {
        this.msg =msg;
    }
    
    
}
