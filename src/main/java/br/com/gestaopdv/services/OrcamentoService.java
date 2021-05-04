/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.services;

import br.com.gestaopdv.dao.OperacaoDAO;
import br.com.gestaopdv.dao.OrcamentoDAO;
import br.com.gestaopdv.model.Orcamento;

/**
 *
 * @author andre
 */
public class OrcamentoService extends GenericService<Orcamento>{
    
    public OrcamentoService(OperacaoDAO operacaoDAO){
    this.operacaoDAO = operacaoDAO;
    }   
    public static void main(String[] args) {
        OrcamentoService orcamentoService = new OrcamentoService(new OrcamentoDAO());
        Orcamento o =  new Orcamento();
        o.setId(null);
        o.setReferencia("202101");
        o.setValor(20000.00);
        orcamentoService.salvar(o);
    }
            
}
