/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.util;

/**
 *
 * @author andre
 */
public class CalculadoraPrecoUtil {

    private double orcamentoMes;
    private double totalDespesas;
    private int quantidadeProduto;
    private double valorCompra;
    private double percentualLucro;
    private double precoQuantidade;
    private double percentualUtilizadoOrcamentoMes;
    private double valorUtilizadoDespesaMes;
    private double precoSemLucro;
    private double precoRecomendado;

    public double getOrcamentoMes() {
        if (orcamentoMes == 0) {
            throw new RuntimeException("O orçamento para o mês vigente está zerado ou não foi cadastrado!");
        }
        return orcamentoMes;
    }

    public void setOrcamentoMes(double orcamentoMes) {
        this.orcamentoMes = orcamentoMes;
    }

    public double getTotalDespesas() {
        return totalDespesas;
    }

    public void setTotalDespesas(double totalDespesas) {
        this.totalDespesas = totalDespesas;
    }

    public int getQuantidadeProduto() {
         if (quantidadeProduto == 0) {
            throw new RuntimeException("Quantidade obriga!");
        }
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getPercentualLucro() {
        return percentualLucro;
    }

    public void setPercentualLucro(double percentualLucro) {
        this.percentualLucro = percentualLucro;
    }

    public double getPrecoQuantidade() {
        return getValorCompra() * getQuantidadeProduto();
    }

    /*
    public void setPrecoQuantidade(double precoQuantidade) {
        this.precoQuantidade = precoQuantidade;
    }
     */

    //calculando qual a porcentagem do orçamento a compra do estoque utilizou
    public double getPercentualUtilizadoOrcamentoMes() {
        return (getOrcamentoMes() / getPrecoQuantidade() / 100) / 100;
    }

    /*
    public void setPercentualUtilizadoOrcamentoMes(double percentualUtilizadoOrcamentoMes) {
        this.percentualUtilizadoOrcamentoMes = percentualUtilizadoOrcamentoMes;
    }
     */

    //calculando qual o valor da despesa referente ao percentualUtilizadoOrcamentoMes
    public double getValorUtilizadoDespesaMes() {
        return getTotalDespesas() * getPercentualUtilizadoOrcamentoMes();
    }

    public double getPrecoSemLucro() {
        return (getPrecoQuantidade() + getValorUtilizadoDespesaMes()) / getQuantidadeProduto();
    }

   /* public void setPrecoSemLucro(double precoSemLucro) {
        this.precoSemLucro = precoSemLucro;
    }*/

    public double getPrecoRecomendado() {
        return  getPrecoSemLucro() + (getPrecoSemLucro() * getPercentualLucro());
    }

   /* public void setPrecoRecomendado(double precoRecomendado) {
        this.precoRecomendado = precoRecomendado;
    }*/

    public double getPrecoVendaProduto() {
        if (orcamentoMes == 0) {
            throw new RuntimeException("O orçamento para o mês vigente está zerado ou não foi cadastrado!");
        }
//        this.orcamentoMes = orcamentoMes;
//        this.percentualLucro = percentualLucro;
//        this.quantidadeProduto = quantidadeProduto;
//        this.totalDespesas = totalDespesas;
//        this.valorCompra = valorCompra;

        double precoQuantidade = valorCompra * quantidadeProduto;
        //calculando qual a porcentagem do orçamento a compra do estoque utilizou
        double percentualUtilizadoOrcamentoMes = (orcamentoMes / precoQuantidade / 100) / 100;
        //calculando qual o valor da despesa referente ao percentualUtilizadoOrcamentoMes
        double valorUtilizadoDespesaMes = totalDespesas * percentualUtilizadoOrcamentoMes;
        double precoSemLucro = (precoQuantidade + valorUtilizadoDespesaMes) / quantidadeProduto;
        double precoRecomendado = precoSemLucro + (precoSemLucro * percentualLucro);

        return precoRecomendado;
    }
    
 

    public static void main(String[] args) {
        CalculadoraPrecoUtil calculadoraPrecoUtil =  new CalculadoraPrecoUtil();
    
        double orcamentoMes = 0;
        double totalDespesa = 10000;
        int quantidadeProduto = 100;
        double valorProduto = 2;
        double percLucro = 0.10;
        try {
    calculadoraPrecoUtil.setTotalDespesas(totalDespesa);
    calculadoraPrecoUtil.setPercentualLucro(percLucro);
    calculadoraPrecoUtil.setQuantidadeProduto(quantidadeProduto);
    calculadoraPrecoUtil.setOrcamentoMes(orcamentoMes);
    calculadoraPrecoUtil.setValorCompra(valorProduto);
            System.out.println("====== "+calculadoraPrecoUtil.getPrecoRecomendado());
           // System.out.println("==== " + calculadoraPrecoUtil.getPrecoVendaProduto(orcamentoMes, totalDespesa, quantidadeProduto, valorProduto, percLucro));

        } catch (Exception e) {
            System.err.println("erro = " + e.getMessage());
        }

    }
}


