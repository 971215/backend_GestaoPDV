/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.tests;

/**
 *
 * @author andre
 */
public class NewClass {

    public static void main(String[] args) {

        double orcamentoMes = 40000;
        double totalDespesa = 7900;
        int quantidadeProduto = 100;
        double valorProduto = 3.2;
        double percLucro = 0.15;
        double precoQuantidade = valorProduto * quantidadeProduto;
        double percDescontoOrcamento = orcamentoMes / precoQuantidade / 100;
        double valorLucro = (orcamentoMes / (precoQuantidade + totalDespesa));
double precoSugerido = valorLucro + (valorLucro * percLucro);

        System.out.println(precoSugerido);

    }
}
