/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.services;

import br.com.gestaopdv.criptografia.Criptografia;
import br.com.gestaopdv.dao.OperacaoDAO;
import br.com.gestaopdv.dao.ProdutoDAO;
import br.com.gestaopdv.model.Categoria;
import br.com.gestaopdv.model.Produto;
import br.com.gestaopdv.model.Usuario;
import br.com.gestaopdv.util.CalculadoraPrecoUtil;
import java.util.List;

/**
 *
 * @author andre
 */
public class ProdutoService extends GenericService<Produto>{
    
    private OperacaoDAO operacaoDAO;
    //Desacoplar após os testes
    private CalculadoraPrecoUtil calculadoraPrecoUtil =  new CalculadoraPrecoUtil();
    
    
    public ProdutoService(OperacaoDAO operacaoDAO){
        this.operacaoDAO = operacaoDAO;
    }
    
    
    @Override
    public void salvar(Produto produto) {
         calculadoraPrecoUtil.setOrcamentoMes(20000);
        calculadoraPrecoUtil.setPercentualLucro(0.10);
        calculadoraPrecoUtil.setQuantidadeProduto(100);
        calculadoraPrecoUtil.setTotalDespesas(10000);
        calculadoraPrecoUtil.setValorCompra(produto.getPreco());
        produto.setPreco(calculadoraPrecoUtil.getPrecoRecomendado());
        try{
        operacaoDAO.insert(produto);
        }catch(Exception e){
            System.err.println("Erro = "+e.getMessage());
        }  
    }


    public static void main(String[] args) {
        ProdutoService service =  new ProdutoService(new ProdutoDAO());
       Produto p =  new Produto();
        Categoria c =  new Categoria();
        
        p.setCodigoBarras("999999999999");
        p.setDescricao("arroz");
        p.setMarca("fake");
        p.setQuantidadeEstoque(100);
        p.setPreco(2.0);
        p.setQuantidadeVendido(100);
        c.setId(1);
        p.setCategoria(c);
        service.salvar(p);
        System.out.println("Salvou");
    }
}
