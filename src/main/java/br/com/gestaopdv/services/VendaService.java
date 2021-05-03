/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.services;

import br.com.gestaopdv.dao.ProdutoDAO;
import br.com.gestaopdv.dao.VendaDAO;
import br.com.gestaopdv.dao.VendaProdutoDAO;
import br.com.gestaopdv.model.Categoria;
import br.com.gestaopdv.model.Produto;
import br.com.gestaopdv.model.Venda;
import br.com.gestaopdv.model.VendaProduto;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class VendaService {

    private ProdutoDAO produtoDAO;
    private VendaDAO vendaDAO;
    private VendaProdutoDAO vendaProdutoDAO;
    private Venda venda;
    private VendaProduto vendaProduto;
    private List<Produto> produtos = new ArrayList<Produto>();

    public VendaService(ProdutoDAO produtoDAO, VendaDAO vendaDAO, VendaProdutoDAO vendaProdutoDAO) {
        this.produtoDAO = produtoDAO;
        this.vendaDAO = vendaDAO;
        this.vendaProdutoDAO = vendaProdutoDAO;
        venda = new Venda();
        vendaProduto = new VendaProduto();
    }

    public void salvarVendaProduto(VendaProduto vendaProduto) {
        vendaProdutoDAO.insert(vendaProduto);
    }

    public void adicionarProdutoLista(Produto produto) {
        produtos.add(produto);
    }

    public void salvarVenda() {
        venda.setId(null);
        venda.setTotal(getTotalVenda());
        vendaDAO.insert(venda);

    }

    public void salvarVendaProduto() {
        int i = 10;
        for (Produto p : produtos) {
            i += 1;
            vendaProduto.setId(null);
            vendaProduto.setProdutos_codigoBarras(p.getCodigoBarras());
            vendaProduto.setQuantidade(p.getQuantidadeVendido());
            vendaProduto.setVenda_id(venda.getId());
            //vendaProdutoDAO.insert(vendaProduto);
            System.out.println("vendaProduto "+vendaProduto.getId());
            salvarVendaProduto(vendaProduto);
        }
    }

    public double getTotalVenda() {
        double retorno = 0;
        for (Produto p : produtos) {
            retorno += (p.getPreco() * p.getQuantidadeVendido());
        }
        return retorno;

    }

    public static void main(String[] args) {
        VendaService vendaService = new VendaService(new ProdutoDAO(), new VendaDAO(), new VendaProdutoDAO());

        Categoria categoria = new Categoria(1, "bebidas");
        Produto p1 = new Produto("010101010100", "cerveja", "brahma", 3.5, 4, 5, categoria);
        Produto p2 = new Produto("010101010101", "cerveja 2", "qualquer", 3.00, 6, 2, categoria);
        vendaService.adicionarProdutoLista(p1);
        vendaService.adicionarProdutoLista(p2);
        vendaService.getTotalVenda();
        vendaService.salvarVenda();
        vendaService.salvarVendaProduto();

    }
}
