package br.com.project3.app;

import br.com.project3.domain.Cliente;
import br.com.project3.dao.ClienteDAO;
import br.com.project3.domain.Produto;
import br.com.project3.dao.ProdutoDAO;

public class Main {
    public static void main(String[] args) throws Exception {
        // Exemplo de cadastro de Cliente
        ClienteDAO clienteDao = new ClienteDAO();
        clienteDao.cadastrar(new Cliente("Maria", "98765432100"));
        System.out.println("Cliente cadastrado com sucesso!");

        // Exemplo de cadastro de Produto
        ProdutoDAO produtoDao = new ProdutoDAO();
        produtoDao.cadastrar(new Produto("Teclado", "TEC123", 120.00));
        System.out.println("Produto cadastrado com sucesso!");
    }
}